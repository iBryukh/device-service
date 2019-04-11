package com.smarthouse.device.service;

import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.commonutil.service.CRUDServiceImpl;
import com.smarthouse.device.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeviceService extends CRUDServiceImpl<Device, Long> {

    private DeviceRepository repository;

    @Autowired
    public DeviceService(DeviceRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Set<Device> getDevicesByIds(Set<Long> ids) {
        return ids.stream()
                .map(id -> repository.findOne(id))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

}
