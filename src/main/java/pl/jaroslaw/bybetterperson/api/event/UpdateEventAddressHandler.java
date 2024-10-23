package pl.jaroslaw.bybetterperson.api.event;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventAddressCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
public class UpdateEventAddressHandler {

    private final EventRepository eventRepository;

    @Transactional
    public Long handle(Long eventId, UpdateEventAddressCommand cmd) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow();

        Address address = event.getAddress();
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
