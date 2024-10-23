package pl.jaroslaw.bybetterperson.api.event.command;

public record UpdateEventAddressCommand(
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode
) {
}