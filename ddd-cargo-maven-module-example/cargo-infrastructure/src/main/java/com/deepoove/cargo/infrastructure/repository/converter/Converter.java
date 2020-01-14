package com.deepoove.cargo.infrastructure.repository.converter;

public interface Converter<T, R> {

    R serialize(T t);

    T deserialize(R r);

}
