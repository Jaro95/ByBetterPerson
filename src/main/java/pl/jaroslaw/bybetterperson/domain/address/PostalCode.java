package pl.jaroslaw.bybetterperson.domain.address;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
class PostalCode {

    private static final String POLISH_POSTAL_CODE_REGEX = "^[0-9]{2}-[0-9]{3}$";

    private String postalCode;

    protected PostalCode() {
    }

    public PostalCode(String postalCode) {
        isValid(postalCode);
        this.postalCode = postalCode;
    }

    private void isValid(String postalCode) {
        if (postalCode == null || postalCode.isEmpty()) {
            throw new IllegalArgumentException("wrong postalCode!");
        }
        if (!postalCode.matches(POLISH_POSTAL_CODE_REGEX)) {
            throw new IllegalArgumentException("Invalid postal code format! Expected format is XX-XXX");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode that = (PostalCode) o;
        return Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode);
    }
}
