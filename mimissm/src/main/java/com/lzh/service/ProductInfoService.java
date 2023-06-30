package com.lzh.service;

import com.github.pagehelper.PageInfo;
import com.lzh.pojo.ProductInfo;
import com.lzh.pojo.vo.ProductInfoVo;

import java.util.List;

public interface ProductInfoService {

    List<ProductInfo> getAll();


    //分页功能
    PageInfo splitPage(int pageNum,int pageSize);

    int save(ProductInfo productInfo);

    ProductInfo getById(Integer id);

    int update(ProductInfo productInfo);

    int delete(int pid);

    int deleteBatch(String[] ids);

    List<ProductInfo> selectCondition(ProductInfoVo productInfoVo);

    PageInfo splitPageVo(ProductInfoVo productInfoVo, int pageSize);

}
