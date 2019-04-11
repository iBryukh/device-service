package com.smarthouse.device.service;

import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.commonutil.service.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService extends CRUDServiceImpl<Device, Long> {

    @Autowired
    public DeviceService(JpaRepository<Device, Long> repository) {
        super(repository);
    }

}
