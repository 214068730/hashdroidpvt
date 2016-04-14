package zm.hashcode.hashdroidpvt.domain.person;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Person implements Serializable {
    private Long id;
    private String firstName;
    private String emailAddress;
    private String lastName;
    private String authvalue;

    private Person() {

    }

    public Long getId() {
        return id;
    }

    public String getAuthvalue() {
        return authvalue;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.emailAddress = builder.emailAddress;
        this.authvalue = builder.authvalue;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String emailAddress;
        private String lastName;
        private String authvalue;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public Builder emailAddress(String value) {
            this.emailAddress = value;
            return this;
        }

        public Builder authvalue(String value) {
            this.authvalue = value;
            return this;

        }

        public Builder copy(Person value) {
            this.id = value.id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.emailAddress = value.emailAddress;
            this.authvalue = value.authvalue;
            return this;
        }

        public Person build() {
            return new Person(this);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id != null ? id.equals(person.id) : person.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
