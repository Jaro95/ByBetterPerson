package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.event.Status;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;

public record CreateEventCommand(
        AddressDto addressDto,
        String name,
        String eventDateStart,
        String eventDateEnd,
        Status status,
        String description,
        String terms,
        Organization organization
) {
}
