package com.foodbookingplatform.utils;

import jakarta.persistence.criteria.JoinType;
import lombok.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
public class GenericSpecification{
    public static <T> Specification<T> fieldContains(String fieldName, String keyword) {
        return (root, query, builder) -> builder.like(builder.lower(root.get(fieldName)), "%" + keyword.toLowerCase().trim() + "%");
    }

    public static <T, U extends Comparable<? super U>> Specification<T> fieldBetween(String fieldName, U minValue, U maxValue) {
        return (root, query, builder) -> builder.between(root.get(fieldName), minValue, maxValue);
    }

    public static <T, U extends Comparable<? super U>> Specification<T> fieldGreaterThan(String fieldName, U value) {
        return (root, query, builder) -> builder.greaterThan(root.get(fieldName), value);
    }

    public static <T, U extends Comparable<? super U>> Specification<T> fieldLessThan(String fieldName, U value) {
        return (root, query, builder) -> builder.lessThan(root.get(fieldName), value);
    }

    public static <T> Specification<T> joinFieldContains(String joinField, String fieldName, String keyword) {
        return (root, query, builder) -> builder.like(builder.lower(root.join(joinField).get(fieldName)), "%" + keyword.toLowerCase().trim() + "%");
    }

    public static <T> Specification<T> joinFieldIn(String joinField, String fieldName, Collection<?> values) {
        return (root, query, builder) -> root.join(joinField).get(fieldName).in(values);
    }

    public static <T> Specification<T> fieldIn(String fieldName, Collection<?> values) {
        return (root, query, builder) -> root.get(fieldName).in(values);
    }

    public static <T> Specification<T> fieldIsBoolean(String fieldName, boolean value) {
        return (root, query, builder) -> value ? builder.isTrue(root.get(fieldName)) : builder.isFalse(root.get(fieldName));
    }

    public static <T> Specification<T> joinFieldInThroughMultipleJoins(
            String firstJoinField, String secondJoinField, String fieldName, Collection<?> values) {
        return (root, query, builder) -> root.join(firstJoinField).join(secondJoinField).get(fieldName).in(values);
    }

    public static <T> Specification<T> leftJoinFieldContains(String firstJoinField, String secondJoinField, String fieldName, String keyword) {
        return (root, query, builder) -> {
            var leftJoin = root.join(firstJoinField, JoinType.LEFT).join(secondJoinField, JoinType.LEFT);
            return builder.like(
                    builder.lower(leftJoin.get(fieldName)),
                    "%" + keyword.toLowerCase().trim() + "%"
            );
        };
    }

    public static <T> Specification<T> rightJoinFieldContains(String firstJoinField, String secondJoinField, String fieldName, String keyword) {
        return (root, query, builder) -> {
            var rightJoin = root.join(firstJoinField, JoinType.LEFT).join(secondJoinField, JoinType.LEFT);
            return builder.like(
                    builder.lower(rightJoin.get(fieldName)),
                    "%" + keyword.toLowerCase().trim() + "%"
            );
        };
    }


}
