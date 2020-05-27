package com.xuanyu.dao;

import com.xuanyu.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author xuanyu
 */
@Mapper
public interface ValidatorMapper extends UserMapper{
    /** 校验邮箱是否存在
     * @param  email
     */
    User validatorEmailExist(String email);
}
