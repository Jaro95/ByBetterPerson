package pl.jaroslaw.bybetterperson.api.user.response;

import pl.jaroslaw.bybetterperson.domain.user.User;

import java.util.List;

public record UserListResponse(List<User> userList) {
}
