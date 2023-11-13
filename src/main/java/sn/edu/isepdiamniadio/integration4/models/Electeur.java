package sn.edu.isepdiamniadio.integration4.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Electeur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationalId;
    private LocalDate dateOfBirth;
    private String voterId;
    private String password;
    private boolean dejaVoter;

}