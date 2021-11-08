package com.idas2.zdravotnisystem.db.entity.base;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<P extends Serializable> implements Persistable<P>, Serializable {

    private static final long serialVersionUID = -514473906123185465L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected P id;

    @Override
    public P getId() {
        return id;
    }

    public BaseEntity<P> setId(P id) {
        this.id = id;
        return this;
    }

    @Override
    @Transient
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        BaseEntity<?> that = (BaseEntity<?>) obj;

        return null != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

}
