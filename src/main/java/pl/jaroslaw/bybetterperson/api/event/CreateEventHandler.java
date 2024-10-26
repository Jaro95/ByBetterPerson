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
                cmd.eventDateStart(),//odpowiedni format
                cmd.eventDateEnd(),//enum zrobic
                cmd.status(),
                cmd.description(),
                cmd.terms(),
                cmd.organization()
        );
        Event savedEvent = eventRepository.save(event);

        return savedEvent.getId();
    }
}
