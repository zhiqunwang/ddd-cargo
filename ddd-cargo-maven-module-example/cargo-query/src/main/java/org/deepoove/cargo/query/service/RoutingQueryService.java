package org.deepoove.cargo.query.service;


import org.deepoove.cargo.query.dto.CarrierMovementDTO;

import java.util.List;

public interface RoutingQueryService {

    List<CarrierMovementDTO> queryCarriers();

}
