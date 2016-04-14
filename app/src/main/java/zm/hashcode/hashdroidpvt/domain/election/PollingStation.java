package zm.hashcode.hashdroidpvt.domain.election;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/09.
 */
public class PollingStation implements Serializable{
    private Long id;
    private String name;
    private int voters;
    private Map<String,String> location;

    private PollingStation(){

    }

    public Long getId() {
        return id;
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

    public PollingStation(Builder builder) {
        this.id= builder.id;
        this.location = builder.location;
        this.name = builder.name;
        this.voters = builder.voters;
    }

    public static class Builder{
        private Long id;
        private String name;
        private int voters;
        private Map<String,String> location;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }

        public Builder voters(Integer value){
            this.voters=value;
            return this;
        }

        public Builder location(Map<String,String> value){
            this.location=value;
            return this;
        }

        public Builder copy(PollingStation value){
            this.id=value.id;
            this.location = value.location;
            this.name = value.name;
            this.voters = value.voters;
            return this;
        }

        public PollingStation build(){
            return new PollingStation(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollingStation that = (PollingStation) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
