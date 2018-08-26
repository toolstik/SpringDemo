package com.example.demo.services;

import java.util.List;
import com.example.demo.dal.dao.User;
import com.example.demo.dal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    // @Autowired
    // private RoleRepository roleRepository;
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // @Override
    // public void saveUser(User user) {
    //     user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     user.setActive(1);
    //     Role userRole = roleRepository.findByRole("ADMIN");
    //     user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    //     userRepository.save(user);
    // }

}
