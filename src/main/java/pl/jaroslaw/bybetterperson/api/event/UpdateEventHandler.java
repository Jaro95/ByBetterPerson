package pl.jaroslaw.bybetterperson.api.event;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventCommand;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

import java.util.Date;

@Service
@AllArgsConstructor
public class UpdateEventHandler {

    private final EventRepository eventRepository;

    @Transactional
    public Long handle(Long eventId, UpdateEventCommand cmd) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow();

        Event updatedEvent = event.updateData(
                cmd.name(),
                new Date().toString(),//odpowiedni format
                cmd.status(),//enum zrobic
                cmd.description(),
                cmd.terms(),
                cmd.organizationId()
        );
        return updatedEvent.getId();
    }
}
