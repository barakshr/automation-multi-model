package api.zippopotam.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlacesApi {

    private final String placeName;
    private final String longitude;
    private final String latitude;
    private final String state;
    private final String stateAbbreviation;

    public PlacesApi(@JsonProperty("place name") String placeName, @JsonProperty("longitude") String longitude, @JsonProperty("latitude") String latitude, @JsonProperty("state") String state, @JsonProperty("state abbreviation") String stateAbbreviation) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
    }

    @JsonProperty("place name")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
}
