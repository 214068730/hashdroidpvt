package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/29.
 */
public class PollingStationResource implements Serializable {
    private String name;
    private int voters;
    private Map<String, String> location;
}
