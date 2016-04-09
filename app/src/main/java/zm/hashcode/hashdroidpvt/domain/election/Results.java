package zm.hashcode.hashdroidpvt.domain.election;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/09.
 */
public class Results implements Serializable {
    private Long id;
    private Map<String,String> results;
    private byte[] image;
}
