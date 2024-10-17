package pl.jaroslaw.bybetterperson.api.address.dto;

public record AddressDto(
        Long id,
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode
) {
}
