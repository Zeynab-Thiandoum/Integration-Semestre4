package sn.edu.isepdiamniadio.integration4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.edu.isepdiamniadio.integration4.models.Electeur;
import sn.edu.isepdiamniadio.integration4.models.LoginRequest;
import sn.edu.isepdiamniadio.integration4.models.LoginResponse;
import sn.edu.isepdiamniadio.integration4.models.RegisterReponse;
import sn.edu.isepdiamniadio.integration4.repository.ElecteurRepository;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepository;


    public RegisterReponse ajoutElecteur(Electeur electeur){
        if (electeurRepository.existsByVoterId(electeur.getVoterId())) {
            System.out.println("L'électeur  existe déjà");
            throw new RuntimeException("L'électeur  existe déjà");
        }
        var electeurSaved = electeurRepository.save(electeur);
        var response = RegisterReponse.builder()
        .message("Enregistré avec succès")
        .voterId(electeurSaved.getVoterId()).build();
        return response;
    }

    public LoginResponse login(LoginRequest request){
        Optional<Electeur> electeurOptional = electeurRepository.findByVoterId(request.getVoterid());
        if (!electeurOptional.isPresent()) {
            System.out.println("Electeur not found");
            throw new IllegalAccessError("Electeur not found");
        }
        var response = LoginResponse.builder()
        .voterId(request.getVoterid())
        .idToken("Token buhijnokpl^m$êgfsdiokplm45623fsdciopkl^mùfs")
        .message("Connecté avec succès").build();
        return response;
    }

    public List<Electeur> listeElecteur(){
       return  electeurRepository.findAll();
    }

    public Electeur findElecteur(Long id){
        Optional<Electeur> ficheElecteurOptional = electeurRepository.findById(id);
        return ficheElecteurOptional.orElse(null);
    }

    public Electeur findByVoterId(String voterId){
        Optional<Electeur> ficheElecteurOptional = electeurRepository.findByVoterId(voterId);
        return ficheElecteurOptional.orElse(null);
    }
//public Optional<Electeur> findByVoterId(String voterId) {
//    return electeurRepository.findByVoterId(voterId).stream().findFirst();
//}

    public void deleteElecteur(Long id){
        electeurRepository.deleteById(id);
    }
}
