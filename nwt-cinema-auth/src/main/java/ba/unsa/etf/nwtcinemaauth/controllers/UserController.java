package ba.unsa.etf.nwtcinemaauth.controllers;


import ba.unsa.etf.nwtcinemaauth.models.User;
import ba.unsa.etf.nwtcinemaauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok()
                    .build();
        }
        catch (Exception exc) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
    }

}
