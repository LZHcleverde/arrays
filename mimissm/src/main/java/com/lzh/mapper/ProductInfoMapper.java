package com.lzh.mapper;

import com.github.pagehelper.PageInfo;
import com.lzh.pojo.ProductInfo;
import com.lzh.pojo.ProductInfoExample;
import com.lzh.pojo.vo.ProductInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper {
    long countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(ProductInfo row);

    int insertSelective(ProductInfo row);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("row") ProductInfo row, @Param("example") ProductInfoExample example);

    int updateByExample(@Param("row") ProductInfo row, @Param("example") ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo row);

    int updateByPrimaryKey(ProductInfo row);

    //批量删除
    int deleteBatch(String[] ids);

    List<ProductInfo> selectCondition(ProductInfoVo productInfoVo);

}