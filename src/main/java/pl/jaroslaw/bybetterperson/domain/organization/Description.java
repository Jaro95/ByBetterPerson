package pl.jaroslaw.bybetterperson.domain.organization;

import jakarta.persistence.Embeddable;

@Embeddable
class Description {

    private static final int MAX_LENGTH_NAME = 100;
    private static final int MAX_LENGTH_DESCRIPTION = 1000;
    private String name;
    private String description;

    protected Description() {
    }

    public Description(String name, String description) {
        check(name, description);
        this.name = name;
        this.description = description;
    }

    public Description update(String description, String name) {
        if (description != null) {
            this.description = description;
        }
        if (name != null) {
            this.name = name;
        }
        return this;
    }

    private void check(String name, String description) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("length name is too long!");
        }
        if (description.length() > MAX_LENGTH_DESCRIPTION) {
            throw new IllegalArgumentException("length description is too long!");
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
