package sn.edu.isepdiamniadio.integration4.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class RegisterReponse {
    private String voterId;
    private String message;
}
