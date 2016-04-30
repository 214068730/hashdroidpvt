package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/29.
 */
public class PollingStationResource implements Serializable {
    private String name;
    private int voters;
    private Map<String, String> location;

    private PollingStationResource() {

    }


    public Map<String, String> getLocation() {
        return location;
    }

    public int getVoters() {
        return voters;
    }

    public String getName() {
        return name;
    }

    public PollingStationResource(Builder builder) {
        this.location = builder.location;
        this.name = builder.name;
        this.voters = builder.voters;
    }

    public static class Builder {
        private String name;
        private int voters;
        private Map<String, String> location;


        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder voters(Integer value) {
            this.voters = value;
            return this;
        }

        public Builder location(Map<String, String> value) {
            this.location = value;
            return this;
        }

        public Builder copy(PollingStationResource value) {
            this.location = value.location;
            this.name = value.name;
            this.voters = value.voters;
            return this;
        }

        public PollingStationResource build() {
            return new PollingStationResource(this);
        }

    }

}
