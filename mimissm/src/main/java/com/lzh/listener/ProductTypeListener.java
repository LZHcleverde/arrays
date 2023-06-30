package com.lzh.listener;

import com.lzh.pojo.ProductType;
import com.lzh.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml","spring-service.xml");
        ProductTypeService productTypeService = (ProductTypeService) app.getBean("ProductTypeServiceImpl");
        List<ProductType> all = productTypeService.getAll();

        //放入全局作用域
        sce.getServletContext().setAttribute("typeList",all);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
