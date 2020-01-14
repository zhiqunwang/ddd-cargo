package com.deepoove.cargo.domain.aggregate.cargo;

import com.deepoove.cargo.domain.aggregate.cargo.valueobject.EnterpriseSegment;

import java.util.List;

public interface CargoRepository {

    Cargo find(String id);

    int sizeByCustomer(String customerPhone);

    int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment);

    void save(Cargo cargo);

    void remove(String id);

}
