package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/29.
 */
public class ElectionsResource implements Serializable {
    private String electionTypeId;
    private String name;

    private ElectionsResource() {
    }

    public String getElectionTypeId() {
        return electionTypeId;
    }

    public String getName() {
        return name;
    }

    public ElectionsResource(Builder builder) {
        this.electionTypeId = builder.electionTypeId;
        this.name = builder.name;
    }


    public static class Builder {
        private Long id;
        private String electionTypeId;
        private String name;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder electionTypeId(String value) {
            this.electionTypeId = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder copy(ElectionsResource value) {
            this.electionTypeId = value.electionTypeId;
            this.name = value.name;
            return this;
        }

        public ElectionsResource build() {
            return new ElectionsResource(this);
        }

    }
}

