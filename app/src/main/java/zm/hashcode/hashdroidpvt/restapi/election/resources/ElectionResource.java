package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/29.
 */
public class ElectionResource implements Serializable {
    private String electionTypeId;
    private String name;

    private ElectionResource() {
    }

    public String getElectionTypeId() {
        return electionTypeId;
    }

    public String getName() {
        return name;
    }

    public ElectionResource(Builder builder) {
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

        public Builder copy(ElectionResource value) {
            this.electionTypeId = value.electionTypeId;
            this.name = value.name;
            return this;
        }

        public ElectionResource build() {
            return new ElectionResource(this);
        }

    }
}

