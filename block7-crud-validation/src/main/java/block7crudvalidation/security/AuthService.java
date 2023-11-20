package block7crudvalidation.security;
import block7crudvalidation.domain.Person;
import block7crudvalidation.repository.PersonRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.security.InvalidKeyException;

@Builder
@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonRepository personRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=personRepository.findByUsuario(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }
    public AuthResponse register(Person request) throws InvalidKeyException {
        Person person = Person.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.USER)
                .build();

        personRepository.save(person);

        return AuthResponse.builder()
                .token(jwtService.getToken(person))
                .build();

    }

}
