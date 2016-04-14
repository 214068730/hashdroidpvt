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

    public static class Builder{
        private Long id;
        private String name;
        private int voters;
        private Map<String,String> location;

        public Builder x(String value){
            this.s=value;
            return this;
        }

        public Builder x(String value){
            this.s=value;
            return this;
        }

        public Builder x(String value){
            this.s=value;
            return this;
        }

        public Builder x(String value){
            this.s=value;
            return this;
        }

        public Builder x(String value){
            this.s=value;
            return this;
        }

    }


}
