package pl.jaroslaw.bybetterperson.api.event;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.jaroslaw.bybetterperson.api.event.command.CreateEventCommand;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventAddressCommand;
import pl.jaroslaw.bybetterperson.api.event.command.UpdateEventCommand;

@RestController
@RequestMapping("/api/event")
@AllArgsConstructor
public class EventController {

    private final CreateEventHandler createEventHandler;
    private final UpdateEventHandler updateEventHandler;
    private final UpdateEventAddressHandler updateEventAddressHandler;

    @PostMapping("/create")
    Long createEvent(@RequestBody CreateEventCommand cmd) {
        return createEventHandler.handle(cmd);
    }

    @PutMapping("/{eventId}/update")
    Long updateEventData(@PathVariable Long eventId,
                                @RequestBody UpdateEventCommand cmd) {
        return updateEventHandler.handle(eventId, cmd);
    }

    @PutMapping("/{eventId}/update/address")
    Long updateEventAddress(@PathVariable Long eventId,
                                   @RequestBody UpdateEventAddressCommand cmd) {
        return updateEventAddressHandler.handle(eventId, cmd);
    }
}
