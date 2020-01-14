package com.deepoove.cargo.infrastructure.db.mapper;

import com.deepoove.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarrierMovementMapper {

    CarrierMovementDO select(@Param("scheduleId") String scheduleId);

    List<CarrierMovementDO> selectAll();


}
