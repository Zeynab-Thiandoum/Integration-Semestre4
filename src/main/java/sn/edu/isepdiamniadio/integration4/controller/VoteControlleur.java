package sn.edu.isepdiamniadio.integration4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.edu.isepdiamniadio.integration4.models.VoteReponse;
import sn.edu.isepdiamniadio.integration4.models.VoteRequest;
import sn.edu.isepdiamniadio.integration4.service.VoteService;

@RestController
@RequestMapping("/api/voting")
public class VoteControlleur {
    @Autowired
    private VoteService voteService;

    @PostMapping("/vote")
    public ResponseEntity<VoteReponse> voter(@RequestBody VoteRequest vote){
        VoteReponse voteReponse = voteService.ajoutVote(vote);
        return new ResponseEntity<>(voteReponse, HttpStatus.OK);
    }
}
