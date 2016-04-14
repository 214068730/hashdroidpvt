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

    public Long getId() {
        return id;
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

    public byte[] getCandidateImage() {
        return candidateImage;
    }

    public byte[] getSymbolImage() {
        return symbolImage;
    }

    public String getElectionTypeId() {
        return electionTypeId;
    }

    public Candidate(Builder builder) {
        this.candidateId= builder.candidateId;
        this.candidateImage = builder.candidateImage;
        this.electionTypeId = builder.electionTypeId;
        this.firstname= builder.firstname;
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.symbolImage = builder.symbolImage;
    }

    public static class Builder{
        private Long id;
        private String candidateId;
        private String firstname;
        private String lastName;
        private byte[] candidateImage;
        private byte[] symbolImage;
        private String electionTypeId;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder candidateId(String value){
            this.candidateId=value;
            return this;
        }

        public Builder firstname(String value){
            this.firstname=value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }

        public Builder candidateImage(byte[] value){
            this.candidateImage=value;
            return this;
        }
        public Builder symbolImage(byte[] value){
            this.symbolImage=value;
            return this;
        }
        public Builder electionTypeId(String value){
            this.electionTypeId=value;
            return this;
        }
        public Builder copy(Candidate value){
            this.id=value.id;
            this.lastName= value.lastName;
            this.candidateId=value.candidateId;
            this.candidateImage = value.candidateImage;
            this.firstname = value.firstname;
            this.electionTypeId=value.electionTypeId;
            this.symbolImage = value.symbolImage;
            return this;
        }

        public Candidate build(){
            return new Candidate(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return id != null ? id.equals(candidate.id) : candidate.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
