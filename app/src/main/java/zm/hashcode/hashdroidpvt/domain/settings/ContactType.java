package zm.hashcode.hashdroidpvt.domain.settings;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class ContactType implements Serializable{

    private String id;
    private String name;
    private String state;

    private ContactType(){}

    public ContactType(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.state = builder.state;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public static class Builder{
        private String id;
        private String name;
        private String state;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder copy(ContactType contactType){
            this.id = contactType.id;
            this.name = contactType.name;
            this.state = contactType.state;
            return this;
        }

        public ContactType build(){return new ContactType(this);}
    }
    public static Builder builder(){return new Builder();}


}
