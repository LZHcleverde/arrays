package com.lzh.service.impl;

import com.lzh.mapper.ProductTypeMapper;
import com.lzh.pojo.ProductType;
import com.lzh.pojo.ProductTypeExample;
import com.lzh.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }

}
