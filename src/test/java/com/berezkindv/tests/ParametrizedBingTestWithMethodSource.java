package com.berezkindv.tests;

import com.berezkindv.pages.BingPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.berezkindv.tests.TestData.bingSearch;

public class ParametrizedBingTestWithMethodSource {

    BingPage bingPage = new BingPage();


    static Stream<Arguments> commonSearchTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", "is really nice and capable tool for writing functional", false, List.of("1", "2")),
                Arguments.of("Allure", "Allure Framework is a flexible", true, List.of("3", "4")),
                Arguments.of("Junit", "JUnit 5 is the next generation of", true, List.of("5", "6"))
        );
    }
    @MethodSource("commonSearchTestDataProvider")
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, String expectedResult, Boolean flag, List<String> list) {
        System.out.println("Flag: " + flag);
        System.out.println("List: " + list.toString());
        bingPage.openPage(bingSearch)
                .bingSearchData(testData)
                .pushBingSubmitButton()
                .checkBingResult(expectedResult);
    }
}
