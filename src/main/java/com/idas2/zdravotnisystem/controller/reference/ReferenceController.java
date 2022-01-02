package com.idas2.zdravotnisystem.controller.reference;

import com.idas2.zdravotnisystem.assembler.SelectOptionModelAssembler;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.repository.HospitalizaceRepository;
import com.idas2.zdravotnisystem.db.repository.TypProceduryRepository;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import com.idas2.zdravotnisystem.model.SelectOptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reference")
public class ReferenceController {

    private final TypZarizeniRepository typZarizeniRepository;
    private final TypProceduryRepository typProceduryRepository;
    private final HospitalizaceRepository hospitalizaceRepository;

    @Autowired
    public ReferenceController(
        TypZarizeniRepository typZarizeniRepository,
        TypProceduryRepository typProceduryRepository,
        HospitalizaceRepository hospitalizaceRepository
    ) {
        this.typZarizeniRepository = typZarizeniRepository;
        this.typProceduryRepository = typProceduryRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
    }

    @GetMapping("hospitalizace")
    public List<SelectOptionModel> hospitalizaceViewList() {
        SelectOptionModelAssembler<HospitalizaceView> assembler = new SelectOptionModelAssembler<>();
        return assembler.toModels(hospitalizaceRepository.findAll());
    }

    @GetMapping("/typzarizeni")
    public List<SelectOptionModel> typZaeizeniList() {
        SelectOptionModelAssembler<TypZarizeni> assembler = new SelectOptionModelAssembler<>();
        return assembler.toModels(typZarizeniRepository.findAll());
    }

    @GetMapping("/typprocedury")
    public List<SelectOptionModel> typProceduryList() {
        SelectOptionModelAssembler<TypProcedury> assembler = new SelectOptionModelAssembler<>();
        return assembler.toModels(typProceduryRepository.findAll());
    }

}
