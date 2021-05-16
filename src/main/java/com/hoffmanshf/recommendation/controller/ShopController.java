package com.hoffmanshf.recommendation.controller;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.CommonResult;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.model.CategoryModel;
import com.hoffmanshf.recommendation.model.ShopModel;
import com.hoffmanshf.recommendation.service.CategoryService;
import com.hoffmanshf.recommendation.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    private final CategoryService categoryService;

    public ShopController(ShopService shopService, CategoryService categoryService) {
        this.shopService = shopService;
        this.categoryService = categoryService;
    }

    //推荐服务V1.0
    @RequestMapping("/recommend")
    @ResponseBody
    public CommonResult recommend(@RequestParam(name = "longitude") BigDecimal longitude,
                                  @RequestParam(name = "latitude") BigDecimal latitude) throws BusinessException {
        if (longitude == null || latitude == null) {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude, latitude);
        return CommonResult.create(shopModelList);
    }


    //搜索服务V1.0
    @RequestMapping("/search")
    @ResponseBody
    public CommonResult search(@RequestParam(name = "longitude") BigDecimal longitude,
                               @RequestParam(name = "latitude") BigDecimal latitude,
                               @RequestParam(name = "keyword") String keyword,
                               @RequestParam(name = "orderby", required = false) Integer orderby,
                               @RequestParam(name = "categoryId", required = false) Integer categoryId,
                               @RequestParam(name = "tags", required = false) String tags) throws BusinessException {
        if (StringUtils.isEmpty(keyword) || longitude == null || latitude == null) {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.search(longitude, latitude, keyword, orderby, categoryId, tags);
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String, Object>> tagsAggregation = shopService.searchGroupByTags(keyword, categoryId, tags);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("shop", shopModelList);
        resMap.put("category", categoryModelList);
        resMap.put("tags", tagsAggregation);
        return CommonResult.create(resMap);

    }
}
