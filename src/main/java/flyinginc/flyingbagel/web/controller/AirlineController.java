package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Airline;
import flyinginc.flyingbagel.service.AirlineService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    @Operation(description = "Create a new airline")
    public ResponseEntity<Airline> create(@RequestBody Airline airline) {
        Airline created = airlineService.save(airline);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get all airlines")
    public ResponseEntity<List<Airline>> getAll() {
        List<Airline> airlines = airlineService.findAll();
        return ResponseEntity.ok(airlines);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get an airline by ID")
    public ResponseEntity<Airline> getById(@PathVariable Integer id) {
        return airlineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete an airline by ID")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        if (airlineService.deleteById(id)) {
            return ResponseEntity.ok(Map.of("message", "Airline with ID " + id + " was successfully deleted."));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "No airline found with ID " + id));
    }
}