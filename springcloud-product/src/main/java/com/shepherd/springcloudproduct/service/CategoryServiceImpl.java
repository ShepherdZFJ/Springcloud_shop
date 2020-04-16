package com.shepherd.springcloudproduct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shepherd.springcloudproduct.api.service.CategoryService;
import com.shepherd.springcloudproduct.api.vo.CategoryVO;
import com.shepherd.springcloudproduct.common.Constant;
import com.shepherd.springcloudproduct.common.MsgConstant;
import com.shepherd.springcloudproduct.dao.CategoryDAO;
import com.shepherd.springcloudproduct.dao.ProductDAO;
import com.shepherd.springcloudproduct.dto.CategoryDTO;
import com.shepherd.springcloudproduct.entity.Category;
import com.shepherd.springcloudproduct.entity.Product;
import org.springframework.stereotype.Service;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 19:56
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDAO categoryDAO;
    @Resource
    private ProductDAO productDAO;
    @Override
    public CategoryVO getCategoryAndProduct() {
        CategoryVO categoryVO = new CategoryVO();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("is_delete", Constant.NOT_DEL);
        List<Category> categories = categoryDAO.selectList(categoryQueryWrapper);
        if(categories != null){
            for(Category category : categories){
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());
                QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
                productQueryWrapper.eq("is_delete",Constant.NOT_DEL);
                productQueryWrapper.eq("category_id",category.getId());
                List<Product> products = productDAO.selectList(productQueryWrapper);
                categoryDTO.setProductList(products);
                categoryDTOList.add(categoryDTO);
            }
        }
        categoryVO.setData(categoryDTOList);
        categoryVO.setCode(Constant.SUCCESS);
        categoryVO.setMsg(MsgConstant.RESULT_SUCCESS);
        return categoryVO;
    }
}
