package com.deepoove.cargo.infrastructure.web.controller;


import com.deepoove.cargo.application.cmd.HandlingEventAddCommand;
import com.deepoove.cargo.application.service.IncidentLoggingCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/event")
public class IncidentLogginController {

    @Autowired
    private IncidentLoggingCmdService incidentLoggingCmdService;
    
    @RequestMapping(method = RequestMethod.POST)
    public void addHandlingEvent(@RequestBody HandlingEventAddCommand cmd) {
        cmd.setDatetime(new Date());
        incidentLoggingCmdService.addHandlingEvent(cmd);
    }

}
