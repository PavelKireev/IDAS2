package com.idas2.zdravotnisystem.controller;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.repository.ObrazekRepository;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import com.idas2.zdravotnisystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private final UserService userService;
    private final ObrazekRepository obrazekRepository;

    @Autowired
    public UserProfileController(
        UserService userService,
        ObrazekRepository obrazekRepository
    ) {
        this.userService = userService;
        this.obrazekRepository = obrazekRepository;
    }

    @GetMapping("/info")
    public ModelAndView info(
        @AuthenticationPrincipal AuthUser authUser
    ) {
        // picture conversion
//        File img = new File("file.png");
//        byte[] imgBytes = IOUtils.toByteArray(new FileInputStream(img));
//        byte[] imgBytesAsBase64 = Base64.encodeBase64(imgBytes);
//        String imgDataAsBase64 = new String(imgBytesAsBase64);
//        String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;
        // <img alt="My image" src="${imgAsBase64}" />

        return
            new ModelAndView("user/profile")
                .addObject("authUser", authUser);
    }

    @PostMapping("/avatar")
    public ModelAndView avatar(
        @AuthenticationPrincipal AuthUser authUser,
        @RequestParam("obrazek") MultipartFile file
    ) throws IOException {
//        <form method="post" action="/form" enctype="multipart/form-data">

        System.out.println("ff");
        byte[] bytes = file.getBytes();
//        try {
//            byte[] image = file.getBytes();
//            MyModel model = new MyModel(name, image);
//            int saveImage = myService.saveImage(model);
//            if (saveImage == 1) {
//                return "success";
//            } else {
//                return "error";
//            }
//        } catch (Exception e) {
//            logger.error("ERROR", e);
//            return "error";
//        }
        return null;
    }

    @PostMapping("/update")
    public ModelAndView update(
        @ModelAttribute UserUpdateForm form
    ) {
        return null;
    }
}
