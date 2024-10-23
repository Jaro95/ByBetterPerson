package pl.jaroslaw.bybetterperson.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.domain.user.User;
import pl.jaroslaw.bybetterperson.domain.user.UserRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpringDataUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));

        return new CurrentUser(user.orElseThrow().getEmail(), user.get().getPassword(),
                user.get().getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
                , user.get());
    }
}
