package br.com.rufuziu.crud_users_and_auth.controller;

import br.com.rufuziu.crud_users_and_auth.dto.UserDTO;
import br.com.rufuziu.crud_users_and_auth.services.EmailService;
import br.com.rufuziu.crud_users_and_auth.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Validated
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    public UserController(UserService userService,
                          EmailService emailService
    ) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("v1/users/create/user")
    public ResponseEntity<String> userCreate(@RequestBody @Valid UserDTO userDto) {
        return null;
    }

    @PatchMapping("v1/users/active/{email}")
    public ResponseEntity<String> userActivate(@PathVariable String email) {
        if (userService.activateUserByEmail(email) > 0)
            return ResponseEntity.ok("User activated!");
        else return ResponseEntity.badRequest().build();
    }
}
