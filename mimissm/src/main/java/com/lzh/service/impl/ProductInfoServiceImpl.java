package com.lzh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzh.mapper.ProductInfoMapper;
import com.lzh.pojo.ProductInfo;
import com.lzh.pojo.ProductInfoExample;
import com.lzh.pojo.vo.ProductInfoVo;
import com.lzh.service.ProductInfoService;
import com.lzh.pojo.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {

        ProductInfoExample productInfoExample = new ProductInfoExample();
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(productInfoExample);
        return productInfos;
    }



    @Override
    public PageInfo splitPage(int pageNum,int pageSize) {
        //分页设置
        PageHelper.startPage(pageNum,pageSize);

        ProductInfoExample example = new ProductInfoExample();
        example.setOrderByClause("p_id desc");
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(example);

        //集合数据封装
        PageInfo<ProductInfo> pageInfo = new PageInfo(productInfos);

        return pageInfo;
    }

    @Override
    public int save(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public ProductInfo getById(Integer id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public int delete(int pid) {
        return productInfoMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return productInfoMapper.deleteBatch(ids);
    }

    @Override
    public List<ProductInfo> selectCondition(ProductInfoVo productInfoVo) {
        return productInfoMapper.selectCondition(productInfoVo);
    }

    @Override
    public PageInfo splitPageVo(ProductInfoVo productInfoVo, int pageSize) {
        PageHelper.startPage(productInfoVo.getPage(),pageSize);
        List<ProductInfo> productInfos = productInfoMapper.selectCondition(productInfoVo);
        return new PageInfo<>(productInfos);
    }


}
