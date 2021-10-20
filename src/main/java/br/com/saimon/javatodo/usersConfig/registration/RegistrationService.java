package br.com.saimon.javatodo.usersConfig.registration;

import br.com.saimon.javatodo.usersConfig.AppUser;
import br.com.saimon.javatodo.usersConfig.UserRole;
import br.com.saimon.javatodo.usersConfig.UserService;
import br.com.saimon.javatodo.usersConfig.registration.token.ConfirmationToken;
import br.com.saimon.javatodo.usersConfig.registration.token.ConfirmationTokenService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public RegistrationService(UserService userService, EmailValidator emailValidator, ConfirmationTokenService confirmationTokenService) {
        this.userService = userService;
        this.emailValidator = emailValidator;

        this.confirmationTokenService = confirmationTokenService;
    }


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }
        return userService.signup(new AppUser(
                request.getFirsName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER));
    }

    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.geToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("Email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();
        if (expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token expired");
        }
        confirmationTokenService.SetConfirmedAt(token);
        userService.enableAppUser(
                confirmationToken.getAppUser().getUsername());
        return "confirmed";
    }
}
