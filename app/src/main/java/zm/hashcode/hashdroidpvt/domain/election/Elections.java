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

    public static class Builder{
        private Long id;
        private String electionTypeId;
        private String name;

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
