package pl.jaroslaw.bybetterperson.api.organization;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jaroslaw.bybetterperson.api.organization.command.CreateOrganizationCommand;
import pl.jaroslaw.bybetterperson.api.organization.command.UpdateOrganizationAddressCommand;
import pl.jaroslaw.bybetterperson.api.organization.command.UpdateOrganizationCommand;
import pl.jaroslaw.bybetterperson.api.organization.dto.OrganizationDto;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
class OrganizationController {

    private final CreateOrganizationHandler createOrganizationHandler;
    private final UpdateOrganizationDataHandler updateOrganizationDataHandler;
    private final UpdateOrganizationAddressHandler updateOrganizationAddressHandler;

    @PostMapping("/create")
    Long createOrganization(@RequestBody CreateOrganizationCommand cmd) {
        return createOrganizationHandler.handle(cmd);
    }

    @PutMapping("/{organizationId}/update")
    OrganizationDto updateOrganizationData(@PathVariable Long organizationId,
                                           @RequestBody UpdateOrganizationCommand cmd) {
        return updateOrganizationDataHandler.handle(organizationId, cmd);
    }

    @PutMapping("/{organizationId}/update/address")
    OrganizationDto updateOrganizationAddress(@PathVariable Long organizationId,
                                              @RequestBody UpdateOrganizationAddressCommand cmd) {
        return updateOrganizationAddressHandler.handle(organizationId, cmd);
    }
}
