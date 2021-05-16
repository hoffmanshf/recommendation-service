package com.hoffmanshf.recommendation.controller;

import com.hoffmanshf.recommendation.common.CommonResult;
import com.hoffmanshf.recommendation.model.CategoryModel;
import com.hoffmanshf.recommendation.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/category")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public CommonResult list() {
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        return CommonResult.create(categoryModelList);
    }
}
