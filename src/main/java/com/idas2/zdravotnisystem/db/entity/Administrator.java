package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Administrator extends UUIDableTimedEntity<Integer> {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public Administrator setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
