package tripBackend.tripBackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripBackend.tripBackend.Domain.Viaje;
import tripBackend.tripBackend.Repository.ViajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImpl implements ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<Viaje> getAllViajes() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje getViajeById(Long tripId) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        return optionalViaje.orElse(null);
    }

    @Override
    public Viaje createViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public Viaje updateViaje(Long tripId, Viaje viaje) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        if (optionalViaje.isPresent()) {
            viaje.setTripId(tripId);
            return viajeRepository.save(viaje);
        }
        return null;
    }

    @Override
    public void deleteViaje(Long tripId) {
        viajeRepository.deleteById(tripId);
    }

    @Override
    public Viaje addPassengerToViaje(Long tripId, Long passengerId) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        if (optionalViaje.isPresent()) {
            Viaje viaje = optionalViaje.get();

            // Verificar si hay espacio para un nuevo pasajero
            if (viaje.getPassengerCount() < 40) {
                viaje.setPassengerId(passengerId);
                viaje.setPassengerCount(viaje.getPassengerCount() + 1);
                return viajeRepository.save(viaje);
            } else {
                // No hay espacio para más pasajeros
                return null;
            }
        }
        return null;
    }
    @Override
    public Viaje updateTripStatus(Long tripId, String status) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        if (optionalViaje.isPresent()) {
            Viaje viaje = optionalViaje.get();
            viaje.setStatus(status);
            return viajeRepository.save(viaje);
        }
        return null;
    }



    @Override
    public int getPassengerCount(Long tripId) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        return optionalViaje.map(Viaje::getPassengerCount).orElse(0);
    }
    @Override
    public String getStatus(Long tripId) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(tripId);
        return optionalViaje.map(Viaje::getStatus).orElse(null);
    }
}