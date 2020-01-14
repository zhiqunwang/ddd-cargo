package com.deepoove.cargo;

import com.google.common.eventbus.EventBus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.deepoove.cargo.infrastructure.db.mapper")
public class CargoApplication {

    @Bean
    public EventBus configEvent() {
        EventBus eventBus = new EventBus();
        return eventBus;
    }

    public static void main(String[] args) {
        SpringApplication.run(CargoApplication.class, args);
    }

}
