package flyinginc.flyingbagel.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private Integer id;
    private String name;
    private String iataCode;
    private String region;
    private Boolean isInternational;
    private String requiredDocument;
    private List<Flight> flights = new ArrayList<>();

    public Airline() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public String getRequiredDocument() {
        return requiredDocument;
    }

    public void setRequiredDocument(String requiredDocument) {
        this.requiredDocument = requiredDocument;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

}