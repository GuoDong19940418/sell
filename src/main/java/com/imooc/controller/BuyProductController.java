package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-07 上午 11:19
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "productList",key = "123")
    public ResultVO list(){
//        1.查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();
//        2.查询类目
        List<Integer>categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo:productInfos){
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> ProductCategorys = categoryService.findByCategoryTypeIn(categoryTypeList);
//        3.数据拼装
        List<ProductVO>productVOs = new ArrayList<>();
        for(ProductCategory productCategory:ProductCategorys){
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO>productInfoVOs = new ArrayList<>();
            for(ProductInfo productInfo:productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOs.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOs);
            productVOs.add(productVO);

        }
        ResultVO resultVO = ResultVOUtil.success(productVOs);
        return resultVO;
    }

}