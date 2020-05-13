package com.xuanyu.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class ValidateModel {
    @NotEmpty(message = "{name.not.empty}")
    private String name;
    @NotEmpty(message = "{email.not.empty}")
    @Email(message = "{email.not.correct}")
    private String email;
}
