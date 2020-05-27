package com.xuanyu.service;

import com.xuanyu.model.User;
import org.springframework.stereotype.Service;

/**
 * @author xuanyu
 */
@Service
public interface ValidatorService extends UserService {
    /**
     * 校验邮箱是否存在
     * @param email
     * @return
     */
    @Override
    User validatorEmailExist(String email);
}
