package pl.jaroslaw.bybetterperson.api.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.address.command.CreateAddressCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.address.AddressRepository;

@Service
@AllArgsConstructor
class CreateAddressHandler {

    private final AddressRepository addressRepository;

    Long handle(CreateAddressCommand cmd) {

        Address address = Address.create(
                cmd.city(),
                cmd.street(),
                cmd.streetNumber(),
                cmd.number(),
                cmd.postalCode());
        Address savedAddress = addressRepository.save(address);

        return savedAddress.getId();
    }
}
