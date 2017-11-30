package io.github.sskorol.core;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * WaitCondition encapsulates complicated ExpectedConditions API behind obvious enum values.
 */
@RequiredArgsConstructor
public enum WaitCondition {

    visible(ExpectedConditions::visibilityOfElementLocated),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    present(ExpectedConditions::presenceOfElementLocated),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy),
    valueToBe((BiFunction<By, String, ExpectedCondition<?>>) ExpectedConditions::textToBe);

    private final BiFunction<?, ?, ExpectedCondition<?>> type;

    <T, V> WaitCondition(final Function<T, ExpectedCondition<?>> type) {
        this((T arg1, V arg2) -> type.apply(arg1));
    }

    @SuppressWarnings("unchecked")
    public <T, V, R> BiFunction<T, V, R> getType() {
        return (BiFunction<T, V, R>) type;
    }
}
