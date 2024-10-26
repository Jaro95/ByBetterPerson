package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.event.Status;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;

public record UpdateEventCommand(
        Long id,
        String name,
        String evenDateStart,
        String eventDateEnd,
        Status status,
        String description,
        String terms,
        Organization organization
) {
}
