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
            return this;
        }

    }
}
