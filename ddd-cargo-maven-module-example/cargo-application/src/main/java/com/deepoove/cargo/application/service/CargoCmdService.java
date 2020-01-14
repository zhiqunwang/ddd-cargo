package com.deepoove.cargo.application.service;

import com.deepoove.cargo.application.cmd.CargoBookCommand;
import com.deepoove.cargo.application.cmd.CargoDeleteCommand;
import com.deepoove.cargo.application.cmd.CargoDeliveryUpdateCommand;
import com.deepoove.cargo.application.cmd.CargoSenderUpdateCommand;

public interface CargoCmdService {

    void bookCargo(CargoBookCommand cargoBookCommand);

    void updateCargoDelivery(CargoDeliveryUpdateCommand cmd);

    void deleteCargo(CargoDeleteCommand cmd);

    void updateCargoSender(CargoSenderUpdateCommand cmd);

}
