package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.UserDTO;
import ua.logos.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody @Valid UserDTO userDTO) {
            // BindingResult bindingResult

/*        if (bindingResult.hasErrors()) {
            System.out.println("Error happened");
            return new ResponseEntity<>("Error happened",
                    HttpStatus.BAD_REQUEST);
        }*/

        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(
                userService.getAllUsers(), HttpStatus.OK
        );
    }

}
