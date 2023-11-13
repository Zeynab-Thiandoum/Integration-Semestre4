package sn.edu.isepdiamniadio.integration4.models;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteRequest {
    private String voterId;
    private Long candidateId;
}
