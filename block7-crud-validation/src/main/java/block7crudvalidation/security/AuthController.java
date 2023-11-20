package block7crudvalidation.security;

import block7crudvalidation.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController{
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity <AuthResponse>login(@RequestBody LoginRequest request) throws InvalidKeyException {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/register")
    public ResponseEntity  <AuthResponse>register(@RequestBody Person person) throws InvalidKeyException {
        return ResponseEntity.ok(authService.register(person));
    }
}
