package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.domain.event.Status;

public record UpdateEventCommand(
        Long id,
        String name,
        String eventDateStart,
        String eventDateEnd,
        Status status,
        String description,
        String terms,
        Long organizationId
) {
}
