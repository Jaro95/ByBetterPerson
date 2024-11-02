package pl.jaroslaw.bybetterperson.api.event.dto;

import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;

public record EventDto(
        Long id,
        String name,
        AddressDto addressDto,
        String date,
        String status,
        String description,
        String terms,
        Long organizationId
) {}
