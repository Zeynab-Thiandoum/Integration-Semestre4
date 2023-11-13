package sn.edu.isepdiamniadio.integration4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.edu.isepdiamniadio.integration4.models.Electeur;
import sn.edu.isepdiamniadio.integration4.models.Vote;
import sn.edu.isepdiamniadio.integration4.models.VoteReponse;
import sn.edu.isepdiamniadio.integration4.models.VoteRequest;
import sn.edu.isepdiamniadio.integration4.repository.VoteRepository;
@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private ElecteurService electeurService;


    public VoteReponse ajoutVote(VoteRequest request) {
        
        var candidate = candidatService.findCandidat(request.getCandidateId());
        

        Electeur electeur = electeurService.findByVoterId(request.getVoterId());

        if (electeur.isDejaVoter()) {
            throw new IllegalStateException("Vous avez déjà fait votre vote.");
        }
        if (candidate != null) {
            var vote = Vote.builder()
                .candidatId(candidate)
                .voter(electeur)
                .build();
            voteRepository.save(vote);
            electeur.setDejaVoter(true);
            electeurService.ajoutElecteur(electeur);
        }else {
            throw new IllegalStateException("Electeur ou Candidate non trouver.");
        }

        var reponse = VoteReponse.builder()
            .candidateIdVotedFor(request.getCandidateId())
            .voterId(request.getVoterId())
            .message("Votre vote pour le candidate"+request.getCandidateId()+" a ete enregistrer avec succes")
            .build();

        return reponse;
    }

    public List<Vote> listeVote() {
        return voteRepository.findAll();
    }

    public Vote findVote(Long id) {
        Optional<Vote> ficheVoteOptional = voteRepository.findById(id);
        return ficheVoteOptional.orElse(null);
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}