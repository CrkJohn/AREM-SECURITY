package edu.eci.arem.service.services;


import edu.eci.arem.service.repository.*;
import edu.eci.arem.service.model.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


/**
 * A class used to represent the service the login and register
 */
@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     *
     * @param userRepository user repository injection
     * @param roleRepository role repository injection
     * @param bCryptPasswordEncoder Injection class that allows us to encrypt the password
     */
    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    /**
     *
     * @param email   that will be consulted to recognize if there are db
     * @return User that has a email equals that param email
     */
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     *
     * @param user to be saved in the database
     */
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}