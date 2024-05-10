package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilText;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class PositionEntity {
    private String latitude;
    private String longitude;
    public PositionEntity() {
        setLongitude(EMPTY);
        setLatitude(EMPTY);
    }
    public PositionEntity(String latitude, String longitude) {
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

    public static PositionEntity build(){
        return new PositionEntity();
    }

    public static PositionEntity build(String latitude,String longitude){
        return new PositionEntity(latitude, longitude);
    }
}
