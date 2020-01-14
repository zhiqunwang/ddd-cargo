package com.deepoove.cargo.infrastructure.rpc.salessystem;

import com.deepoove.cargo.domain.aggregate.cargo.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.valueobject.EnterpriseSegment;
import com.deepoove.cargo.domain.service.SalersService;
import org.springframework.stereotype.Service;


@Service
public class SalersServiceImpl implements SalersService {
    
    SalersSystemServiceAdapter adapter;

    @Override
    public String getUserName(String phone) {
        return null;
    }

    @Override
    public boolean mayAccept(int cargoSize, Cargo cargo) {
        return false;
    }

    @Override
    public EnterpriseSegment deriveEnterpriseSegment(Cargo cargo) {
        return null;
    }
}
