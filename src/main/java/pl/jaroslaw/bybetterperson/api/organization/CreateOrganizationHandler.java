package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.organization.command.CreateOrganizationCommand;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class CreateOrganizationHandler {

    private final OrganizationRepository organizationRepository;

    public Long handle(CreateOrganizationCommand cmd) {
        Organization organization = Organization.create(
                cmd.description()
        );
        Organization savedOrganization = organizationRepository.save(organization);
        return savedOrganization.getId(); // or DTO
    }
}
