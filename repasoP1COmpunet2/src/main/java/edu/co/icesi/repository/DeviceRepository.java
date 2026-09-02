package edu.co.icesi.repository;

import edu.co.icesi.model.Device;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeviceRepository implements IDeviceRepository {
    private final List<Device> devices = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public Device save(Device device) {
        if (device.getId() == null) {
            device.setId(idGenerator.getAndIncrement());
        }
        // Reemplazar si ya existe
        devices.removeIf(d -> d.getId().equals(device.getId()));
        devices.add(device);
        return device;
    }

    @Override
    public Device findBySerialNumber(String serialNumber) {
        return devices.stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Device findById(Integer id) {
        return devices.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Device> findAll() {
        return new ArrayList<>(devices);
    }

    @Override
    public boolean delete(Integer id) {
        return devices.removeIf(d -> d.getId().equals(id));
    }

    @PostConstruct
    public void init() {
        System.out.println("Inicializando DeviceRepository con datos de ejemplo...");

        Device d1 = new Device();
        d1.setNombre("Sensor Temperatura Norte");
        d1.setSerialNumber("SN001");
        d1.setUbicacion("Planta Norte");
        d1.setTipo("sensor de temperatura");
        d1.setEstate("ACTIVE");
        save(d1);

        Device d2 = new Device();
        d2.setNombre("Sensor Presión Reactor");
        d2.setSerialNumber("SN002");
        d2.setUbicacion("Reactor 2");
        d2.setTipo("sensor de presión");
        d2.setEstate("INACTIVE");
        save(d2);

        System.out.println("Dispositivos inicializados: " + devices.size());
    }
}