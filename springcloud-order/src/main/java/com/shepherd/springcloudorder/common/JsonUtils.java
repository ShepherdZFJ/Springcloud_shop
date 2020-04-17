package com.shepherd.springcloudorder.common;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 18:45
 */
@Slf4j
public class JsonUtils {

    //json转List对象
    public static<T> List<T> josnToList(String json, Class<T>beanType){
        List<T>list = null;
        ObjectMapper mapper=new ObjectMapper();
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class,beanType);
            list = mapper.readValue(json,javaType);
        } catch (Exception e) {
            log.error("error:", e);
        }
        return list;

    }
}
