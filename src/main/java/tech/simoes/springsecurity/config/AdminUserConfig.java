package tech.simoes.springsecurity.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import tech.simoes.springsecurity.entity.Role;
import tech.simoes.springsecurity.entity.User;
import tech.simoes.springsecurity.repository.RoleRepository;
import tech.simoes.springsecurity.repository.UserRepository;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setName(Role.Values.ADMIN.name());
            roleRepository.save(roleAdmin);
        }

        var userAdmin = userRepository.findByUsername("admin");

        Role finalRoleAdmin = roleAdmin;
        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("admin já existe.");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(finalRoleAdmin));
                    userRepository.save(user);
                    System.out.println("Usuário admin criado com sucesso!");
                }
        );
    }

}