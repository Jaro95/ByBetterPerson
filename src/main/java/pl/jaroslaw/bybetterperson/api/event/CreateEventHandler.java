package pl.jaroslaw.bybetterperson.api.event;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.CreateEventCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;

import java.util.Date;

@Service
@AllArgsConstructor
public class CreateEventHandler {

    private final EventRepository eventRepository;

    @Transactional
    public Long handle(CreateEventCommand cmd) {

        Address address = Address.create(
                cmd.addressDto().city(),
                cmd.addressDto().street(),
                cmd.addressDto().streetNumber(),
                cmd.addressDto().number(),
                cmd.addressDto().postalCode()

        );

        Event event = Event.create(
                cmd.name(),
                address,
                new Date().toString(),//odpowiedni format
                cmd.status(),//enum zrobic
                cmd.description(),
                cmd.terms(),
                cmd.organizationId()
        );
        Event savedEvent = eventRepository.save(event);

        return savedEvent.getId();
    }
}
