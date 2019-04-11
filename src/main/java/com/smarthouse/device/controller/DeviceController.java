package com.smarthouse.device.controller;

import com.smarthouse.commonutil.data_transfer_objects.DeviceDTO;
import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.commonutil.exceptions.ResourceNotFoundException;
import com.smarthouse.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.smarthouse.commonutil.data_transfer_objects.DTOUtil.getDeviceFromDto;
import static com.smarthouse.commonutil.exceptions.ResourceNotFoundException.getNoResourceMessage;

@RestController
public class DeviceController {

    private DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(deviceService.getById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(getNoResourceMessage("device", id))
                ));
    }

    @PostMapping("/device")
    public ResponseEntity<Device> register(@RequestBody DeviceDTO deviceDTO) {
        Objects.requireNonNull(deviceDTO);
        Device device = getDeviceFromDto(deviceDTO);
        return ResponseEntity.ok(deviceService.save(device));
    }

    @GetMapping("/devices")
    public ResponseEntity<Set<Device>> getDeviceById(@RequestBody Set<Long> ids) {
        return ResponseEntity.ok(deviceService.getDevicesByIds(ids));
    }

}
