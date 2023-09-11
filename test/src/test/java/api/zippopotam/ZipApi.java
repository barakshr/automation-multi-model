package api.zippopotam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ZipApi {

    private final String postCode;
    private final String country;
    private final String countryAbbreviation;

    private final   List<PlacesApi> placesApiList;




    public ZipApi(@JsonProperty("post code") String postCode, @JsonProperty("country") String country, @JsonProperty("country abbreviation") String countryAbbreviation, @JsonProperty("places") List<PlacesApi> placesApiList) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.placesApiList = placesApiList;
    }

    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country abbreviation")
    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    @JsonProperty("places")
    public List<PlacesApi> getPlacesList() {
        return placesApiList;
    }
}
