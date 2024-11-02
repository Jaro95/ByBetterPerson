package pl.jaroslaw.bybetterperson.domain.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.jaroslaw.bybetterperson.domain.address.Address;
import pl.jaroslaw.bybetterperson.domain.organization.Organization;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    private String eventDateStart;

    private String eventDateEnd;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String description;
    //users
    private String terms;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    private Event(String name,
                  Address address,
                  String eventDateStart,
                  String eventDateEnd,
                  Status status,
                  String description,
                  String terms,
                  Organization organization) {
        this.name = name;
        this.address = address;
        this.eventDateStart = eventDateStart;
        this.eventDateEnd = eventDateEnd;
        this.status = status;
        this.description = description;
        this.terms = terms;
        this.organization = organization;
    }

    public static Event create(String name,
                               Address address,
                               String eventDateStart,
                               String eventDateEnd,
                               Status status,
                               String description,
                               String terms,
                               Organization organization) {
        return new Event(
                name,
                address,
                eventDateStart,
                eventDateEnd,//odpowiedni format
                status,
                description,
                terms,
                organization
        );
    }

    public Event updateData(String name, String eventDateStart, String eventDateEnd, Status status, String description, String terms) {
        this.name = name;
        this.eventDateStart = eventDateStart;
        this.eventDateEnd = eventDateEnd;
        this.status = status;
        this.description = description;
        this.terms = terms;

        return this;
    }
}
