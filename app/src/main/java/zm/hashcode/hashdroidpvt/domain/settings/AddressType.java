package zm.hashcode.hashdroidpvt.domain.settings;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class AddressType implements Serializable {

    private String id;
    private String name;
    private String state;

    private AddressType(){}

    public AddressType(Builder builder) {
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

        public Builder copy(AddressType addressType){
            this.id = addressType.id;
            this.name = addressType.name;
            this.state = addressType.state;

            return this;
        }

        public AddressType build(){return new AddressType(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressType that = (AddressType) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
