package pl.jaroslaw.bybetterperson.api.organization.command.dto;

public record UpdateOrganizationCommand(
        String description,
        String name
) {
}
