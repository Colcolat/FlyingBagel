package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Flight;
import flyinginc.flyingbagel.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody Flight flight) {
        return flightService.save(flight)
                .map(created -> ResponseEntity.status(HttpStatus.CREATED).body(created))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getById(@PathVariable Integer id) {
        return flightService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (flightService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}