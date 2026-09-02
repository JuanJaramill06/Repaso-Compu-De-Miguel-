package edu.co.icesi.repository;

import edu.co.icesi.model.Measurement;

import java.util.List;

/**
 * Abstracción del repositorio de mediciones.
 * El servicio depende de esta interfaz y no de una implementación concreta (DIP).
 */
public interface IMeasurementRepository {

    Measurement save(Measurement measurement);

    List<Measurement> findByDeviceId(Integer assetId);

    boolean existsByDeviceId(Integer assetId);

    List<Measurement> findAll();
}
