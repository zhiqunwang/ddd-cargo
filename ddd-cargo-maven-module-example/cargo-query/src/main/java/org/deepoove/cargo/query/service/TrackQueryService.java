package org.deepoove.cargo.query.service;


import org.deepoove.cargo.query.dto.CargoHandlingEventDTO;
import org.deepoove.cargo.query.qry.EventFindbyCargoQry;

public interface TrackQueryService {
    
    CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry);


}
