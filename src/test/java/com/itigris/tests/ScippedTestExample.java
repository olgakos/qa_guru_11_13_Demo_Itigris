package com.itigris.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScippedTestExample extends TestBase {

    @Test
    @Disabled
    @DisplayName("Пример пропущенного теста")
    public void skippedTest() {
        System.out.println("Тест пропущен");
    }
}
