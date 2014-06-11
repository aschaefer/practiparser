package nu.schaefer.practiparser.json;

import java.util.HashMap;
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
    "pen_val",
    "pen_bin",
    "pen_name"
})
public class MatchPenalty {

    @JsonProperty("pen_val")
    private Integer penVal;
    @JsonProperty("pen_bin")
    private Boolean penBin;
    @JsonProperty("pen_name")
    private String penName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pen_val")
    public Integer getPenVal() {
        return penVal;
    }

    @JsonProperty("pen_val")
    public void setPenVal(Integer penVal) {
        this.penVal = penVal;
    }

    @JsonProperty("pen_bin")
    public Boolean getPenBin() {
        return penBin;
    }

    @JsonProperty("pen_bin")
    public void setPenBin(Boolean penBin) {
        this.penBin = penBin;
    }

    @JsonProperty("pen_name")
    public String getPenName() {
        return penName;
    }

    @JsonProperty("pen_name")
    public void setPenName(String penName) {
        this.penName = penName;
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
