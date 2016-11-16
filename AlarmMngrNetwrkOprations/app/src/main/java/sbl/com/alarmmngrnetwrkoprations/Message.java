
package sbl.com.alarmmngrnetwrkoprations;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("org.jsonschema2pojo")
public class Message {

    @SerializedName("form_id")
    @Expose
    private String formId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("form_fields")
    @Expose
    private List<FormField> formFields = new ArrayList<FormField>();

    /**
     * 
     * @return
     *     The formId
     */
    public String getFormId() {
        return formId;
    }

    /**
     * 
     * @param formId
     *     The form_id
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The formFields
     */
    public List<FormField> getFormFields() {
        return formFields;
    }

    /**
     * 
     * @param formFields
     *     The form_fields
     */
    public void setFormFields(List<FormField> formFields) {
        this.formFields = formFields;
    }

}
