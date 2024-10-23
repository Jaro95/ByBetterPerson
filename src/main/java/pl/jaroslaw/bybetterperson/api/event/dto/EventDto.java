package pl.jaroslaw.bybetterperson.api.event.dto;

import jakarta.persistence.*;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;

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
