package api.zippopotam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("country")
    private String country;
    @JsonProperty("post code")
    private String postCode;


    public Country( @JsonProperty("country") String country,@JsonProperty("post code") String postCode) {
        this.country = country;
        this.postCode = postCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }
}
