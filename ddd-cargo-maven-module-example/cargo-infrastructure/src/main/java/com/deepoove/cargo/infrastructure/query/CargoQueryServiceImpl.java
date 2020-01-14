package com.deepoove.cargo.infrastructure.query;

import java.util.List;
import java.util.stream.Collectors;

import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.query.assembler.CargoDTOAssembler;
import org.deepoove.cargo.query.dto.CargoDTO;
import org.deepoove.cargo.query.qry.CargoFindbyCustomerQry;
import org.deepoove.cargo.query.service.CargoQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import com.deepoove.cargo.infrastructure.db.mapper.CargoMapper;
import org.springframework.stereotype.Service;

@Service
public class CargoQueryServiceImpl implements CargoQueryService {

    @Autowired
    private CargoMapper cargoMapper;

    @Autowired
    private CargoDTOAssembler converter;

    @Override
    public List<CargoDTO> queryCargos() {
        List<CargoDO> cargos = cargoMapper.selectAll();
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry) {
        List<CargoDO> cargos = cargoMapper.selectByCustomer(qry.getCustomerPhone());
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public CargoDTO getCargo(String cargoId) {
        CargoDO select = cargoMapper.select(cargoId);
        return converter.apply(select);
    }


}
