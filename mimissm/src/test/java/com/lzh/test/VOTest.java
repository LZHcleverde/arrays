package com.lzh.test;


import com.lzh.mapper.ProductInfoMapper;
import com.lzh.pojo.ProductInfo;
import com.lzh.pojo.vo.ProductInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-service.xml"})
public class VOTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Test
    public void testSelect(){
        ProductInfoVo productInfoVo = new ProductInfoVo();
        System.out.println(productInfoVo);
        List<ProductInfo> productInfos = productInfoMapper.selectCondition(productInfoVo);

        for (ProductInfo productInfo : productInfos) {
            System.out.println(productInfo);
        }

    }

}
