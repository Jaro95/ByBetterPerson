package pl.jaroslaw.bybetterperson.api.organization.command.dto;

public record UpdateOrganizationAddressCommand(
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode
) {
}