package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Flight;
import flyinginc.flyingbagel.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    @Operation(description = "Create a new flight")
    public ResponseEntity<Flight> create(@RequestBody Flight flight) {
        return flightService.save(flight)
                .map(created -> ResponseEntity.status(HttpStatus.CREATED).body(created))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get all flights")
    public ResponseEntity<List<Flight>> getAll() {
        List<Flight> flights = flightService.findAll();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get a flight by ID")
    public ResponseEntity<Flight> getById(@PathVariable Integer id) {
        return flightService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete a flight by ID")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        if (flightService.deleteById(id)) {
            return ResponseEntity.ok(Map.of("message", "Flight with ID " + id + " was successfully deleted."));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "No flight found with ID " + id));
    }
}