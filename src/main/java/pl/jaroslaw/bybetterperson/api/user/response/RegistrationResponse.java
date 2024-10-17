package pl.jaroslaw.bybetterperson.api.user.response;

import pl.jaroslaw.bybetterperson.api.user.request.RegistrationRequest;

public record RegistrationResponse(boolean successful, String message, RegistrationRequest registrationRequest) {
}
