package com.test.city.converter;

public abstract class BaseEntityConverter<E, D, T> implements EntityConverter<E, D, T> {
    @Override
    public abstract E toEntity(D dto);

    @Override
    public abstract T toDto(E entity);
}

