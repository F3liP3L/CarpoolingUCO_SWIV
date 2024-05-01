package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilText;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class PositionDTO {
    private String latitude;
    private String longitude;
    public PositionDTO() {
        setLongitude(EMPTY);
        setLatitude(EMPTY);
    }
    public PositionDTO(String latitude, String longitude) {
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
    public static PositionDTO build(){
        return new PositionDTO();
    }
}
