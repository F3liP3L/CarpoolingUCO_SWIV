package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilText;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class PositionDomain {
    private String latitude;
    private String longitude;
    public PositionDomain() {
        setLongitude(EMPTY);
        setLatitude(EMPTY);
    }
    public PositionDomain(String latitude, String longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = UtilText.getUtilText().trim(longitude);
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = UtilText.getUtilText().trim(latitude);
    }
    public static PositionDomain build(){
        return new PositionDomain();
    }
}
