package sn.edu.isepdiamniadio.integration4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.integration4.models.Candidat;
import sn.edu.isepdiamniadio.integration4.service.CandidatService;

@RestController
@RequestMapping("/api/candidat")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @PostMapping
    public String ajoutCandidat(@RequestBody Candidat candidat){
        candidatService.ajoutCandidat(candidat);
        return "Success";
    }
}
