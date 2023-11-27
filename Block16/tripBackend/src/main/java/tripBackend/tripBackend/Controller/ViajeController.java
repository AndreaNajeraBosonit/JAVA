package tripBackend.tripBackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tripBackend.tripBackend.Domain.Viaje;
import tripBackend.tripBackend.Service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping("/getAll")
    public List<Viaje> getAllViajes() {
        return viajeService.getAllViajes();
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<Viaje> getViajeById(@PathVariable Long tripId) {
        Viaje viaje = viajeService.getViajeById(tripId);
        if (viaje != null) {
            return ResponseEntity.ok(viaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Viaje> createViaje(@RequestBody Viaje viaje) {
        Viaje createdViaje = viajeService.createViaje(viaje);
        return ResponseEntity.ok(createdViaje);
    }

    @PutMapping("/update/{tripId}")
    public ResponseEntity<Viaje> updateViaje(@PathVariable Long tripId, @RequestBody Viaje viaje) {
        Viaje updatedViaje = viajeService.updateViaje(tripId, viaje);
        if (updatedViaje != null) {
            return ResponseEntity.ok(updatedViaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{tripId}")
    public ResponseEntity<Void> deleteViaje(@PathVariable Long tripId) {
        viajeService.deleteViaje(tripId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addPassenger/{tripId}/{passengerId}")
    public ResponseEntity<Viaje> addPassengerToViaje(
            @PathVariable Long tripId,
            @PathVariable Long passengerId) {
        Viaje viaje = viajeService.addPassengerToViaje(tripId, passengerId);
        if (viaje != null) {
            return ResponseEntity.ok(viaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/passenger/count/{tripId}")
    public ResponseEntity<Integer> getPassengerCount(@PathVariable Long tripId) {
        int passengerCount = viajeService.getPassengerCount(tripId);
        return ResponseEntity.ok(passengerCount);
    }


    @PutMapping("/{tripId}/{status}")
    public ResponseEntity<Viaje> updateTripStatus(@PathVariable Long tripId, @PathVariable String status) {
        Viaje updatedViaje = viajeService.updateTripStatus(tripId, status);
        if (updatedViaje != null) {
            return ResponseEntity.ok(updatedViaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/verify/{tripId}")
    public ResponseEntity<String> verifyTripAvailability(@PathVariable Long tripId) {
        String status = viajeService.getStatus(tripId);
        if (status != null) {
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
