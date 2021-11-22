package com.mio4.validator;

import com.mio4.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository("userValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
        //return false;
    }

    //对目标类target进行校验，并将错误记录在errors中
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"loginname",null,"登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
        User user = (User) target;
        if(user.getLoginname().length() > 10){
            errors.rejectValue("loginname",null,"用户名不能超过10个字符");
        }
        if(user.getPassword() != null && !user.getPassword().equals("") && user.getPassword().length() < 6){
            errors.rejectValue("password",null,"密码不能少于6个字符");
        }
    }
}
