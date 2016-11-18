
package sbl.com.alarmmngrnetwrkoprations.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("org.jsonschema2pojo")
public class Resource {

    @SerializedName("resource")
    @Expose
    private Resource_ resource;

    /**
     * 
     * @return
     *     The resource
     */
    public Resource_ getResource() {
        return resource;
    }

    /**
     * 
     * @param resource
     *     The resource
     */
    public void setResource(Resource_ resource) {
        this.resource = resource;
    }

}
