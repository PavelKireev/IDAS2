package com.idas2.zdravotnisystem.util;

public interface Selectable {

    String getSelectorId();

    String getSelectorTitle();

    default String getSelectorAlias() {
        return null;
    }
    default String getSelectorColor() {
        return null;
    }
    default String getSelectorOwnerAlias() {
        return null;
    }
    default String getSelectorHash() {
        return null;
    }

}
