package org.example.project.service;

import org.example.project.dto.UserDTO;
import org.example.project.model.User;
import org.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO addUser(User user);
    void removeUserById (Long id);
    UserDTO updateUser(User user);
    List<UserDTO> findAllUsers();

    UserDTO getUserById(Long id);

    List<UserDTO> searchUser(String keyWord);

}
