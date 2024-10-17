package pl.jaroslaw.bybetterperson.api.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegistrationRequest (
    @NotBlank
    @Size(max = 30)
    String name,
    @NotBlank
    @Size(max = 50)
    @Email
    String email,
    @NotBlank
    @Size(min = 8)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!*@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Hasło musi zawierać wielkie litery, małe litery, cyfry i znaki specjalne"
    )
    String password,
    @NotBlank
    String repeatPassword
) {}
