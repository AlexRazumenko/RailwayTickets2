package org.alex.railway.tickets.service;

import lombok.extern.slf4j.Slf4j;
import org.alex.railway.tickets.dto.UserDTO;
import org.alex.railway.tickets.dto.UsersDTO;
import org.alex.railway.tickets.entity.User;
import org.alex.railway.tickets.entity.enums.RoleType;
import org.alex.railway.tickets.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

//@Slf4j
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
        init();
    }

    private void init () {
            if (repository.getCount() == 0) {
                User admin = User.builder().email("admin@railway.com")
                        .firstName("Admin")
                        .lastName("Admin")
                        .password("123")
                        .role(RoleType.ROLE_ADMIN)
                        .build();
                repository.save(admin);
            }
    }

    public UsersDTO getAll() {
        return  new UsersDTO(repository.findAll());
    }

    public User findByLogin(UserDTO userDTO) {
        return repository.findByEmail(userDTO.getEmail()).orElseGet(User::new);
    }

    public User findById(Long id) {
        return  repository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with id " + id + " is not exists!"));
    }

    public void save(User user) {
        try {
            repository.save(user);
        } catch (Exception e) {
            logger.info("E-mail address must be unique!");
        }
    }

    public void delete (Long id) {
        repository.delete(repository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not exists!")));
    }




}
