package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.organization.command.UpdateOrganizationCommand;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;
import pl.jaroslaw.bybetterperson.dto.organization.OrganizationDto;

@Service
@AllArgsConstructor
class UpdateOrganizationDataHandler {

    private final OrganizationRepository organizationRepository;
    public OrganizationDto handle(Long organizationId, UpdateOrganizationCommand cmd) {

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow();

        Organization updatedOrganization =  organization.updateData(cmd.description());
        return new OrganizationDto(
                updatedOrganization.getId(),
                updatedOrganization.getDescription()
        );

    }
}
