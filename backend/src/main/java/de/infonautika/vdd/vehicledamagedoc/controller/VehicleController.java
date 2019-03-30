package de.infonautika.vdd.vehicledamagedoc.controller;

import de.infonautika.vdd.vehicledamagedoc.domain.Vehicle;
import de.infonautika.vdd.vehicledamagedoc.persistence.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/v1", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    private Map<String, Vehicle> vehicles = new HashMap<>();


    @Autowired
    private VehicleRepository vehicleRepository;


    @PostMapping(value = "/vehicle")
    public ResponseEntity receiveVehicle(@RequestBody Vehicle vehicle) {
        if (vehicleRepository.existsById(vehicle.getIdentifizierungsnummer())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/vehicle/")
    public ResponseEntity updateVehicle(@Valid @RequestBody Vehicle vehicle) {
        if (!vehicleRepository.existsById(vehicle.getIdentifizierungsnummer())) {
            return ResponseEntity.notFound().build();
        }
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/vehicles")
    public Collection<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @DeleteMapping(value = "/vehicle/{fin}")
    @ResponseStatus(OK)
    public void deleteVehicle(@PathVariable String fin) {
        vehicleRepository.deleteById(fin);
    }

    @GetMapping(value = "/vehicle/{fin}")
    public ResponseEntity getVehicle(@Valid @PathVariable String fin) {
        return vehicleRepository.findById(fin)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
