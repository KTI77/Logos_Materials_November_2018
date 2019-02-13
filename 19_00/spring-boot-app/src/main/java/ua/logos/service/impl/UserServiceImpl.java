package ua.logos.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.UserDTO;
import ua.logos.entity.UserEntity;
import ua.logos.exceptions.ServerException;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void createUser(UserDTO userDto) {

        if (userDto.getPassword().equals(userDto.getPasswordConfirm())) {
            UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
            userRepository.save(userEntity);
        } else {
            throw new ServerException("Passwords not match");
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.mapAll(userRepository.findAll(), UserDTO.class);
    }
}
