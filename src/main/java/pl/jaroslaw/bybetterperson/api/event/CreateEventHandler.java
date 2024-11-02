package pl.jaroslaw.bybetterperson.api.event;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jaroslaw.bybetterperson.api.event.command.CreateEventCommand;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.address.AddressRepository;
import pl.jaroslaw.bybetterperson.domain.event.Event;
import pl.jaroslaw.bybetterperson.domain.event.EventRepository;
import pl.jaroslaw.bybetterperson.domain.event.Status;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;
import pl.jaroslaw.bybetterperson.domain.organization.OrganizationRepository;

@Service
@AllArgsConstructor
public class CreateEventHandler {

    private final EventRepository eventRepository;
    private final AddressRepository addressRepository;
    private final OrganizationRepository organizationRepository;

    @Transactional
    public Long handle(CreateEventCommand cmd) {

        Address address = addressRepository.save(cmd.address());

        Organization organization = organizationRepository.findById(cmd.organizationId())
                .orElseThrow(() -> new EntityNotFoundException("Organization not found for ID: " + cmd.organizationId()));

        Event event = Event.create(
                cmd.name(),
                address,
                cmd.eventDateStart(),
                cmd.eventDateEnd(),
                Status.INPROGRESS,
                cmd.description(),
                cmd.terms(),
                organization
        );

        Event savedEvent = eventRepository.save(event);

        return savedEvent.getId();
    }
}
