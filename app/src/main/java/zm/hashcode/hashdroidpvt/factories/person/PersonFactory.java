package zm.hashcode.hashdroidpvt.factories.person;

import zm.hashcode.hashdroidpvt.domain.person.Person;

/**
 * Created by hashcode on 2016/04/12.
 */
public class PersonFactory {
    public static Person getPerson(String email,String lastname,String password){
        return new Person.Builder()
                .authvalue(password)
                .emailAddress(email)
                .lastName(lastname)
                .build();
    }
}
