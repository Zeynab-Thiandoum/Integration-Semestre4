package sn.edu.isepdiamniadio.integration4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.edu.isepdiamniadio.integration4.models.Electeur;

@Repository
public interface ElecteurRepository extends JpaRepository<Electeur, Long> {
    Optional<Electeur> findByVoterId(String voterId);
    boolean existsByVoterId(String voterid);
}
