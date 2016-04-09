package zm.hashcode.hashdroidpvt.domain.person;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2016/04/09.
 */
public class PersonAddress implements Serializable {
    private Long id;
    private String description;
    private String postalCode;
    private String addressTypeId;
    private Date date;
}
