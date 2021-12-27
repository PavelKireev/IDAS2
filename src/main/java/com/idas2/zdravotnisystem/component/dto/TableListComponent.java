package com.idas2.zdravotnisystem.component.dto;

public class TableListComponent {

    private String name;
    private String link;

    public TableListComponent(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public TableListComponent setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public TableListComponent setLink(String link) {
        this.link = link;
        return this;
    }
}
