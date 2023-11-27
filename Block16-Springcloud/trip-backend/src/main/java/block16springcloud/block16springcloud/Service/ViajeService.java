package block16springcloud.block16springcloud.Service;

import java.util.List;

import block16springcloud.block16springcloud.Domain.Viaje;

public interface ViajeService {
    List<Viaje> getAllViajes();

    Viaje getViajeById(Long tripId);

    Viaje createViaje(Viaje viaje);

    Viaje updateViaje(Long tripId, Viaje viaje);

    void deleteViaje(Long tripId);

    Viaje addPassengerToViaje(Long tripId, Long passengerId);

    int getPassengerCount(Long tripId);

    Viaje updateTripStatus(Long tripId, String status);

    String getStatus(Long tripId);
}
