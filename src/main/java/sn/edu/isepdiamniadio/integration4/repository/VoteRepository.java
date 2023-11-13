package sn.edu.isepdiamniadio.integration4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.edu.isepdiamniadio.integration4.models.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {

}
