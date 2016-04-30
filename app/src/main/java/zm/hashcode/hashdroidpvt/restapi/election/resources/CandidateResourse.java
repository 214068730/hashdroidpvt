package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/29.
 */
public class CandidateResourse implements Serializable {
    private String candidateId;
    private String firstname;
    private String lastName;
    private String candidateImageUrl;
    private String symbolImageUrl;
    private String electionTypeId;

    private CandidateResourse() {
    }

    public String getCandidateImageUrl() {
        return candidateImageUrl;
    }

    public String getSymbolImageUrl() {
        return symbolImageUrl;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }


    public String getElectionTypeId() {
        return electionTypeId;
    }

    public CandidateResourse(Builder builder) {
        this.candidateId = builder.candidateId;
        this.candidateImageUrl = builder.candidateImageUrl;
        this.electionTypeId = builder.electionTypeId;
        this.firstname = builder.firstname;
        this.lastName = builder.lastName;
        this.symbolImageUrl = builder.symbolImageUrl;
    }

    public static class Builder {
        private String candidateId;
        private String firstname;
        private String lastName;
        private String candidateImageUrl;
        private String symbolImageUrl;
        private String electionTypeId;


        public Builder candidateId(String value) {
            this.candidateId = value;
            return this;
        }

        public Builder firstname(String value) {
            this.firstname = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public Builder candidateImageUrl(String value) {
            this.candidateImageUrl = value;
            return this;
        }

        public Builder symbolImageUrl(String value) {
            this.symbolImageUrl = value;
            return this;
        }

        public Builder electionTypeId(String value) {
            this.electionTypeId = value;
            return this;
        }

        public Builder copy(CandidateResourse value) {

            this.lastName = value.lastName;
            this.candidateId = value.candidateId;
            this.candidateImageUrl = value.candidateImageUrl;
            this.firstname = value.firstname;
            this.electionTypeId = value.electionTypeId;
            this.symbolImageUrl = value.symbolImageUrl;
            return this;
        }

        public CandidateResourse build() {
            return new CandidateResourse(this);
        }

    }


}
