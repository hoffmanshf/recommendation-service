package com.hoffmanshf.recommendation.service.impl;

import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.dal.CategoryModelMapper;
import com.hoffmanshf.recommendation.model.CategoryModel;
import com.hoffmanshf.recommendation.service.CategoryService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryModelMapper categoryModelMapper;

    public CategoryServiceImpl(CategoryModelMapper categoryModelMapper) {
        this.categoryModelMapper = categoryModelMapper;
    }

    @Override
    @Transactional
    public CategoryModel create(CategoryModel categoryModel) throws BusinessException {
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());

        try {
            categoryModelMapper.insertSelective(categoryModel);
        } catch (DuplicateKeyException ex) {
            throw new BusinessException(BusinessError.CATEGORY_NAME_DUPLICATED);
        }

        return get(categoryModel.getId());
    }

    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryModelMapper.countAllCategory();
    }
}
