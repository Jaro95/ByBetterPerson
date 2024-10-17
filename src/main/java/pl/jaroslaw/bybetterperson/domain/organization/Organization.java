package pl.jaroslaw.bybetterperson.domain.organization;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.jaroslaw.bybetterperson.domain.address.Address;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Description description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private Organization(String description, String name) {
        this.description = new Description(description, name);
        this.address = null;
    }

    public static Organization create(String description, String name) {
        return new Organization(description, name);
    }

    public void addAddress(Address address) {
        this.address = address;
    }

    public Organization updateData(String description, String name) {
        this.description.update(description, name);
        return this;
    }

    public String getDescription() {
        return description.getDescription();
    }

    public String getName() {
        return description.getName();
    }
}
