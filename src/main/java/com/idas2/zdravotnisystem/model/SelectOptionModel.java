package com.idas2.zdravotnisystem.model;

import com.idas2.zdravotnisystem.model.core.IdentifiableModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "options")
public class SelectOptionModel extends IdentifiableModel<SelectOptionModel> {

    private static final long serialVersionUID = 1015762337550636147L;
    private String title;
    private String hash;
    private String alias;
    private String ownerAlias;
    private String color;
    private String icon;

    public static SelectOptionModel of(
        String id,
        String title
    ) {
        SelectOptionModel resource =  new SelectOptionModel();
        resource.setId(id);
        resource.setTitle(title);

        return resource;
    }

    public String getTitle() {
        return title;
    }

    public SelectOptionModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getColor() {
        return color;
    }

    public SelectOptionModel setColor(String color) {
        this.color = color;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public SelectOptionModel setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public SelectOptionModel setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getOwnerAlias() {
        return ownerAlias;
    }

    public SelectOptionModel setOwnerAlias(String ownerAlias) {
        this.ownerAlias = ownerAlias;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public SelectOptionModel setHash(String hash) {
        this.hash = hash;
        return this;
    }
}
