package edu.co.icesi.service;

import edu.co.icesi.model.Device;

import edu.co.icesi.repository.IDeviceRepository;
import edu.co.icesi.repository.IMeasurementRepository;
import java.util.List;

public class DeviceService implements IDeviceService {

    private IDeviceRepository deviceRepository;
    private IMeasurementRepository measurementRepository;

    // Setters para inyección de dependencias (contra abstracciones, no implementaciones)
    public void setDeviceRepository(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public void setMeasurementRepository(IMeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public Device registerDevice(Device device) {
        // b: nombre no vacío
        if (device.getNombre() == null || device.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        // c: serialNumber al menos 5 caracteres
        if (device.getSerialNumber() == null || device.getSerialNumber().length() < 5) {
            throw new IllegalArgumentException("El número de serie debe tener al menos 5 caracteres");
        }
        // a: serialNumber único
        if (deviceRepository.findBySerialNumber(device.getSerialNumber()) != null) {
            throw new IllegalArgumentException("Ya existe un dispositivo con ese número de serie");
        }
        // Si no se envía estado, se asigna INACTIVE por defecto
        if (device.getEstate() == null) {
            device.setEstate("INACTIVE");
        }
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDeviceStatus(Integer deviceId, String newState) {
        if (!"ACTIVE".equals(newState) && !"INACTIVE".equals(newState)) {
            throw new IllegalArgumentException("El estado debe ser ACTIVE o INACTIVE");
        }
        Device device = deviceRepository.findById(deviceId);
        if (device == null) {
            throw new IllegalArgumentException("Dispositivo no encontrado");
        }
        device.setEstate(newState);
        return device;
    }

    @Override
    public void deleteDevice(Integer deviceId) {
        if (measurementRepository.existsByDeviceId(deviceId)) {
            throw new IllegalArgumentException("No se puede eliminar un dispositivo con mediciones asociadas");
        }
        boolean removed = deviceRepository.delete(deviceId);
        if (!removed) {
            throw new IllegalArgumentException("Dispositivo no encontrado");
        }
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Integer id) {
        return deviceRepository.findById(id);
    }
}