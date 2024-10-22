package pl.jaroslaw.bybetterperson.api.organization.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.bybetterperson.api.organization.command.dto.CreateOrganizationCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class CreateOrganizationHandler {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public Long handle(CreateOrganizationCommand cmd) {
        checkName(cmd.name());

        Address address = Address.create(
                cmd.addressDto().city(),
                cmd.addressDto().street(),
                cmd.addressDto().streetNumber(),
                cmd.addressDto().number(),
                cmd.addressDto().postalCode()

        );

        Organization organization = Organization.create(
                cmd.description(),
                cmd.name(),
                address
        );
        Organization savedOrganization = organizationRepository.save(organization);

        return savedOrganization.getId();
    }

    private void checkName(String name) {
        boolean exist = organizationRepository.existsByName(name);
        if (exist) {
            throw new IllegalArgumentException("Organization with this name exist");
        }
    }
}
