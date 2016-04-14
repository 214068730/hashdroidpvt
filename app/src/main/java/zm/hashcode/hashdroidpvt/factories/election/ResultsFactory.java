package zm.hashcode.hashdroidpvt.factories.election;

import java.util.Date;
import java.util.Map;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.election.Results;
import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.domain.person.PersonContact;

/**
 * Created by hashcode on 2016/04/12.
 */
public class ResultsFactory {
    public static Results createReult(Person person, byte[] image, Map<String,Integer> results){
        return new Results.Builder()
                .statusx(DomainState.NOTUPLOADED.name())
                .agent(person.getEmailAddress())
                .image(image)
                .location(" Get Location from Service")
                .results(results)
                .date(new Date())
                .build();
    }
}
