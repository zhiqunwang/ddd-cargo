package com.deepoove.cargo.infrastructure.db.mapper;

import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationMapper {

    LocationDO select(@Param("code") String code);

    List<LocationDO> selectAll();


}
