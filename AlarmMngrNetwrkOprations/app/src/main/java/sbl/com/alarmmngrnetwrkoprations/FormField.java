
package sbl.com.alarmmngrnetwrkoprations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Generated("org.jsonschema2pojo")
public class FormField {

    @SerializedName("field_id")
    @Expose
    private String fieldId;
    @SerializedName("serial_no")
    @Expose
    private String serialNo;
    @SerializedName("form_id")
    @Expose
    private Integer formId;
    @SerializedName("field_name")
    @Expose
    private String fieldName;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("options")
    @Expose
    private String options;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("required")
    @Expose
    private Integer required;
    @SerializedName("has_remarks")
    @Expose
    private Integer hasRemarks;
    @SerializedName("weight")
    @Expose
    private Integer weight;

    /**
     * 
     * @return
     *     The fieldId
     */
    public String getFieldId() {
        return fieldId;
    }

    /**
     * 
     * @param fieldId
     *     The field_id
     */
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    /**
     * 
     * @return
     *     The serialNo
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 
     * @param serialNo
     *     The serial_no
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 
     * @return
     *     The formId
     */
    public Integer getFormId() {
        return formId;
    }

    /**
     * 
     * @param formId
     *     The form_id
     */
    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    /**
     * 
     * @return
     *     The fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 
     * @param fieldName
     *     The field_name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
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
     *     The options
     */
    public String getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    public void setOptions(String options) {
        this.options = options;
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
     *     The required
     */
    public Integer getRequired() {
        return required;
    }

    /**
     * 
     * @param required
     *     The required
     */
    public void setRequired(Integer required) {
        this.required = required;
    }

    /**
     * 
     * @return
     *     The hasRemarks
     */
    public Integer getHasRemarks() {
        return hasRemarks;
    }

    /**
     * 
     * @param hasRemarks
     *     The has_remarks
     */
    public void setHasRemarks(Integer hasRemarks) {
        this.hasRemarks = hasRemarks;
    }

    /**
     * 
     * @return
     *     The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
