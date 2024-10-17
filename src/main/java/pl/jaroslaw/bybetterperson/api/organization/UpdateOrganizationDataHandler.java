package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jaroslaw.bybetterperson.api.organization.command.UpdateOrganizationCommand;
import pl.jaroslaw.bybetterperson.api.organization.dto.OrganizationDto;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
class UpdateOrganizationDataHandler {

    private final OrganizationRepository organizationRepository;

    @Transactional
    public OrganizationDto handle(Long organizationId, UpdateOrganizationCommand cmd) {

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow();

        Organization updatedOrganization = organization.updateData(cmd.description(), cmd.name());
        return new OrganizationDto(
                updatedOrganization.getId(),
                updatedOrganization.getDescription(),
                updatedOrganization.getName(),
                null
        );

    }
}
