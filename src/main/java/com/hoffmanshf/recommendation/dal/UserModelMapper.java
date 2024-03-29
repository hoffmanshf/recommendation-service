package com.hoffmanshf.recommendation.dal;

import com.hoffmanshf.recommendation.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    int insert(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    int insertSelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    UserModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    int updateByPrimaryKeySelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Fri Nov 15 00:25:14 EST 2019
     */
    int updateByPrimaryKey(UserModel record);

    UserModel selectByPhoneAndPassword(@Param("phone") String phone, @Param("password")String password);

    Integer countAllUser();
}