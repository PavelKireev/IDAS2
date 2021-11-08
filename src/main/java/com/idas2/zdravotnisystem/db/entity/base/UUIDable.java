package com.idas2.zdravotnisystem.db.entity.base;

import java.util.UUID;

public interface UUIDable {

    default String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
