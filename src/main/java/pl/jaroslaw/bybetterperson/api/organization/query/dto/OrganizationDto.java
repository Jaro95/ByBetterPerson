package pl.jaroslaw.bybetterperson.api.organization.query.dto;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;

public record OrganizationDto(
        Long id,
        String description,
        String name,
        AddressDto address
) {
}
