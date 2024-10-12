package pl.jaroslaw.bybetterperson.api.address.command;

public record UpdateAddressCommand(
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode
) {
}
