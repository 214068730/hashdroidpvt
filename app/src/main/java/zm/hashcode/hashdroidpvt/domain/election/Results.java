package zm.hashcode.hashdroidpvt.domain.election;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Results implements Serializable {
    private Long id;
    private Map<String,Integer> results;
    private String location;
    private String agent;
    private Date date;
    private String status;
    private byte[] image;

    private Results(){}

    public Long getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
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

    public Results(Builder builder) {
        this.agent = builder.agent;
        this.date = builder.date;
        this.id = builder.id;
        this.image = builder.image;
        this.location = builder.location;
        this.status = builder.status;
        this.results = builder.results;
    }

    public static class Builder{
        private Long id;
        private Map<String,Integer> results;
        private String location;
        private String agent;
        private Date date;
        private String status;
        private byte[] image;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder results(Map<String,Integer> value){
            this.results=value;
            return this;
        }

        public Builder location(String value){
            this.location=value;
            return this;
        }

        public Builder agent(String value){
            this.agent=value;
            return this;
        }

        public Builder date(Date value){
            this.date=value;
            return this;
        }

        public Builder statusx(String value){
            this.status=value;
            return this;
        }

        public Builder image(byte[] value){
            this.image=value;
            return this;
        }

        public Builder copy(Results value){
            this.id=value.id;
            this.agent = value.agent;
            this.results = value.results;
            this.date = value.date;
            this.image = value.image;
            this.location = value.location;
            this.status = value.status;
            return this;
        }

        public Results build(){
            return new Results(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results = (Results) o;

        return id.equals(results.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
