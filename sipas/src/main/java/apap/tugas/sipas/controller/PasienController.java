package apap.tugas.sipas.controller;

import apap.tugas.sipas.model.PasienModel;
import apap.tugas.sipas.service.PasienService;
import apap.tugas.sipas.service.PasienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasienController {
    @Autowired
    private PasienService pasienService;

    @Autowired
    private PService pasienService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewAllPasien(Model model){
        List<PasienModel> listPasien = pasienService.getPasienList();
        model.addAttribute("listPasien", listPasien);
        return "home";
    }

    @RequestMapping(value = "pasien/tambah/", method = RequestMethod.GET)
    public String addPasienForm(Model model) {
        PasienModel newPasien = new PasienModel();
        model.addAttribute("pasien", newPasien);
        return "form-add-pasien";
    }



}
