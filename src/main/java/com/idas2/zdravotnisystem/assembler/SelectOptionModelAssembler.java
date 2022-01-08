package com.idas2.zdravotnisystem.assembler;


import com.idas2.zdravotnisystem.model.SelectOptionModel;
import com.idas2.zdravotnisystem.model.core.AbstractModelAssembler;
import com.idas2.zdravotnisystem.util.Selectable;

public class SelectOptionModelAssembler<E extends Selectable>
        extends AbstractModelAssembler<E, SelectOptionModel> {

    public SelectOptionModelAssembler() {
        super(SelectOptionModel.class);
    }

    @Override
    public SelectOptionModel toModel(Selectable entity) {
        SelectOptionModel model = SelectOptionModel.of(
            null,
            entity.getSelectorTitle()
        );
        model.setAlias(entity.getSelectorAlias());
        model.setOwnerAlias(entity.getSelectorOwnerAlias());
        model.setHash(entity.getSelectorHash());
        model.setColor(entity.getSelectorColor());
        return model;
    }

}
