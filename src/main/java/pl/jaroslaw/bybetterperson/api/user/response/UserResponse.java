package pl.jaroslaw.bybetterperson.api.user.response;

import pl.jaroslaw.bybetterperson.domain.user.User;

import java.util.Optional;

public record UserResponse(Optional<User> user) {
}
