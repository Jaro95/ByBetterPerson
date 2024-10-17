package pl.jaroslaw.bybetterperson.api.organization.command;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;

public record CreateOrganizationCommand(
        String description,
        String name,
        AddressDto addressDto
) {
}
