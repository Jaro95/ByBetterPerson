package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.api.organization.command.UpdateOrganizationAddressCommand;
import pl.jaroslaw.bybetterperson.api.organization.dto.OrganizationDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class UpdateOrganizationAddressHandler {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public OrganizationDto handle(Long organizationId, UpdateOrganizationAddressCommand cmd) {

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow();

        Address address = organization.getAddress();
        address.changeAddress(
                cmd.city(),
                cmd.street(),
                cmd.streetNumber(),
                cmd.number(),
                cmd.postalCode()
        );
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
