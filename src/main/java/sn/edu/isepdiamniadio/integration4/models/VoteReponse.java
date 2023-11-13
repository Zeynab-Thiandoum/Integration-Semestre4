package sn.edu.isepdiamniadio.integration4.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteReponse {
    private String voterId;
    private Long candidateIdVotedFor;
    private String message;
}
