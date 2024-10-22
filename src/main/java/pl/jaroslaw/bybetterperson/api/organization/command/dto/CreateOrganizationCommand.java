package pl.jaroslaw.bybetterperson.api.organization.command.dto;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;

public record CreateOrganizationCommand(
        String description,
        String name,
        AddressDto addressDto
) {
}
