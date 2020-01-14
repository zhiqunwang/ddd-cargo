package com.deepoove.cargo.infrastructure.repository;

import com.deepoove.cargo.domain.aggregate.location.Location;
import com.deepoove.cargo.domain.aggregate.location.LocationRepository;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import com.deepoove.cargo.infrastructure.db.mapper.LocationMapper;
import com.deepoove.cargo.infrastructure.repository.converter.LocationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRepositoryImpl implements LocationRepository {
    
    @Autowired
    private LocationMapper mapper;

    @Override
    public Location find(String code) {
        LocationDO locationDO = mapper.select(code);
        return LocationConverter.deserialize(locationDO);
    }

}
