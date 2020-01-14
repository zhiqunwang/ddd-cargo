package org.deepoove.cargo.query.service;

import org.deepoove.cargo.query.dto.CargoDTO;
import org.deepoove.cargo.query.qry.CargoFindbyCustomerQry;

import java.util.List;

public interface CargoQueryService {

    List<CargoDTO> queryCargos();

    List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry);

    CargoDTO getCargo(String cargoId);

}
