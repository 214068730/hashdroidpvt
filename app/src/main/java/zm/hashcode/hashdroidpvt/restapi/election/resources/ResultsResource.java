package zm.hashcode.hashdroidpvt.restapi.election.resources;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by hashcode on 2016/04/29.
 */
public class ResultsResource implements Serializable {
    private Map<String, Integer> results;
    private String location;
    private String agent;
    private Date date;
    private String status;
    private String imageUrl;
}
