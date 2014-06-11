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
    "popm",
    "dnf",
    "aprv",
    "ts",
    "str",
    "penss",
    "poph",
    "bonss",
    "mod",
    "shtr"
})
public class StageStagescore {

    @JsonProperty("popm")
    private Integer popm;
    @JsonProperty("dnf")
    private Boolean dnf;
    @JsonProperty("aprv")
    private Boolean aprv;
    @JsonProperty("ts")
    private List<Object> ts = new ArrayList<Object>();
    @JsonProperty("str")
    private List<Double> str = new ArrayList<Double>();
    @JsonProperty("penss")
    private List<List<Integer>> penss = new ArrayList<List<Integer>>();
    @JsonProperty("poph")
    private Integer poph;
    @JsonProperty("bonss")
    private List<List<Object>> bonss = new ArrayList<List<Object>>();
    @JsonProperty("mod")
    private String mod;
    @JsonProperty("shtr")
    private String shtr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("popm")
    public Integer getPopm() {
        return popm;
    }

    @JsonProperty("popm")
    public void setPopm(Integer popm) {
        this.popm = popm;
    }

    @JsonProperty("dnf")
    public Boolean getDnf() {
        return dnf;
    }

    @JsonProperty("dnf")
    public void setDnf(Boolean dnf) {
        this.dnf = dnf;
    }

    @JsonProperty("aprv")
    public Boolean getAprv() {
        return aprv;
    }

    @JsonProperty("aprv")
    public void setAprv(Boolean aprv) {
        this.aprv = aprv;
    }

    @JsonProperty("ts")
    public List<Object> getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(List<Object> ts) {
        this.ts = ts;
    }

    @JsonProperty("str")
    public List<Double> getStr() {
        return str;
    }

    @JsonProperty("str")
    public void setStr(List<Double> str) {
        this.str = str;
    }

    @JsonProperty("penss")
    public List<List<Integer>> getPenss() {
        return penss;
    }

    @JsonProperty("penss")
    public void setPenss(List<List<Integer>> penss) {
        this.penss = penss;
    }

    @JsonProperty("poph")
    public Integer getPoph() {
        return poph;
    }

    @JsonProperty("poph")
    public void setPoph(Integer poph) {
        this.poph = poph;
    }

    @JsonProperty("bonss")
    public List<List<Object>> getBonss() {
        return bonss;
    }

    @JsonProperty("bonss")
    public void setBonss(List<List<Object>> bonss) {
        this.bonss = bonss;
    }

    @JsonProperty("mod")
    public String getMod() {
        return mod;
    }

    @JsonProperty("mod")
    public void setMod(String mod) {
        this.mod = mod;
    }

    @JsonProperty("shtr")
    public String getShtr() {
        return shtr;
    }

    @JsonProperty("shtr")
    public void setShtr(String shtr) {
        this.shtr = shtr;
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
