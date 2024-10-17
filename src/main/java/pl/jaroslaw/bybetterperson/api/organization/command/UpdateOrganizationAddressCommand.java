package pl.jaroslaw.bybetterperson.api.organization.command;

public record UpdateOrganizationAddressCommand(
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode
) {
}