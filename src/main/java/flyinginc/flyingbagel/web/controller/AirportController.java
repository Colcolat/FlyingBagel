package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Airport;
import flyinginc.flyingbagel.service.AirportService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create a new airport")
    public ResponseEntity<Airport> create(@RequestBody Airport airport) {
        Airport created = airportService.save(airport);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get all airports")
    public ResponseEntity<List<Airport>> getAll() {
        List<Airport> airports = airportService.findAll();
        return ResponseEntity.ok(airports);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get an airport by ID")
    public ResponseEntity<Airport> getById(@PathVariable Integer id) {
        return airportService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Delete an airport by ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        airportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}