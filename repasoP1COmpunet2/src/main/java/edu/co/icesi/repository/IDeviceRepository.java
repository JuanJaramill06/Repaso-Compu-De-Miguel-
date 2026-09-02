package edu.co.icesi.repository;

import edu.co.icesi.model.Device;

import java.util.List;

/**
 * Abstracción del repositorio de dispositivos.
 * El servicio depende de esta interfaz y no de una implementación concreta (DIP).
 */
public interface IDeviceRepository {

    Device save(Device device);

    /**
     * @return el dispositivo con ese número de serie, o {@code null} si no existe.
     */
    Device findBySerialNumber(String serialNumber);

    /**
     * @return el dispositivo con ese id, o {@code null} si no existe.
     */
    Device findById(Integer id);

    List<Device> findAll();

    boolean delete(Integer id);
}
