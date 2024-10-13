package pl.jaroslaw.bybetterperson.domain.address;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class PostalCode {

    private static final String POLISH_POSTAL_CODE_REGEX = "^[0-9]{2}-[0-9]{3}$";

    private String value;

    protected PostalCode() {
    }

    public PostalCode(String value) {
        isValid(value);
        this.value = value;
    }

    private void isValid(String postalCode) {
        if (postalCode == null || postalCode.isEmpty()) {
            throw new IllegalArgumentException("wrong postalCode!");
        }
        if (!postalCode.matches(POLISH_POSTAL_CODE_REGEX)) {
            throw new IllegalArgumentException("Invalid postal code format! Expected format is XX-XXX");
        }
    }
}
