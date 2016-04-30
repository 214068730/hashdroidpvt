package zm.hashcode.hashdroidpvt.restapi.person.resources;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2016/04/29.
 */
public class PersonContactResource implements Serializable {
    private String email;
    private String contactTypeId;
    private String contactValue;
    private String status;
    private Date date;
    private String state;

    private PersonContactResource() {
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getContactValue() {
        return contactValue;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public PersonContactResource(Builder builder) {
        this.email = builder.email;
        this.contactTypeId = builder.contactTypeId;
        this.contactValue = builder.contactValue;
        this.date = builder.date;
        this.state = builder.state;
        this.status = builder.status;
    }

    public static class Builder {
        private String email;
        private String contactTypeId;
        private String contactValue;
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

        public Builder contactTypeId(String value) {
            this.contactTypeId = value;
            return this;
        }

        public Builder contactValue(String value) {
            this.contactValue = value;
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

        public Builder copy(PersonContactResource value) {
            this.email = value.email;
            this.contactTypeId = value.contactTypeId;
            this.contactValue = value.contactValue;
            this.state = value.state;
            this.date = value.date;
            this.status = value.status;
            return this;
        }

        public PersonContactResource build() {
            return new PersonContactResource(this);
        }
    }


}
