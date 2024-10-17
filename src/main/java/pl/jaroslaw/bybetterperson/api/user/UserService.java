package pl.jaroslaw.bybetterperson.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.user.request.RegistrationRequest;
import pl.jaroslaw.bybetterperson.api.user.request.UserRequest;
import pl.jaroslaw.bybetterperson.api.user.response.RegistrationResponse;
import pl.jaroslaw.bybetterperson.domain.user.User;
import pl.jaroslaw.bybetterperson.domain.user.UserRepository;
import pl.jaroslaw.bybetterperson.infrastructure.security.role.Role;
import pl.jaroslaw.bybetterperson.infrastructure.security.role.RoleRepository;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        Set<Role> roles = new HashSet<>();
        user.ifPresent(u -> {
            Optional.ofNullable(userRequest.name()).ifPresent(name ->
                    u.setName(u.getName().equals(name) ? u.getName() : name));
            Optional.ofNullable(userRequest.email()).ifPresent(email ->
                    u.setEmail(u.getEmail().equals(email) ? u.getEmail() : email)
            );
            Optional.ofNullable(userRequest.password()).ifPresent(password -> {
                if (!passwordEncoder.matches(password, u.getPassword())) {
                    u.setPassword(passwordEncoder.encode(password));
                }
            });
            Optional.ofNullable(userRequest.enabled()).ifPresent(enabled ->
                    u.setEnabled(u.isEnabled() == enabled ? u.isEnabled() : enabled)
            );
            Optional.ofNullable(userRequest.roleIdList())
                    .filter(roleIdList -> !roleIdList.isEmpty())
                    .ifPresent(roleIdList -> roleIdList.forEach(roleId ->
                            roles.add(roleRepository.findById(roleId).orElseThrow(IllegalArgumentException::new)))
                    );
            if (!roles.isEmpty()) {
                u.setRoles(u.getRoles().equals(roles) ? u.getRoles() : roles);
            }
            userRepository.save(u);
            log.info("Updated user: {}", u);
        });
        return user;
    }

    public Optional<User> deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> {
            userRepository.delete(u);
            log.info("User deleted: {}", u);
        });
        return user;
    }

    public RegistrationResponse registrationUser(RegistrationRequest registrationRequest) {
        if (!registrationRequest.password().equals(registrationRequest.repeatPassword())) {
            return new RegistrationResponse(false, "Passwords are not the same", registrationRequest);
        }
        if (userRepository.findByEmail(registrationRequest.email()).isPresent()) {
            return new RegistrationResponse(false, "Email is already taken", registrationRequest);
        }
        Role userRole = roleRepository.findByName("ROLE_USER");
        userRepository.save(User.builder()
                .name(registrationRequest.name())
                .email(registrationRequest.email())
                .roles(new HashSet<>(Collections.singletonList(userRole)))
                .password(passwordEncoder.encode(registrationRequest.password()))
                .createdAccount(LocalDateTime.now())
                .enabled(false)
                .token(UUID.randomUUID().toString())
                .build());
        log.info("Added new user:\nEmail:{}\nName:{}", registrationRequest.email(),
                registrationRequest.name());
        return new RegistrationResponse(true, "Registration successful", registrationRequest);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
