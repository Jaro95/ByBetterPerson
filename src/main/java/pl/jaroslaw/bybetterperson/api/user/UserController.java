package pl.jaroslaw.bybetterperson.api.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jaroslaw.bybetterperson.api.user.request.RegistrationRequest;
import pl.jaroslaw.bybetterperson.api.user.request.UserRequest;
import pl.jaroslaw.bybetterperson.api.user.response.RegistrationResponse;
import pl.jaroslaw.bybetterperson.api.user.response.UserListResponse;
import pl.jaroslaw.bybetterperson.api.user.response.UserResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public UserListResponse getAllUsers() {
        return new UserListResponse(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return new UserResponse(userService.findById(id));
    }

    @PostMapping("/registration")
    public RegistrationResponse registration(@RequestBody @Valid RegistrationRequest registrationRequest) {
        return userService.registrationUser(registrationRequest);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return new UserResponse(userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable Long id) {
        return new UserResponse(userService.deleteUser(id));
    }
}
