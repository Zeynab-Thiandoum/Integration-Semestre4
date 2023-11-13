//package sn.edu.isepdiamniadio.integration4.config.auth;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import sn.edu.isepdiamniadio.integration4.config.JwtTokenProvider;
//import sn.edu.isepdiamniadio.integration4.models.Electeur;
//import sn.edu.isepdiamniadio.integration4.models.Vote;
//import sn.edu.isepdiamniadio.integration4.repository.ElecteurRepository;
//import sn.edu.isepdiamniadio.integration4.token.Token;
//import sn.edu.isepdiamniadio.integration4.token.TokenRepository;
//import sn.edu.isepdiamniadio.integration4.token.TokenType;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    private final PasswordEncoder passwordEncoder;
//    private final ElecteurRepository repository;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final TokenRepository tokenRepository;
//
//
//    public Response register(Request request) {
//        var electeur = Electeur.builder()
//                .name(request.getName())
//                .nationalId(request.getNationalId())
//                .dateOfBirth(request.getDateOfBirth())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .voterId(request.getVoterId())
//                .build();
//        var savedUser = repository.save(electeur);
//        var jwtToken = jwtTokenProvider.generateToken(electeur);
//        saveUserToken(savedUser, jwtToken);
//        return Response.builder()
//                .voterId(new Vote())
//                .message("Enregistré avec succès")
//                .build();
//    }
//    private void saveUserToken(Electeur electeur, String jwtToken) {
//        var token = Token.builder()
//                .electeur(electeur)
//                .token(jwtToken)
//                .tokenType(TokenType.BEARER)
//                .expired(false)
//                .revoked(false)
//                .build();
//        tokenRepository.save(token);
//    }
//
//
//}
