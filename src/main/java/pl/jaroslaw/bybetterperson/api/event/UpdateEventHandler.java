package pl.jaroslaw.bybetterperson.api.event;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventCommand;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;


@Service
@AllArgsConstructor
public class UpdateEventHandler {

    private final EventRepository eventRepository;

    @Transactional
    public Long handle(Long eventId, UpdateEventCommand cmd) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found for ID: " + eventId));

        Event updatedEvent = event.updateData(
                cmd.name(),
                cmd.eventDateStart(),//odpowiedni format
                cmd.eventDateEnd(),
                cmd.status(),
                cmd.description(),
                cmd.terms()
        );
        return updatedEvent.getId();
    }
}
