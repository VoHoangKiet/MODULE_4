package codegym.vn.validate;

import codegym.vn.entity.User;
import codegym.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidate implements Validator {
    @Autowired
    private UserService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof User)) {
            return;
        }
        User p = (User) target;
        if (service.findById(p.getId()) != null) {
            errors.rejectValue("id", "id.duplicate", "ID bị trùng lặp");
        }
        if(!p.getPhone().matches("\\d{10}")) {
            errors.rejectValue("phone","phone.regex","Phải có 10 chữ số");
        }
    }
}
