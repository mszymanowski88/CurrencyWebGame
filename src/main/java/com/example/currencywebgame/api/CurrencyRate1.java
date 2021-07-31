//
//
//package com.example.currencywebgame.api;
//
//import com.fasterxml.jackson.annotation.*;
//
//import javax.annotation.Generated;
//import java.util.HashMap;
//import java.util.Map;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "effectiveDate",
//    "currency",
//    "code",
//    "mid"
//})
//@Generated("jsonschema2pojo")
//public class CurrencyRate1 {
//
//    @JsonProperty("effectiveDate")
//    private String effectiveDate;
//    @JsonProperty("currency")
//    private String currency;
//    @JsonProperty("code")
//    private String code;
//    @JsonProperty("mid")
//    private Double mid;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonProperty("effectiveDate")
//    public String getEffectiveDate() {
//        return effectiveDate;
//    }
//
//    @JsonProperty("effectiveDate")
//    public void setEffectiveDate(String effectiveDate) {
//        this.effectiveDate = effectiveDate;
//    }
//
//    @JsonProperty("currency")
//    public String getCurrency() {
//        return currency;
//    }
//
//    @JsonProperty("currency")
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    @JsonProperty("code")
//    public String getCode() {
//        return code;
//    }
//
//    @JsonProperty("code")
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    @JsonProperty("mid")
//    public Double getMid() {
//        return mid;
//    }
//
//    @JsonProperty("mid")
//    public void setMid(Double mid) {
//        this.mid = mid;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//
//    @Override
//    public String toString() {
//        return "CurrencyRate{" +
//                "effectiveDate='" + effectiveDate + '\'' +
//                ", currency='" + currency + '\'' +
//                ", code='" + code + '\'' +
//                ", mid=" + mid +
//                ", additionalProperties=" + additionalProperties +
//                '}';
//    }
//}
