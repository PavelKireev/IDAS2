package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.multipart.MultipartFile;

public interface ObrazekRepository{

    @NotNull void create(
        @NotNull Obrazek obrazek
    );

    void upload(
        @NotNull User user,
        @NotNull MultipartFile obrazek
    );

    void upload(
        @NotNull PacientView pacientView,
        @NotNull MultipartFile obrazek
    );

    @Nullable Obrazek getOne(Integer id);
}
