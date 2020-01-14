package com.deepoove.cargo.application.service.impl;

import com.deepoove.cargo.application.cmd.HandlingEventAddCommand;
import com.deepoove.cargo.domain.aggregate.handlingevent.EventTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;

import com.deepoove.cargo.application.service.IncidentLoggingCmdService;
import com.deepoove.cargo.domain.aggregate.handlingevent.HandlingEvent;
import com.deepoove.cargo.domain.aggregate.handlingevent.HandlingEventRepository;
import org.springframework.stereotype.Service;

@Service
public class IncidentLoggingCmdServiceImpl implements IncidentLoggingCmdService {

    @Autowired
    private HandlingEventRepository handlingEventRepository;

    @Override
    public void addHandlingEvent(HandlingEventAddCommand cmd) {
        // validate

        // create
        HandlingEvent handlingEvent = HandlingEvent.newHandlingEvent(cmd.getCargoId(),
                cmd.getDatetime(), EventTypeEnum.of(cmd.getEventType()), cmd.getScheduleId());

        // save
        handlingEventRepository.save(handlingEvent);

    }

}
