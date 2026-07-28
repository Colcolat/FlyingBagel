package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Airport;
import flyinginc.flyingbagel.domain.model.Flight;
import flyinginc.flyingbagel.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportController airportController, AirportService airportService){
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<Airport> create(@RequestBody Airport airport) {
        Airport created = airportService.save(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
