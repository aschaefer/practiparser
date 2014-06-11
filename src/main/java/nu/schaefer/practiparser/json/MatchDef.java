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
    "match_type",
    "match_date",
    "match_approvescores",
    "match_name",
    "match_cats",
    "match_id",
    "match_readonly",
    "version",
    "match_bonuses",
    "match_penalties",
    "match_cls",
    "match_logenabled",
    "match_stages",
    "match_modifieddate",
    "match_shooters",
    "match_creationdate",
    "match_owner"
})
public class MatchDef {

    @JsonProperty("match_type")
    private String matchType;
    @JsonProperty("match_date")
    private String matchDate;
    @JsonProperty("match_approvescores")
    private Boolean matchApprovescores;
    @JsonProperty("match_name")
    private String matchName;
    @JsonProperty("match_cats")
    private List<String> matchCats = new ArrayList<String>();
    @JsonProperty("match_id")
    private String matchId;
    @JsonProperty("match_readonly")
    private Boolean matchReadonly;
    @JsonProperty("version")
    private String version;
    @JsonProperty("match_bonuses")
    private List<Object> matchBonuses = new ArrayList<Object>();
    @JsonProperty("match_penalties")
    private List<MatchPenalty> matchPenalties = new ArrayList<MatchPenalty>();
    @JsonProperty("match_cls")
    private List<String> matchCls = new ArrayList<String>();
    @JsonProperty("match_logenabled")
    private Boolean matchLogenabled;
    @JsonProperty("match_stages")
    private List<MatchStage> matchStages = new ArrayList<MatchStage>();
    @JsonProperty("match_modifieddate")
    private String matchModifieddate;
    @JsonProperty("match_shooters")
    private List<MatchShooter> matchShooters = new ArrayList<MatchShooter>();
    @JsonProperty("match_creationdate")
    private String matchCreationdate;
    @JsonProperty("match_owner")
    private Boolean matchOwner;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("match_type")
    public String getMatchType() {
        return matchType;
    }

    @JsonProperty("match_type")
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @JsonProperty("match_date")
    public String getMatchDate() {
        return matchDate;
    }

    @JsonProperty("match_date")
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @JsonProperty("match_approvescores")
    public Boolean getMatchApprovescores() {
        return matchApprovescores;
    }

    @JsonProperty("match_approvescores")
    public void setMatchApprovescores(Boolean matchApprovescores) {
        this.matchApprovescores = matchApprovescores;
    }

    @JsonProperty("match_name")
    public String getMatchName() {
        return matchName;
    }

    @JsonProperty("match_name")
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    @JsonProperty("match_cats")
    public List<String> getMatchCats() {
        return matchCats;
    }

    @JsonProperty("match_cats")
    public void setMatchCats(List<String> matchCats) {
        this.matchCats = matchCats;
    }

    @JsonProperty("match_id")
    public String getMatchId() {
        return matchId;
    }

    @JsonProperty("match_id")
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @JsonProperty("match_readonly")
    public Boolean getMatchReadonly() {
        return matchReadonly;
    }

    @JsonProperty("match_readonly")
    public void setMatchReadonly(Boolean matchReadonly) {
        this.matchReadonly = matchReadonly;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("match_bonuses")
    public List<Object> getMatchBonuses() {
        return matchBonuses;
    }

    @JsonProperty("match_bonuses")
    public void setMatchBonuses(List<Object> matchBonuses) {
        this.matchBonuses = matchBonuses;
    }

    @JsonProperty("match_penalties")
    public List<MatchPenalty> getMatchPenalties() {
        return matchPenalties;
    }

    @JsonProperty("match_penalties")
    public void setMatchPenalties(List<MatchPenalty> matchPenalties) {
        this.matchPenalties = matchPenalties;
    }

    @JsonProperty("match_cls")
    public List<String> getMatchCls() {
        return matchCls;
    }

    @JsonProperty("match_cls")
    public void setMatchCls(List<String> matchCls) {
        this.matchCls = matchCls;
    }

    @JsonProperty("match_logenabled")
    public Boolean getMatchLogenabled() {
        return matchLogenabled;
    }

    @JsonProperty("match_logenabled")
    public void setMatchLogenabled(Boolean matchLogenabled) {
        this.matchLogenabled = matchLogenabled;
    }

    @JsonProperty("match_stages")
    public List<MatchStage> getMatchStages() {
        return matchStages;
    }

    @JsonProperty("match_stages")
    public void setMatchStages(List<MatchStage> matchStages) {
        this.matchStages = matchStages;
    }

    @JsonProperty("match_modifieddate")
    public String getMatchModifieddate() {
        return matchModifieddate;
    }

    @JsonProperty("match_modifieddate")
    public void setMatchModifieddate(String matchModifieddate) {
        this.matchModifieddate = matchModifieddate;
    }

    @JsonProperty("match_shooters")
    public List<MatchShooter> getMatchShooters() {
        return matchShooters;
    }

    @JsonProperty("match_shooters")
    public void setMatchShooters(List<MatchShooter> matchShooters) {
        this.matchShooters = matchShooters;
    }

    @JsonProperty("match_creationdate")
    public String getMatchCreationdate() {
        return matchCreationdate;
    }

    @JsonProperty("match_creationdate")
    public void setMatchCreationdate(String matchCreationdate) {
        this.matchCreationdate = matchCreationdate;
    }

    @JsonProperty("match_owner")
    public Boolean getMatchOwner() {
        return matchOwner;
    }

    @JsonProperty("match_owner")
    public void setMatchOwner(Boolean matchOwner) {
        this.matchOwner = matchOwner;
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
