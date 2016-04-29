package zm.hashcode.hashdroidpvt.restapi.settings.resources;

import java.io.Serializable;

/**
 * Created by hashcode on 2016/04/29.
 */
public class Credential implements Serializable {
    private String email;
    private String value;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
