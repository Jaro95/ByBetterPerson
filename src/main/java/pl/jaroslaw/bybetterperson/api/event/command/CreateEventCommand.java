package pl.jaroslaw.bybetterperson.api.event.command;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;

public record CreateEventCommand(
        AddressDto addressDto,
        String name,
        String status,
        String description,
        String terms,
        Long organizationId
) {
}
