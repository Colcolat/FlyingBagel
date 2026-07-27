package flyinginc.flyingbagel.persistence.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "airlines")
public class AirlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(name = "iata_code", length = 5)
    private String iataCode;
    private String region;

    @Column(name = "is_international")
    private Boolean isInternational;

    @Column(name = "required_document")
    private String requiredDocument;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightEntity> flights = new ArrayList<>();

    public AirlineEntity() {}
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIataCode() { return iataCode; }
    public void setIataCode(String iataCode) { this.iataCode = iataCode; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public Boolean getIsInternational() { return isInternational; }
    public void setIsInternational(Boolean international) { isInternational = international; }
    public String getRequiredDocument() { return requiredDocument; }
    public void setRequiredDocument(String requiredDocument) { this.requiredDocument = requiredDocument; }
    public List<FlightEntity> getFlights() { return flights; }
    public void setFlights(List<FlightEntity> flights) { this.flights = flights; }
    public void addFlight(FlightEntity flight) {
        flights.add(flight);
        flight.setAirline(this);
    }
}