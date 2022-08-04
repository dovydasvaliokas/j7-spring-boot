package lt.viltiesziedas.receptai.controller;

import lt.viltiesziedas.receptai.model.entity.Receptas;
import lt.viltiesziedas.receptai.model.repository.ReceptasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptasController {

    @Autowired
    ReceptasRepository belekaip;

    @GetMapping("/test/belekas")
    String testinisEndpoint() {
        return "dar kartą belekas";
    }

    @GetMapping("/test/receptas")
    Receptas rastiPagalId(int id) {
        return belekaip.findById(id);
    }
}
