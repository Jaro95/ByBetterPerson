package pl.jaroslaw.bybetterperson.api.organization.command;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jaroslaw.bybetterperson.api.organization.command.dto.CreateOrganizationCommand;
import pl.jaroslaw.bybetterperson.api.organization.command.dto.UpdateOrganizationAddressCommand;
import pl.jaroslaw.bybetterperson.api.organization.command.dto.UpdateOrganizationCommand;

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
    Long updateOrganizationData(@PathVariable Long organizationId,
                                           @RequestBody UpdateOrganizationCommand cmd) {
        return updateOrganizationDataHandler.handle(organizationId, cmd);
    }

    @PutMapping("/{organizationId}/update/address")
    Long updateOrganizationAddress(@PathVariable Long organizationId,
                                              @RequestBody UpdateOrganizationAddressCommand cmd) {
        return updateOrganizationAddressHandler.handle(organizationId, cmd);
    }
}
