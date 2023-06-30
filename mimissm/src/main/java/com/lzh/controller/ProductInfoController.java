package com.lzh.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.github.pagehelper.PageInfo;
import com.lzh.pojo.ProductInfo;
import com.lzh.pojo.vo.ProductInfoVo;
import com.lzh.service.ProductInfoService;
import com.lzh.utils.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.json.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("prod")
public class ProductInfoController {

    //每页展示记录数
    public static final int PAGE_SIZE = 5;

    @Autowired
    private ProductInfoService productInfoService;

    String s = "";


    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){

        List<ProductInfo> all = productInfoService.getAll();
        request.setAttribute("list",all);

        return "product";
    }


    //展示第一页
    @RequestMapping("/showOnePage")
    public String showOnePage(HttpServletRequest request){
        PageInfo pageInfo = null;
        //取出条件
        ProductInfoVo prodVo = (ProductInfoVo) request.getSession().getAttribute("prodVo");
        System.out.println(prodVo);
        if(prodVo != null){
            pageInfo = productInfoService.splitPageVo(prodVo, PAGE_SIZE);
            request.getSession().removeAttribute("prodVo");//移除条件
        }else {
            pageInfo = productInfoService.splitPage(1, PAGE_SIZE);
        }
        request.setAttribute("info",pageInfo);
        return "product";
    }


    @ResponseBody
    @RequestMapping("/ajaxsplit")
    public void ajaxSplit(HttpSession session, ProductInfoVo productInfoVo){
        if(productInfoVo.getPage() == 0){
            productInfoVo.setPage(1);
        }
        PageInfo pageInfo = productInfoService.splitPageVo(productInfoVo,PAGE_SIZE);
        session.setAttribute("info",pageInfo);
    }

    @ResponseBody
    @RequestMapping("/condition")
    public void condition(ProductInfoVo productInfoVo,HttpSession session){

        List<ProductInfo> list = productInfoService.selectCondition(productInfoVo);
        session.setAttribute("list",list);
    }

    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile pimage,HttpServletRequest request){

        //生成新的文件名
        s = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());

        //存储的路径
        String realPath = request.getServletContext().getRealPath("/image_big");

        try {
            pimage.transferTo(new File(realPath+File.separator+s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //回显图片数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgurl",s);
        return jsonObject.toString();
    }


    @RequestMapping("/save")
    public String save(ProductInfo productInfo,HttpServletRequest request){

        productInfo.setpImage(s);
        productInfo.setpDate(new Date());

        int num = -1;
        try {
            num = productInfoService.save(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(num > 0){
            request.setAttribute("msg","添加成功！");
        }else {
            request.setAttribute("msg","添加失败！");
        }
        //清空s图片名称的内容，防止修改商品图片时，使用同一个名称
        s = "";
        return "forward:/prod/showOnePage.action";
    }


    @RequestMapping("/one")
    public String one(Integer pid, Model model,ProductInfoVo productInfoVo,HttpSession session){
        System.out.println("------------------------------------" + productInfoVo);
        ProductInfo byId = productInfoService.getById(pid);
        model.addAttribute("prod",byId);

        //将多条件和页码存储起来
        session.setAttribute("prodVo",productInfoVo);

        return "update";
    }


    @RequestMapping("/update")
    public String update(ProductInfo prod, HttpServletRequest request){

        //判断有上传图片了，就更改图片信息
        if(!s.equals("")){
            prod.setpImage(s);
        }
        int update = -1;
        try {
            update = productInfoService.update(prod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(update > 0){
            request.setAttribute("msg","更新成功！");
        }else {
            request.setAttribute("msg","更新失败！");
        }
        s = "";
        return "forward:/prod/showOnePage.action";
    }

    //根据pid 判断是否删除成功，成功后需要携带成功与否信息
    @RequestMapping("/delete")
    public String delete(Integer pid, HttpServletRequest request, ProductInfoVo productInfoVo){

        int delete = -1;
        try {
            delete = productInfoService.delete(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(delete > 0){
            request.setAttribute("msg","删除成功！");
            request.getSession().setAttribute("delProdVo",productInfoVo);
        }else {
            request.setAttribute("msg","删除失败！");
        }

        return "forward:/prod/delteAjaxSplit.action";
    }

    //通过获取成功与否信息后，需要更新页面
    @ResponseBody
    @RequestMapping(value = "/delteAjaxSplit",produces = "text/html;charset=UTF-8")
    public Object delteAjaxSplit(HttpServletRequest request){

        ProductInfoVo prodVo = (ProductInfoVo) request.getSession().getAttribute("delProdVo");
        PageInfo pageInfo = null;

        if(prodVo != null){
            pageInfo = productInfoService.splitPageVo(prodVo, PAGE_SIZE);
        }else {
            pageInfo = productInfoService.splitPage(1, PAGE_SIZE);
        }

        request.getSession().setAttribute("info",pageInfo);

        return request.getAttribute("msg");
    }


    @RequestMapping("/deleteBatch")
    public String deleteBatch(String ids,HttpServletRequest request){
        String[] split = ids.split(",");
        int num = -1;

        try {
            num = productInfoService.deleteBatch(split);
            if(num > 0){
                request.setAttribute("msg","批量删除成功！");
            }else {
                request.setAttribute("msg","批量删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","商品不可删除！");
        }
        return "forward:/prod/delteAjaxSplit.action";
    }






}
