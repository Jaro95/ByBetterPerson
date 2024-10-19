package pl.jaroslaw.bybetterperson.api.organization.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.api.organization.command.dto.UpdateOrganizationAddressCommand;
import pl.jaroslaw.bybetterperson.api.organization.query.dto.OrganizationDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class UpdateOrganizationAddressHandler {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public Long handle(Long organizationId, UpdateOrganizationAddressCommand cmd) {

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
        return organization.getId();
    }
}
