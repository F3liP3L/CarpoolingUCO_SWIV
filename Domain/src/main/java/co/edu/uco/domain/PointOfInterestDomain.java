package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class PointOfInterestDomain {
    private UUID id;
    private String name;
    private CityDomain city;

    public PointOfInterestDomain(UUID id, String name, CityDomain city) {
        setId(id);
        setCity(city);
        setName(name);
    }

    public PointOfInterestDomain() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public CityDomain getCity() {
        return city;
    }

    public void setCity(CityDomain city) {
        this.city = UtilObject.getUtilObject().getDefaultIsNull(city, CityDomain.build());
    }

    public static final PointOfInterestDomain build() {
        return new PointOfInterestDomain();
    }

}
