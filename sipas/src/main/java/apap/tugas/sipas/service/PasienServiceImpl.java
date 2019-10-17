package apap.tugas.sipas.service;

import apap.tugas.sipas.model.PasienModel;
import apap.tugas.sipas.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
    @Autowired
    PasienDb pasienDb;

    @Override
    public List<PasienModel> getPasienList() {
        return pasienDb.findAll();
    }

//    @Override
//    public Optional<PasienModel> getPasienByNikPasien(String nik) {
//        Optional<PasienModel> pasien = pasienDb.findPasienModelByNIKPasien(nik);
//        return pasien;
//    }
}
