package com.test.city.object_value;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public enum DisposalMethod {
    Recycled, Landfill;

    private static final Set<DisposalMethod> VALUES_AS_SET =
            Arrays.stream(values()).collect(Collectors.toSet());

    public static DisposalMethod findSimilar(String name) {
        if (Objects.isNull(name)) {
            return null;
        }

        DisposalMethod disposalMethod = VALUES_AS_SET.stream()
                .filter(e -> e.name().equalsIgnoreCase(name.toUpperCase())).findAny()
                .orElse(null);

        if (Objects.nonNull(disposalMethod)) {
            return disposalMethod;
        }

        return VALUES_AS_SET.stream()
                .filter(e -> e.name().matches(String.format("\\w*(%s)\\w*", name.toUpperCase()))).findAny()
                .orElse(null);
    }
}
