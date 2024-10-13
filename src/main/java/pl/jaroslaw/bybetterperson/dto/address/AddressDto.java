package pl.jaroslaw.bybetterperson.dto.address;

public record AddressDto(
        Long id,
        String city,
        String street,
        Integer streetNumber,
        Integer number,
        String postalCode) {
}
