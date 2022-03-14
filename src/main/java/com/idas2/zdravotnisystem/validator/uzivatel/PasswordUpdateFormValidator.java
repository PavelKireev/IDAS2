package com.idas2.zdravotnisystem.validator.uzivatel;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.UzivatelView;
import com.idas2.zdravotnisystem.form.uzivatel.PasswordUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PasswordUpdateFormValidator implements Validator {

    private final PasswordEncoder passwordEncoder;
    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public PasswordUpdateFormValidator(
        PasswordEncoder passwordEncoder,
        UzivatelRepository uzivatelRepository
    ) {
        this.passwordEncoder = passwordEncoder;
        this.uzivatelRepository = uzivatelRepository;
    }

    public boolean supports(Class<?> clazz) {
        return PasswordUpdateForm.class.isAssignableFrom(clazz)
            || UzivatelView.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PasswordUpdateForm form = (PasswordUpdateForm) target;
        User uzivatelView = uzivatelRepository.findById(form.getId());

        if(Objects.isNull(form.getPassword()) || form.getPassword().isEmpty())
            errors.rejectValue("password", "", "Heslo nesmi byt prazne!");

        if(Objects.isNull(form.getCurrentPassword()) || form.getCurrentPassword().isEmpty())
            errors.rejectValue("currentPassword", "", "Aktualni heslo nesmi byt prazne!");

        if(Objects.isNull(form.getPasswordConfirm()) || form.getPasswordConfirm().isEmpty())
            errors.rejectValue("passwordConfirm", "", "Heslo potcrzeni nesmi byt prazne!");

        if(!form.getPassword().equals(form.getPasswordConfirm()))
            errors.rejectValue("passwordConfirm", "", "Heslo a potvrzeni nejsou stejne!");

        if(Objects.nonNull(form.getCurrentPassword()) && !
            passwordEncoder.matches(form.getCurrentPassword(), uzivatelView.getPassword()))
            errors.rejectValue("currentPassword","", "Nespravne aktualni heslo!");
    }
}
