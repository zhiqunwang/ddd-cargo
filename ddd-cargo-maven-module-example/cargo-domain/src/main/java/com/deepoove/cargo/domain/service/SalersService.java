package com.deepoove.cargo.domain.service;

import com.deepoove.cargo.domain.aggregate.cargo.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.valueobject.EnterpriseSegment;

/**
 * @description: SalersService
 * @date: 2020/1/13 下午8:11
 * @author: wangzhiqun
 * @version: 1.0
 */
public interface SalersService {
    
     String getUserName(String phone);

    boolean mayAccept(int cargoSize, Cargo cargo);

    EnterpriseSegment deriveEnterpriseSegment(Cargo cargo);
}
