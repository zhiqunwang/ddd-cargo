package com.deepoove.cargo.infrastructure.web.controller;


import com.deepoove.cargo.application.cmd.CargoBookCommand;
import com.deepoove.cargo.application.cmd.CargoDeleteCommand;
import com.deepoove.cargo.application.cmd.CargoDeliveryUpdateCommand;
import com.deepoove.cargo.application.cmd.CargoSenderUpdateCommand;
import com.deepoove.cargo.application.service.CargoCmdService;
import org.deepoove.cargo.query.dto.CargoDTO;
import org.deepoove.cargo.query.qry.CargoFindbyCustomerQry;
import org.deepoove.cargo.query.service.CargoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoQueryService cargoQueryService;
    @Autowired
    CargoCmdService cargoCmdService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CargoDTO> queryCargos(
            @RequestParam(value = "phone", required = false) String phone) {
        if (!StringUtils.isEmpty(phone)) {
            CargoFindbyCustomerQry qry = new CargoFindbyCustomerQry();
            qry.setCustomerPhone(phone);
            return cargoQueryService.queryCargos(qry);
        }
        return cargoQueryService.queryCargos();
    }
    
    @RequestMapping(value = "/{cargoId}", method = RequestMethod.GET)
    public CargoDTO cargo(@PathVariable String cargoId) {
        return cargoQueryService.getCargo(cargoId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void book(@RequestBody CargoBookCommand cargoBookCommand) {
        cargoCmdService.bookCargo(cargoBookCommand);
    }

    @RequestMapping(value = "/{cargoId}/delivery", method = RequestMethod.PUT)
    public void modifydestinationLocationCode(@PathVariable String cargoId,
            @RequestBody CargoDeliveryUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoDelivery(cmd);
    }
    @RequestMapping(value = "/{cargoId}/sender", method = RequestMethod.PUT)
    public void modifySender(@PathVariable String cargoId,
            @RequestBody CargoSenderUpdateCommand cmd) {
        cmd.setCargoId(cargoId);
        cargoCmdService.updateCargoSender(cmd);
    }

    @RequestMapping(value = "/{cargoId}", method = RequestMethod.DELETE)
    public void remoeCargo(@PathVariable String cargoId) {
        CargoDeleteCommand cmd = new CargoDeleteCommand();
        cmd.setCargoId(cargoId);
        cargoCmdService.deleteCargo(cmd);
    }

}
