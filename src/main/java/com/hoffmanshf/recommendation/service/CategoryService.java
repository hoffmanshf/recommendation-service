package com.hoffmanshf.recommendation.service;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

    Integer countAllCategory();
}
