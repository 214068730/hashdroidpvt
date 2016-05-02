package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/29.
 */
public class ResultsResource implements Serializable {
    private Map<String, Integer> results;
    private String location;
    private String agent;
    private Date date;
    private String status;
    private Map<String, String> images;

    private ResultsResource() {
    }
    public Map<String, String> getImages() {
        return images;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getAgent() {
        return agent;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public ResultsResource(Builder builder) {
        this.agent = builder.agent;
        this.date = builder.date;
        this.images = builder.images;
        this.location = builder.location;
        this.status = builder.status;
        this.results = builder.results;
    }

    public static class Builder {
        private Map<String, Integer> results;
        private String location;
        private String agent;
        private Date date;
        private String status;
        private Map<String, String> images;

        public Builder results(Map<String, Integer> value) {
            this.results = value;
            return this;
        }

        public Builder location(String value) {
            this.location = value;
            return this;
        }

        public Builder agent(String value) {
            this.agent = value;
            return this;
        }

        public Builder date(Date value) {
            this.date = value;
            return this;
        }

        public Builder statusx(String value) {
            this.status = value;
            return this;
        }

        public Builder images(Map<String, String> value) {
            this.images = value;
            return this;
        }

        public Builder copy(ResultsResource value) {
            this.agent = value.agent;
            this.results = value.results;
            this.date = value.date;
            this.images = value.images;
            this.location = value.location;
            this.status = value.status;
            return this;
        }

        public ResultsResource build() {
            return new ResultsResource(this);
        }

    }

}
