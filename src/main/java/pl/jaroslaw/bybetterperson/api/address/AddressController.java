package pl.jaroslaw.bybetterperson.api.address;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jaroslaw.bybetterperson.api.address.command.CreateAddressCommand;
import pl.jaroslaw.bybetterperson.api.address.command.UpdateAddressCommand;
import pl.jaroslaw.bybetterperson.api.address.dto.AddressDto;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
class AddressController {

    private final CreateAddressHandler createAddressHandler;
    private final UpdateAddressHandler updateAddressHandler;

    @PostMapping("/create")
    Long createAddress(@RequestBody CreateAddressCommand cmd) {
        return createAddressHandler.handle(cmd);
    }

    @PutMapping("/{addressId}/update")
    AddressDto createOrganization(@PathVariable Long addressId,
                                  @RequestBody UpdateAddressCommand cmd) {
        return updateAddressHandler.handle(addressId, cmd);
    }
}
