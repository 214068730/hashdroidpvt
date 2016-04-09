package zm.hashcode.hashdroidpvt.domain.person;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2016/04/09.
 */
public class PersonContact implements Serializable {
    private Long id;
    private String contactTypeId;
    private String contactValue;
    private String status;
    private Date date;
    private String state;
}
