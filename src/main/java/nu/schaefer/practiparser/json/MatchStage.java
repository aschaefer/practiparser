package nu.schaefer.practiparser.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "stage_poppers",
    "stage_number",
    "stage_tppoints",
    "stage_uuid",
    "stage_targets",
    "stage_name",
    "stage_deleted",
    "stage_classifier",
    "stage_scoretype",
    "stage_modifieddate",
    "stage_classifiercode",
    "stage_strings",
    "stage_noshoots"
})
public class MatchStage {

    @JsonProperty("stage_poppers")
    private Integer stagePoppers;
    @JsonProperty("stage_number")
    private Integer stageNumber;
    @JsonProperty("stage_tppoints")
    private Integer stageTppoints;
    @JsonProperty("stage_uuid")
    private String stageUuid;
    @JsonProperty("stage_targets")
    private List<Object> stageTargets = new ArrayList<Object>();
    @JsonProperty("stage_name")
    private String stageName;
    @JsonProperty("stage_deleted")
    private Boolean stageDeleted;
    @JsonProperty("stage_classifier")
    private Boolean stageClassifier;
    @JsonProperty("stage_scoretype")
    private String stageScoretype;
    @JsonProperty("stage_modifieddate")
    private String stageModifieddate;
    @JsonProperty("stage_classifiercode")
    private String stageClassifiercode;
    @JsonProperty("stage_strings")
    private Integer stageStrings;
    @JsonProperty("stage_noshoots")
    private Boolean stageNoshoots;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stage_poppers")
    public Integer getStagePoppers() {
        return stagePoppers;
    }

    @JsonProperty("stage_poppers")
    public void setStagePoppers(Integer stagePoppers) {
        this.stagePoppers = stagePoppers;
    }

    @JsonProperty("stage_number")
    public Integer getStageNumber() {
        return stageNumber;
    }

    @JsonProperty("stage_number")
    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    @JsonProperty("stage_tppoints")
    public Integer getStageTppoints() {
        return stageTppoints;
    }

    @JsonProperty("stage_tppoints")
    public void setStageTppoints(Integer stageTppoints) {
        this.stageTppoints = stageTppoints;
    }

    @JsonProperty("stage_uuid")
    public String getStageUuid() {
        return stageUuid;
    }

    @JsonProperty("stage_uuid")
    public void setStageUuid(String stageUuid) {
        this.stageUuid = stageUuid;
    }

    @JsonProperty("stage_targets")
    public List<Object> getStageTargets() {
        return stageTargets;
    }

    @JsonProperty("stage_targets")
    public void setStageTargets(List<Object> stageTargets) {
        this.stageTargets = stageTargets;
    }

    @JsonProperty("stage_name")
    public String getStageName() {
        return stageName;
    }

    @JsonProperty("stage_name")
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    
    @JsonProperty("stage_deleted")
    public Boolean getStageDeleted() {
        return stageDeleted;
    }

    @JsonProperty("stage_deleted")
    public void setStageDeleted(Boolean deleted) {
        this.stageDeleted = deleted;
    }
    
    @JsonProperty("stage_classifier")
    public Boolean getStageClassifier() {
        return stageClassifier;
    }

    @JsonProperty("stage_classifier")
    public void setStageClassifier(Boolean stageClassifier) {
        this.stageClassifier = stageClassifier;
    }

    @JsonProperty("stage_scoretype")
    public String getStageScoretype() {
        return stageScoretype;
    }

    @JsonProperty("stage_scoretype")
    public void setStageScoretype(String stageScoretype) {
        this.stageScoretype = stageScoretype;
    }

    @JsonProperty("stage_modifieddate")
    public String getStageModifieddate() {
        return stageModifieddate;
    }

    @JsonProperty("stage_modifieddate")
    public void setStageModifieddate(String stageModifieddate) {
        this.stageModifieddate = stageModifieddate;
    }

    @JsonProperty("stage_classifiercode")
    public String getStageClassifiercode() {
        return stageClassifiercode;
    }

    @JsonProperty("stage_classifiercode")
    public void setStageClassifiercode(String stageClassifiercode) {
        this.stageClassifiercode = stageClassifiercode;
    }

    @JsonProperty("stage_strings")
    public Integer getStageStrings() {
        return stageStrings;
    }

    @JsonProperty("stage_strings")
    public void setStageStrings(Integer stageStrings) {
        this.stageStrings = stageStrings;
    }

    @JsonProperty("stage_noshoots")
    public Boolean getStageNoshoots() {
        return stageNoshoots;
    }
   

    @JsonProperty("stage_noshoots")
    public void setStageNoshoots(Boolean stageNoshoots) {
        this.stageNoshoots = stageNoshoots;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
