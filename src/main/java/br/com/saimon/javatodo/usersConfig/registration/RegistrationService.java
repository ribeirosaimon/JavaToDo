package br.com.saimon.javatodo.usersConfig.registration;

import br.com.saimon.javatodo.usersConfig.AppUser;
import br.com.saimon.javatodo.usersConfig.UserRole;
import br.com.saimon.javatodo.usersConfig.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public RegistrationService(UserService userService, EmailValidator emailValidator) {
        this.userService = userService;
        this.emailValidator = emailValidator;
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
}
