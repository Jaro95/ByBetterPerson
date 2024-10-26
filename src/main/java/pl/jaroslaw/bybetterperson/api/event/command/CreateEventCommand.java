package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.event.Status;

public record CreateEventCommand(
        Address address,
        String name,
        String eventDateStart,
        String eventDateEnd,
        Status status,
        String description,
        String terms,
        Long organizationId
) {
}
