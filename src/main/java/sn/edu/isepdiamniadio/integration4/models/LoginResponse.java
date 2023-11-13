package sn.edu.isepdiamniadio.integration4.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private String idToken;
    private String voterId;
    private String message;
}
