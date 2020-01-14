package com.deepoove.cargo.infrastructure.repository.converter;

import com.deepoove.cargo.domain.aggregate.carriermovement.CarrierMovement;
import com.deepoove.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.springframework.beans.BeanUtils;

public class CarrierMovementConverter {

    public static CarrierMovementDO serialize(CarrierMovement location) {
        CarrierMovementDO target = new CarrierMovementDO();
        BeanUtils.copyProperties(location, target);
        return target;
    }

    public static CarrierMovement deserialize(CarrierMovementDO locationDO) {
        CarrierMovement target = new CarrierMovement();
        BeanUtils.copyProperties(locationDO, target);
        return target;
    }

}
