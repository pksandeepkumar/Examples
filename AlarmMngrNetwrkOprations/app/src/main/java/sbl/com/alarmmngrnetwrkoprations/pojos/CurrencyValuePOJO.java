
package sbl.com.alarmmngrnetwrkoprations.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("org.jsonschema2pojo")
public class CurrencyValuePOJO {

    @SerializedName("list")
    @Expose
    private List list;

    /**
     * 
     * @return
     *     The list
     */
    public List getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(List list) {
        this.list = list;
    }

}
