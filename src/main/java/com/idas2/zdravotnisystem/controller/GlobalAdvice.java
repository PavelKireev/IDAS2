package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Objects;

@ControllerAdvice
public class GlobalAdvice {

    private final UzivatelRepository uzivatelRepository;
    private final ObrazekRepository obrazekRepository;

    // TODO: add avatarString to authUser
    @Autowired
    public GlobalAdvice(
        UzivatelRepository uzivatelRepository,
        ObrazekRepository obrazekRepository
    ) {
        this.uzivatelRepository = uzivatelRepository;
        this.obrazekRepository = obrazekRepository;
    }


    @ModelAttribute("authUser")
    public User getCurrentAccount(@AuthenticationPrincipal User user) {
        return Objects.nonNull(user) ? user : null;
    }

    @ModelAttribute("authUserAvatar")
    public String getCurrentAccountAvatar(
        @AuthenticationPrincipal AuthUser user
    ) {
        if(Objects.isNull(user))
            return null;

        Obrazek obrazek =
            obrazekRepository.getOne(user.getUser().getObrazekIdObrazek());

        if (Objects.isNull(obrazek))
            return null;

        byte[] imgBytesAsBase64 = Base64.encodeBase64(obrazek.getData());
        String imgDataAsBase64 = new String(imgBytesAsBase64);
        return String.format(
            "data:image/%s;base64,%s",
            obrazek.getPripona(), imgDataAsBase64
        );
    }
}
