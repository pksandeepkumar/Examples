
package sbl.com.alarmmngrnetwrkoprations.pojos;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("org.jsonschema2pojo")
public class List {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("resources")
    @Expose
    private java.util.List<Resource> resources = new ArrayList<Resource>();

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The resources
     */
    public java.util.List<Resource> getResources() {
        return resources;
    }

    /**
     * 
     * @param resources
     *     The resources
     */
    public void setResources(java.util.List<Resource> resources) {
        this.resources = resources;
    }

}
