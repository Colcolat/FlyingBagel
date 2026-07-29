package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Airport;
import flyinginc.flyingbagel.service.AirportService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    @Operation(description = "Create a new airport")
    public ResponseEntity<Airport> create(@RequestBody Airport airport) {
        Airport created = airportService.save(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
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
    @Operation(description = "Delete an airport by ID")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        if (airportService.deleteById(id)) {
            return ResponseEntity.ok(Map.of("message", "Airport with ID " + id + " was successfully deleted."));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "No airport found with ID " + id));
    }
}