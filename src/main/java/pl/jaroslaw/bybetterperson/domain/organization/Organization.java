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
    private Long  id;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private Organization(String description) {
        this.description = description;
    }

    public static Organization create(String description){
        return new Organization(description);
    }

    public void addAddress(Address address){
        this.address = address;
    }

    public Organization updateData(String description){
        if(description != null){
            this.description = description;
        }
        return this;
    }

}
