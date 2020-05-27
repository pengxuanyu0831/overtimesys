package com.xuanyu.service;

import com.xuanyu.model.User;

/**
 * @author xuanyu
 */
public interface ValidatorService extends UserService {
    /**
     * 校验邮箱是否存在
     * @param email
     * @return
     */
    User validatorEmailExist(String email);
}
