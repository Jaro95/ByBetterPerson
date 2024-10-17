package pl.jaroslaw.bybetterperson.api.organization.command;

public record UpdateOrganizationCommand(
        String description,
        String name
) {
}
