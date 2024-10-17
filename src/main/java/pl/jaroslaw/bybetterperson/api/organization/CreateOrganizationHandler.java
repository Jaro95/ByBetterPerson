package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.bybetterperson.api.organization.command.CreateOrganizationCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class CreateOrganizationHandler {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public Long handle(CreateOrganizationCommand cmd) {
        Organization organization = Organization.create(
                cmd.description(),
                cmd.name()
        );
        Organization savedOrganization = organizationRepository.save(organization);
        savedOrganization.addAddress(
                Address.create(
                        cmd.addressDto().city(),
                        cmd.addressDto().street(),
                        cmd.addressDto().streetNumber(),
                        cmd.addressDto().number(),
                        cmd.addressDto().postalCode()

                ));

        return savedOrganization.getId();
    }
}
