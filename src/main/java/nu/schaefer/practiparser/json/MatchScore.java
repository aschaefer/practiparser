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
    "stage_stagescores",
    "stage_number",
    "stage_uuid"
})
public class MatchScore {

    @JsonProperty("stage_stagescores")
    private List<StageStagescore> stageStagescores = new ArrayList<StageStagescore>();
    @JsonProperty("stage_number")
    private Integer stageNumber;
    @JsonProperty("stage_uuid")
    private String stageUuid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stage_stagescores")
    public List<StageStagescore> getStageStagescores() {
        return stageStagescores;
    }

    @JsonProperty("stage_stagescores")
    public void setStageStagescores(List<StageStagescore> stageStagescores) {
        this.stageStagescores = stageStagescores;
    }

    @JsonProperty("stage_number")
    public Integer getStageNumber() {
        return stageNumber;
    }

    @JsonProperty("stage_number")
    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    @JsonProperty("stage_uuid")
    public String getStageUuid() {
        return stageUuid;
    }

    @JsonProperty("stage_uuid")
    public void setStageUuid(String stageUuid) {
        this.stageUuid = stageUuid;
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
