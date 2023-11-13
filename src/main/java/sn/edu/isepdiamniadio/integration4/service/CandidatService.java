package sn.edu.isepdiamniadio.integration4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.integration4.models.Candidat;
import sn.edu.isepdiamniadio.integration4.models.Electeur;
import sn.edu.isepdiamniadio.integration4.repository.CandidatRepository;
import sn.edu.isepdiamniadio.integration4.repository.ElecteurRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;


    public void ajoutCandidat(Candidat candidat){
        candidatRepository.save(candidat);
    }

    public List<Candidat> listeCandidat(){
        return  candidatRepository.findAll();
    }

    public Candidat findCandidat(Long id){
        Optional<Candidat> ficheCandidatOptional = candidatRepository.findById(id);
        return ficheCandidatOptional.orElse(null);
    }

    public void deleteCandidat(Long id){
        candidatRepository.deleteById(id);
    }
}
