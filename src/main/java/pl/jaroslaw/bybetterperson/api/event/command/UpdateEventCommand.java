package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.domain.address.Address;

public record UpdateEventCommand(
        Long id,
        String name,
        String date,
        String status,
        String description,
        String terms,
        Long organizationId
) {
}
