package com.hoffmanshf.recommendation.service;


import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.model.SellerModel;

import java.util.List;

public interface SellerService {

    SellerModel create(SellerModel sellerModel);

    SellerModel get(Integer id);

    List<SellerModel> selectAll();

    SellerModel changeStatus(Integer id, Integer disabledFlag) throws BusinessException;

}
