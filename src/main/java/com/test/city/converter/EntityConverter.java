package com.test.city.converter;

public interface EntityConverter<E, D, T> {
    E toEntity(D dto); // Convert from DTO to Entity
    T toDto(E entity); // Convert from Entity to DTO
}
