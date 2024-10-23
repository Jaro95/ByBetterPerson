package pl.jaroslaw.bybetterperson.api.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.address.command.UpdateAddressCommand;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.address.AddressRepository;

@Service
@AllArgsConstructor
class UpdateAddressHandler {

    private final AddressRepository addressRepository;

    public AddressDto handle(Long addressId, UpdateAddressCommand cmd) {

        Address address = addressRepository.findById(addressId).orElseThrow();
        Address changedAddress = address.changeAddress(
                cmd.city(),
                cmd.street(),
                cmd.streetNumber(),
                cmd.number(),
                cmd.postalCode()
        );
        return new AddressDto(
                changedAddress.getId(),
                changedAddress.getCity(),
                changedAddress.getStreet(),
                changedAddress.getStreetNumber(),
                changedAddress.getNumber(),
                changedAddress.getPostalCode()
        );
    }
}
