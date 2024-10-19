package pl.jaroslaw.bybetterperson.api.organization.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.api.organization.query.dto.OrganizationDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
public class GetOrganizationByIdQuery {

    private final OrganizationRepository organizationRepository;

    public OrganizationDto handle(Long id) {

        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Organization does no exist"));

        Address address = organization.getAddress();

        return new OrganizationDto(
                organization.getId(),
                organization.getDescription(),
                organization.getName(),
                new AddressDto(
                        address.getId(),
                        address.getCity(),
                        address.getStreet(),
                        address.getStreetNumber(),
                        address.getNumber(),
                        address.getPostalCode()
                )
        );
    }
}
