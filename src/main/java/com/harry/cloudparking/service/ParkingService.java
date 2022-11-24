package com.harry.cloudparking.service;

import com.harry.cloudparking.exception.ParkingNotFoundException;
import com.harry.cloudparking.model.Parking;
import com.harry.cloudparking.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll(){
        return parkingRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional(readOnly = true)
    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking byId = findById(id);
        byId.setColor(parkingCreate.getColor());
        byId.setState(parkingCreate.getState());
        byId.setModel(parkingCreate.getModel());
        byId.setLicense(parkingCreate.getLicense());
        parkingRepository.save(byId);
        return byId;
    }

    @Transactional
    public Parking checkOut(String id){
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }
}
