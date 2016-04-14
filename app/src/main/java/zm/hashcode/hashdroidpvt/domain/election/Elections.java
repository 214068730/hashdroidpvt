package zm.hashcode.hashdroidpvt.domain.election;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Elections implements Serializable {
    private Long id;
    private String electionTypeId;
    private String name;

    private Elections(){}

    public Long getId() {
        return id;
    }

    public String getElectionTypeId() {
        return electionTypeId;
    }

    public String getName() {
        return name;
    }

    public Elections(Builder builder) {
        this.id = builder.id;
        this.electionTypeId = builder.electionTypeId;
        this.name=builder.name;
    }


    public static class Builder{
        private Long id;
        private String electionTypeId;
        private String name;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder electionTypeId(String value){
            this.electionTypeId=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }

        public Builder copy(Elections value){
            this.id=value.id;
            this.electionTypeId=value.electionTypeId;
            this.name = value.name;
            return this;
        }

        public Elections build(){
            return new Elections(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elections elections = (Elections) o;

        return id != null ? id.equals(elections.id) : elections.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
