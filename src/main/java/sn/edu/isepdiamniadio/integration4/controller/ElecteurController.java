package sn.edu.isepdiamniadio.integration4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.edu.isepdiamniadio.integration4.models.Electeur;
import sn.edu.isepdiamniadio.integration4.models.LoginRequest;
import sn.edu.isepdiamniadio.integration4.models.LoginResponse;
import sn.edu.isepdiamniadio.integration4.models.RegisterReponse;
import sn.edu.isepdiamniadio.integration4.service.ElecteurService;

@RestController
@RequestMapping("/api/voters")
public class ElecteurController {

    @Autowired
    private ElecteurService electeurService;

    @PostMapping("/register")
    public ResponseEntity<RegisterReponse> enregisterElecteur(@RequestBody Electeur electeur){
        try {
            RegisterReponse electeurSaved = electeurService.ajoutElecteur(electeur);
            return new ResponseEntity<>(electeurSaved, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try {
            LoginResponse electeurLogin = electeurService.login(request);
            return new ResponseEntity<>(electeurLogin, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listeElecteur")
    public List<Electeur> listeElecteur(){
        return electeurService.listeElecteur();
    }

    @DeleteMapping("{id}")
    public void deleteElecteur(@PathVariable Long id){
        electeurService.deleteElecteur(id);

    }
}
