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
    "sh_mod",
    "sh_ln",
    "sh_mil",
    "sh_wlk",
    "sh_age",
    "sh_law",
    "sh_eml",
    "mod_sq",
    "sh_lge",
    "sh_grd",
    "sh_frn",
    "sh_id",
    "mod_pf",
    "mod_pr",
    "sh_gen",
    "sh_cc",
    "mod_dv",
    "sh_dq",
    "mod_dq",
    "sh_dvp",
    "sh_uuid",
    "mod_dl",
    "sh_ph",
    "sh_num",
    "sh_lgp",
    "sh_del",
    "sh_sqd",
    "sh_fn",
    "sh_pf",
    "sh_uid"
})
public class MatchShooter {

    @JsonProperty("sh_mod")
    private String shMod;
    @JsonProperty("sh_ln")
    private String shLn;
    @JsonProperty("sh_mil")
    private Boolean shMil;
    @JsonProperty("sh_wlk")
    private Boolean shWlk;
    @JsonProperty("sh_age")
    private String shAge;
    @JsonProperty("sh_law")
    private Boolean shLaw;
    @JsonProperty("sh_eml")
    private String shEml;
    @JsonProperty("mod_sq")
    private String modSq;
    @JsonProperty("sh_lge")
    private Boolean shLge;
    @JsonProperty("sh_grd")
    private String shGrd;
    @JsonProperty("sh_frn")
    private Boolean shFrn;
    @JsonProperty("sh_id")
    private String shId;
    @JsonProperty("mod_pf")
    private String modPf;
    @JsonProperty("mod_pr")
    private String modPr;
    @JsonProperty("sh_gen")
    private String shGen;
    @JsonProperty("sh_cc")
    private String shCc;
    @JsonProperty("mod_dv")
    private String modDv;
    @JsonProperty("sh_dq")
    private Boolean shDq;
    @JsonProperty("mod_dq")
    private String modDq;
    @JsonProperty("sh_dvp")
    private String shDvp;
    @JsonProperty("sh_uuid")
    private String shUuid;
    @JsonProperty("mod_dl")
    private String modDl;
    @JsonProperty("sh_ph")
    private String shPh;
    @JsonProperty("sh_num")
    private Integer shNum;
    @JsonProperty("sh_lgp")
    private Boolean shLgp;
    @JsonProperty("sh_del")
    private Boolean shDel;
    @JsonProperty("sh_sqd")
    private Integer shSqd;
    @JsonProperty("sh_fn")
    private String shFn;
    @JsonProperty("sh_pf")
    private String shPf;
    @JsonProperty("sh_uid")
    private String shUid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sh_mod")
    public String getShMod() {
        return shMod;
    }

    @JsonProperty("sh_mod")
    public void setShMod(String shMod) {
        this.shMod = shMod;
    }

    @JsonProperty("sh_ln")
    public String getShLn() {
        return shLn;
    }

    @JsonProperty("sh_ln")
    public void setShLn(String shLn) {
        this.shLn = shLn;
    }

    @JsonProperty("sh_mil")
    public Boolean getShMil() {
        return shMil;
    }

    @JsonProperty("sh_mil")
    public void setShMil(Boolean shMil) {
        this.shMil = shMil;
    }

    @JsonProperty("sh_wlk")
    public Boolean getShWlk() {
        return shWlk;
    }

    @JsonProperty("sh_wlk")
    public void setShWlk(Boolean shWlk) {
        this.shWlk = shWlk;
    }

    @JsonProperty("sh_age")
    public String getShAge() {
        return shAge;
    }

    @JsonProperty("sh_age")
    public void setShAge(String shAge) {
        this.shAge = shAge;
    }

    @JsonProperty("sh_law")
    public Boolean getShLaw() {
        return shLaw;
    }

    @JsonProperty("sh_law")
    public void setShLaw(Boolean shLaw) {
        this.shLaw = shLaw;
    }

    @JsonProperty("sh_eml")
    public String getShEml() {
        return shEml;
    }

    @JsonProperty("sh_eml")
    public void setShEml(String shEml) {
        this.shEml = shEml;
    }

    @JsonProperty("mod_sq")
    public String getModSq() {
        return modSq;
    }

    @JsonProperty("mod_sq")
    public void setModSq(String modSq) {
        this.modSq = modSq;
    }

    @JsonProperty("sh_lge")
    public Boolean getShLge() {
        return shLge;
    }

    @JsonProperty("sh_lge")
    public void setShLge(Boolean shLge) {
        this.shLge = shLge;
    }

    @JsonProperty("sh_grd")
    public String getShGrd() {
        return shGrd;
    }

    @JsonProperty("sh_grd")
    public void setShGrd(String shGrd) {
        this.shGrd = shGrd;
    }

    @JsonProperty("sh_frn")
    public Boolean getShFrn() {
        return shFrn;
    }

    @JsonProperty("sh_frn")
    public void setShFrn(Boolean shFrn) {
        this.shFrn = shFrn;
    }

    @JsonProperty("sh_id")
    public String getShId() {
        return shId;
    }

    @JsonProperty("sh_id")
    public void setShId(String shId) {
        this.shId = shId;
    }

    @JsonProperty("mod_pf")
    public String getModPf() {
        return modPf;
    }

    @JsonProperty("mod_pf")
    public void setModPf(String modPf) {
        this.modPf = modPf;
    }

    @JsonProperty("mod_pr")
    public String getModPr() {
        return modPr;
    }

    @JsonProperty("mod_pr")
    public void setModPr(String modPr) {
        this.modPr = modPr;
    }

    @JsonProperty("sh_gen")
    public String getShGen() {
        return shGen;
    }

    @JsonProperty("sh_gen")
    public void setShGen(String shGen) {
        this.shGen = shGen;
    }

    @JsonProperty("sh_cc")
    public String getShCc() {
        return shCc;
    }

    @JsonProperty("sh_cc")
    public void setShCc(String shCc) {
        this.shCc = shCc;
    }

    @JsonProperty("mod_dv")
    public String getModDv() {
        return modDv;
    }

    @JsonProperty("mod_dv")
    public void setModDv(String modDv) {
        this.modDv = modDv;
    }

    @JsonProperty("sh_dq")
    public Boolean getShDq() {
        return shDq;
    }

    @JsonProperty("sh_dq")
    public void setShDq(Boolean shDq) {
        this.shDq = shDq;
    }

    @JsonProperty("mod_dq")
    public String getModDq() {
        return modDq;
    }

    @JsonProperty("mod_dq")
    public void setModDq(String modDq) {
        this.modDq = modDq;
    }

    @JsonProperty("sh_dvp")
    public String getShDvp() {
        return shDvp;
    }

    @JsonProperty("sh_dvp")
    public void setShDvp(String shDvp) {
        this.shDvp = shDvp;
    }

    @JsonProperty("sh_uuid")
    public String getShUuid() {
        return shUuid;
    }

    @JsonProperty("sh_uuid")
    public void setShUuid(String shUuid) {
        this.shUuid = shUuid;
    }

    @JsonProperty("mod_dl")
    public String getModDl() {
        return modDl;
    }

    @JsonProperty("mod_dl")
    public void setModDl(String modDl) {
        this.modDl = modDl;
    }

    @JsonProperty("sh_ph")
    public String getShPh() {
        return shPh;
    }

    @JsonProperty("sh_ph")
    public void setShPh(String shPh) {
        this.shPh = shPh;
    }

    @JsonProperty("sh_num")
    public Integer getShNum() {
        return shNum;
    }

    @JsonProperty("sh_num")
    public void setShNum(Integer shNum) {
        this.shNum = shNum;
    }

    @JsonProperty("sh_lgp")
    public Boolean getShLgp() {
        return shLgp;
    }

    @JsonProperty("sh_lgp")
    public void setShLgp(Boolean shLgp) {
        this.shLgp = shLgp;
    }

    @JsonProperty("sh_del")
    public Boolean getShDel() {
        return shDel;
    }

    @JsonProperty("sh_del")
    public void setShDel(Boolean shDel) {
        this.shDel = shDel;
    }

    @JsonProperty("sh_sqd")
    public Integer getShSqd() {
        return shSqd;
    }

    @JsonProperty("sh_sqd")
    public void setShSqd(Integer shSqd) {
        this.shSqd = shSqd;
    }

    @JsonProperty("sh_fn")
    public String getShFn() {
        return shFn;
    }

    @JsonProperty("sh_fn")
    public void setShFn(String shFn) {
        this.shFn = shFn;
    }

    @JsonProperty("sh_pf")
    public String getShPf() {
        return shPf;
    }

    @JsonProperty("sh_pf")
    public void setShPf(String shPf) {
        this.shPf = shPf;
    }

    @JsonProperty("sh_uid")
    public String getShUid() {
        return shUid;
    }

    @JsonProperty("sh_uid")
    public void setShUid(String shUid) {
        this.shUid = shUid;
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
