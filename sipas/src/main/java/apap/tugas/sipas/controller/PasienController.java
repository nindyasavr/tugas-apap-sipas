package apap.tugas.sipas.controller;

import apap.tugas.sipas.model.AsuransiModel;
import apap.tugas.sipas.model.PasienModel;
import apap.tugas.sipas.service.AsuransiService;
import apap.tugas.sipas.service.PasienService;
import apap.tugas.sipas.service.PasienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PasienController {
    @Autowired
    private PasienService pasienService;

    @Autowired
    private AsuransiService asuransiService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewAllPasien(Model model){
        List<PasienModel> listPasien = pasienService.getPasienList();
        model.addAttribute("listPasien", listPasien);
        return "home";
    }

    @RequestMapping(value = "/pasien/tambah", method = RequestMethod.GET)
    public String addPasienForm(Model model) {
        PasienModel newPasien = new PasienModel();
        List<AsuransiModel> listAsuransi = asuransiService.getAsuransiList();
        model.addAttribute("pasien", newPasien);
        model.addAttribute("listAsuransi", listAsuransi);
        return "form-add-pasien";
    }

    @RequestMapping(value = "/pasien/tambah", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute PasienModel pasien, Model model) {
        return "add-pasien";
    }

//    @RequestMapping(value = "pasien/", method = RequestMethod.GET)
//    public String cariPasienNik(@RequestParam(value = "nikPasien") String nik, Model model) {
//        PasienModel targetPasien = pasienService.getPasienByNikPasien(nik).get();
//        model.addAttribute("pasien", targetPasien);
//        return "view-pasien";
//    }


}
