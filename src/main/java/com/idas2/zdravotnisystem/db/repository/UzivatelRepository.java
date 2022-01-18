package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.view.UzivatelView;
import com.idas2.zdravotnisystem.form.UserUpdateForm;
import org.jetbrains.annotations.NotNull;

public interface UzivatelRepository {

    User update(
        @NotNull User user
    );

    User findByEmail(String email);

    @NotNull User findByUuid(String uuid);

    @NotNull User findById(Integer id);

    @NotNull UzivatelView findViewByUuid(String uuid);
}
