package pl.jaroslaw.bybetterperson.domain.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.jaroslaw.bybetterperson.domain.address.Address;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private String date;

    private String status;

    private String description;
    //users
    private String terms;

    private Long organizationId;

    private Event(String name,
                  Address address,
                  String date,
                  String status,
                  String description,
                  String terms,
                  Long organizationId) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.status = status;
        this.description = description;
        this.terms = terms;
        this.organizationId = organizationId;
    }

    public static Event create(String name,
                               Address address,
                               String date,
                               String status,
                               String description,
                               String terms,
                               Long organizationId) {
        return new Event(
                name,
                address,
                new Date().toString(),//odpowiedni format
                status,//enum zrobic
                description,
                terms,
                organizationId
        );
    }

    public Event updateData(String name, String date, String status, String description, String terms, Long organizationId) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.description = description;
        this.terms = terms;
        this.organizationId = organizationId;

        return this;
    }
}
