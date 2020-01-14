package com.deepoove.cargo.domain.aggregate.cargo;

/**
 * @description: CargoBookDomainEvent
 * @date: 2020/1/13 下午8:00
 * @author: wangzhiqun
 * @version: 1.0
 */
public class CargoBookDomainEvent {
    private Cargo cargo;

    public CargoBookDomainEvent(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
