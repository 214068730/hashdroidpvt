package zm.hashcode.hashdroidpvt.restapi.person.resources;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2016/04/29.
 */
public class PersonAddressResource implements Serializable {
    private String email;
    private String description;
    private String postalCode;
    private String addressTypeId;
    private String status;
    private Date date;
    private String state;

    private PersonAddressResource() {
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public PersonAddressResource(Builder builder) {
        this.email = builder.email;
        this.description = builder.description;
        this.postalCode = builder.postalCode;
        this.addressTypeId = builder.addressTypeId;
        this.date = builder.date;
        this.state = builder.state;
        this.status = builder.status;
    }

    public static class Builder {
        private String email;
        private String description;
        private String postalCode;
        private String addressTypeId;
        private String status;
        private Date date;
        private String state;

        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder date(Date value) {
            this.date = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder postalCode(String value) {
            this.postalCode = value;
            return this;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder state(String value) {
            this.state = value;
            return this;
        }

        public Builder addressTypeId(String value) {
            this.addressTypeId = value;
            return this;
        }

        public Builder copy(PersonAddressResource value) {
            this.email = value.email;
            this.description = value.description;
            this.addressTypeId = value.addressTypeId;
            this.state = value.state;
            this.date = value.date;
            this.status = value.status;
            this.postalCode = value.postalCode;
            return this;
        }

        public PersonAddressResource build() {
            return new PersonAddressResource(this);
        }
    }

}
