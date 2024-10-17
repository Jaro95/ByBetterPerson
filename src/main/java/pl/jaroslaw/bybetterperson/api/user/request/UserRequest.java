package pl.jaroslaw.bybetterperson.api.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(

        @NotBlank
        @Size(max = 30)
        String name,
        @NotBlank
        @Size(max = 50)
        String email,
        String password,
        Boolean enabled,
        Set<Long> roleIdList
) {
}
