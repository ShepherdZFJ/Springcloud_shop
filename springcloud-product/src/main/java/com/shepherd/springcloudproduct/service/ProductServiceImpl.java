package com.shepherd.springcloudproduct.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shepherd.springcloudproduct.exception.BusinessException;
import com.shepherd.springcloudproduct.api.service.ProductService;
import com.shepherd.springcloudproduct.api.vo.ProductVO;
import com.shepherd.springcloudproduct.common.Constant;
import com.shepherd.springcloudproduct.common.MsgConstant;
import com.shepherd.springcloudproduct.dao.CategoryDAO;
import com.shepherd.springcloudproduct.dao.ProductDAO;
import com.shepherd.springcloudproduct.dto.CartDTO;
import com.shepherd.springcloudproduct.dto.ProductDTO;
import com.shepherd.springcloudproduct.entity.Category;
import com.shepherd.springcloudproduct.entity.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 20:06
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDAO productDAO;
    @Resource
    private CategoryDAO categoryDAO;
    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public List<Product> getProductList(List<Long> productIds) {
        List<Product> products = productDAO.selectBatchIds(productIds);
        return products;
    }

    @Override
    public ProductVO getProduct() {
        ProductVO productVO = new ProductVO();
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
        productQueryWrapper.eq("status", Constant.STATUS_ON);
        productQueryWrapper.eq("is_delete",Constant.NOT_DEL);
        List<Product> products = productDAO.selectList(productQueryWrapper);
        List<Long> categoryIds = products.stream().map(Product::getCategoryId).collect(Collectors.toList());

        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("is_delete",Constant.NOT_DEL);
        categoryQueryWrapper.in("id",categoryIds);
        List<Category> categories = categoryDAO.selectList(categoryQueryWrapper);

        //构造数据
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Category category: categories) {
            List<Product> productList = new ArrayList<>();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setCategoryName(category.getName());
            productDTO.setCategoryType(category.getId());
            for (Product product : products) {
                if(category.getId() == product.getCategoryId()){
                    productList.add(product);
                }
            }
            productDTO.setProductList(productList);
            productDTOList.add(productDTO);
        }
        productVO.setData(productDTOList);
        productVO.setCode(Constant.SUCCESS);
        productVO.setMsg(MsgConstant.RESULT_SUCCESS);
        return productVO;
    }

    @Override
    @Transactional()
    public void decreaseStock(List<CartDTO> cartList) {
        List<Product> list = new ArrayList<>();
        for(CartDTO cartDTO: cartList){
            Product product = productDAO.selectById(cartDTO.getProductId());
            if(product == null){
                throw new BusinessException(MsgConstant.PRODUCT_NOT_EXIST);
            }
            Integer stock = product.getStock()- cartDTO.getProductQuantity();
            if(stock < 0 ){
                throw new BusinessException(MsgConstant.PRODUCT_STOCK_LACK);
            }
            UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", cartDTO.getProductId());
            updateWrapper.set("stock", stock);
            int i = productDAO.update(new Product(), updateWrapper);
            product.setStock(stock);
            list.add(product);
        }
        amqpTemplate.convertAndSend("product", JSON.toJSONString(list));

    }
}
