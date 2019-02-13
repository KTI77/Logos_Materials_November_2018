package ua.logos.service;

import ua.logos.domain.UserDTO;

import java.util.List;

public interface UserService {

    void createUser(UserDTO userDto);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();
}
