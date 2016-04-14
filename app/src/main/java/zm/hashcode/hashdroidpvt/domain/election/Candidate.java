package zm.hashcode.hashdroidpvt.domain.election;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Candidate implements Serializable{
    private Long id;
    private String candidateId;
    private String firstname;
    private String lastName;
    private byte[] candidateImage;
    private byte[] symbolImage;
    private String electionTypeId;

    private Candidate(){}

    public static class Builder{
        private Long id;
        private String candidateId;
        private String firstname;
        private String lastName;
        private byte[] candidateImage;
        private byte[] symbolImage;
        private String electionTypeId;

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
