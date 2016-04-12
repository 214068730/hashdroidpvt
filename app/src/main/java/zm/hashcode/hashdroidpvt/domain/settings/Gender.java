package zm.hashcode.hashdroidpvt.domain.settings;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Gender implements Serializable {

    private String id;
    private String name;
    private String state;

    private Gender(){}
    public  Gender(Builder builder) {
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
        public Builder copy(Gender gender){
            this.id = gender.id;
            this.name = gender.name;
            this.state = gender.state;

            return this;
        }
        public Gender build(){
            return new Gender(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        return id != null ? id.equals(gender.id) : gender.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
