package com.deepoove.cargo.infrastructure.query;

import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.dataobject.HandlingEventDO;
import com.deepoove.cargo.infrastructure.db.mapper.CargoMapper;
import com.deepoove.cargo.infrastructure.db.mapper.HandlingEventMapper;
import com.deepoove.cargo.infrastructure.query.assembler.CargoDTOAssembler;
import com.deepoove.cargo.infrastructure.query.assembler.HandlingEventDTOAssembler;
import org.deepoove.cargo.query.dto.CargoDTO;
import org.deepoove.cargo.query.dto.CargoHandlingEventDTO;
import org.deepoove.cargo.query.dto.HandlingEventDTO;
import org.deepoove.cargo.query.qry.EventFindbyCargoQry;
import org.deepoove.cargo.query.service.TrackQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackQueryServiceImpl implements TrackQueryService {

    @Autowired
    private HandlingEventMapper handlingEventMapper;

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoDTOAssembler converter;
    @Autowired
    private HandlingEventDTOAssembler handlingEventDTOAssembler;

    @Override
    public CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry) {

        CargoDO cargo = cargoMapper.select(qry.getCargoId());
        List<HandlingEventDO> events = handlingEventMapper.selectByCargo(qry.getCargoId());

        // convertor
        CargoDTO cargoDTO = converter.apply(cargo);
        List<HandlingEventDTO> dtoEvents = events.stream().map(handlingEventDTOAssembler::apply)
                .collect(Collectors.toList());

        CargoHandlingEventDTO cargoHandlingEventDTO = new CargoHandlingEventDTO();
        cargoHandlingEventDTO.setCargo(cargoDTO);
        cargoHandlingEventDTO.setEvents(dtoEvents);

        return cargoHandlingEventDTO;
    }

}
