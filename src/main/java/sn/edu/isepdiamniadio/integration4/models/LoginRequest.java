package sn.edu.isepdiamniadio.integration4.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String voterid;
    private String password;
}
