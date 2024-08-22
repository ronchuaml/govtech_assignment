package com.demo.assignment.seed;

import com.demo.assignment.entity.Role;
import com.demo.assignment.entity.User;
import com.demo.assignment.entity.UserRole;
import com.demo.assignment.repository.RoleRepository;
import com.demo.assignment.repository.UserRepository;
import com.demo.assignment.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    private UserRoleRepository userRoleRepository;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public DataSeeder(UserRoleRepository userRoleRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Role adminRole = new Role("ADMIN");
            Role userRole = new Role("USER");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            User admin = new User("admin", passwordEncoder.encode("admin"));
            User user = new User("user", passwordEncoder.encode("admin"));

            userRepository.save(admin);
            userRepository.save(user);

            UserRole userRole1 = new UserRole(admin, adminRole);
            userRoleRepository.save(userRole1);

            UserRole userRole2 = new UserRole(user, userRole);
            userRoleRepository.save(userRole2);
        };
    }


}