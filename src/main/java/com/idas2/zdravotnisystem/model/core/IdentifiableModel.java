package com.idas2.zdravotnisystem.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({IdentifiableModel.ID_PROPERTY_NAME})
public abstract class IdentifiableModel<E extends RepresentationModel<? extends  E>>
        extends RepresentationModel<E> implements Serializable {

    static final String ID_PROPERTY_NAME = "id";
    private static final long serialVersionUID = -1453227429686640195L;

    @JsonProperty(ID_PROPERTY_NAME)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IdentifiableModel that = (IdentifiableModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public Links getLinks() {
        return super.getLinks();
    }
}
