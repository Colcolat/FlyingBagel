package flyinginc.flyingbagel.web.controller;

import flyinginc.flyingbagel.domain.model.Airline;
import flyinginc.flyingbagel.service.AirlineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public ResponseEntity<Airline> create(@RequestBody Airline airline) {
        Airline created = airlineService.save(airline);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Airline>> getAll() {
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getById(@PathVariable Integer id) {
        return airlineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (airlineService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}