package pl.jaroslaw.bybetterperson.domain.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name = "address")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private Integer streetNumber;
    private Integer number;
    @Embedded
    private PostalCode postalCode;

    private Address(String city, String street, int streetNumber, int number, String postalCode) {
        this.city = checkCity(city);
        this.street = checkStreet(street);
        this.streetNumber = checkStreetNumber(streetNumber);
        this.number = checkNumber(number);
        this.postalCode = new PostalCode(postalCode);
    }

    public static Address create(String city, String street, int streetNumber, int number, String postalCode){
        return new Address(city,street,streetNumber,number,postalCode);
    }

    public Address changeAddress(String city, String street, Integer streetNumber, Integer number, String postalCode) {
        if(city != null){
            this.city = checkCity(city);
        }
        if(street != null){
            this.street = checkStreet(street);
        }
        if(streetNumber != null){
            this.streetNumber = checkNumber(streetNumber);
        }
        if(number != null){
            this.number = checkNumber(number);
        }
        if(postalCode != null){
            this.postalCode = new PostalCode(postalCode);
        }
        return this;
    }


    private String checkCity(String city){
        if(city == null ){
            throw new RuntimeException();
        }
        if(city.length() > 50){
            throw new IllegalArgumentException("too long city name");
        }
        return city;
    }

    private String checkStreet(String street){
        if(street == null ){
            throw new RuntimeException();
        }
        if(street.length() > 50){
            throw new IllegalArgumentException("too long city name");
        }
        return street;
    }

    private Integer checkStreetNumber(Integer streetNumber){
        if(streetNumber == null ){
            throw new RuntimeException();
        }
        if(streetNumber < 0){
            throw new IllegalArgumentException("streetNumber can not be less than 0");
        }
        return streetNumber;
    }

    private Integer checkNumber(Integer number){
        if(number == null ){
            throw new RuntimeException();
        }
        if(number < 0){
            throw new IllegalArgumentException("streetNumber can not be less than 0");
        }
        return number;
    }
}
