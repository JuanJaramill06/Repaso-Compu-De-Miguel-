package edu.co.icesi.service;

import edu.co.icesi.model.Device;

import java.util.List;

/**
 * Abstracción del servicio de dispositivos.
 * Los servlets dependen de esta interfaz y no de la implementación concreta (DIP).
 */
public interface IDeviceService {

    Device registerDevice(Device device);

    Device updateDeviceStatus(Integer deviceId, String newState);

    void deleteDevice(Integer deviceId);

    List<Device> getAllDevices();

    Device getDeviceById(Integer id);
}
