package de.infonautika.vdd.vehicledamagedoc.controller;

import de.infonautika.vdd.vehicledamagedoc.domain.Vehicle;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/v1", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    private Map<String, Vehicle> vehicles = new HashMap<>();


    @PostMapping(value = "/vehicle")
    @ResponseStatus(OK)
    public void receiveVehicle(@RequestBody Vehicle vehicle) {
        vehicles.put(vehicle.getIdentifizierungsnummer(), vehicle);
    }

    @PutMapping(value = "/vehicle/{fin}")
    public ResponseEntity updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String fin) {
        if (vehicles.computeIfPresent(fin, (k, old) -> vehicle) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/vehicles")
    public Collection<Vehicle> getVehicles() {
        return vehicles.values();
    }

    @DeleteMapping(value = "/vehicle/{fin}")
    public ResponseEntity deleteVehicle(@PathVariable String fin) {
        if (vehicles.remove(fin) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/vehicle/{fin}")
    public ResponseEntity getVehicle(@PathVariable String fin) {
        Vehicle vehicle = vehicles.get(fin);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }

}
