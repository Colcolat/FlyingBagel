package flyinginc.flyingbagel.persistence.entity;

import flyinginc.flyingbagel.domain.model.Airport;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="airports")
public class AirportEntity {

    /*
    private Integer id;
    private String name;
    private String code;
    private Integer terminals;
    private List<Airline> airlines = new ArrayList<>();
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "terminals")
    private Integer terminals;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "airport_id")
    private List<AirlineEntity> airlines = new ArrayList<>();

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTerminals() {
        return terminals;
    }

    public void setTerminals(Integer terminals) {
        this.terminals = terminals;
    }

    public List<AirlineEntity> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<AirlineEntity> airlines) {
        this.airlines = airlines;
    }
}
