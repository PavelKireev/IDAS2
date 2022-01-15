package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.view.PacientView;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

public interface ObrazekRepository extends CrudRepository<Obrazek>{

    void upload(
        @NotNull User user,
        @NotNull MultipartFile obrazek
    );

    void upload(
        @NotNull PacientView pacientView,
        @NotNull MultipartFile obrazek
    );
}
