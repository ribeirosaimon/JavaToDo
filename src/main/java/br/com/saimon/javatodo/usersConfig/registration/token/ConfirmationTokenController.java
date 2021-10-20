package br.com.saimon.javatodo.usersConfig.registration.token;

import br.com.saimon.javatodo.usersConfig.registration.RegistrationRequest;
import br.com.saimon.javatodo.usersConfig.registration.RegistrationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Service
public class ConfirmationTokenController {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenController(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    @RestController
    @RequestMapping("api/registration/v1")
    public static class RegistrationController implements Serializable {

        private final RegistrationService registrationService;

        public RegistrationController(RegistrationService registrationService) {
            this.registrationService = registrationService;
        }

        @PostMapping
        public String register(@RequestBody RegistrationRequest request){
            return registrationService.register(request);
        }

        @GetMapping("/confirm")
        public String confirm(@RequestParam("token") String token){
            return registrationService.confirmToken(token);
        }
    }
}
