package pl.jaroslaw.bybetterperson.api.event;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventAddressCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.address.AddressRepository;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;

@Service
@AllArgsConstructor
public class UpdateEventAddressHandler {

    private final EventRepository eventRepository;
    private final AddressRepository addressRepository;

    @Transactional
    public Long handle(Long eventId, UpdateEventAddressCommand cmd) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found for ID: " + eventId));

        Address address = addressRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found for ID: " + eventId));

        address.changeAddress(
                cmd.city(),
                cmd.street(),
                cmd.streetNumber(),
                cmd.number(),
                cmd.postalCode()
        );
        return event.getId();
    }
}
