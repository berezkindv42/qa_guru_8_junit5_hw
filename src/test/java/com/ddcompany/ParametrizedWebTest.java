package com.ddcompany;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParametrizedWebTest {

    @BeforeEach
    void beforEach() {
        System.out.println("@BeforeEach");
    }

    @DisplayName("Тестирование общего алгоритма поиска")
    @ValueSource(strings = {"Selenide", "Junit"}) // запятая разделяет не аргументы, а запуски теста
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit'").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));
    }

    @CsvSource(value =  {
            "Selenide, ",
            "Junit, 5 is the next generation of" // оранжевая запятая разделяет запуски тестов, зеленая аргументы
    })
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void common2SearchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit'").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(expectedResult));
    }

    static Stream<Arguments> commonSearchTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("Junit", true, List.of("3", "4"))
        );
    }

    @MethodSource("commonSearchTestDataProvider")
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void common3SearchTest(String testData, boolean flag, List<String> List) {
        System.out.println("Flag: " + flag);
        System.out.println("List: ");
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit'").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));
    }


    // В результатах поиска яндекс есть Selenide
    // * повторить для тестовых данных: [Selenide, Junit]

    // Открыть яндекс
    // Вбить в поле поиска {test_data}
    // Кликнуть кнопку найти

    // в первом результате есть слово {test_data}
}
