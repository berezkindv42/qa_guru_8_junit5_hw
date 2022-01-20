package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TestPages;

public class ParametrizedBingTestWithMethodSource {

    TestPages testPages = new TestPages();

    @CsvSource(value = {
            "Selenide, is really nice and capable tool for writing functional",
//            "Allure, Allure Report is a flexible",
//            "Junit, JUnit 5 is the next generation of"
    })
//    @MethodSource
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, String expectedResult) {
        testPages.openPage("https://www.bing.com/")
                .bingSearchData(testData)
                .pushBingSubmitButton()
                .checkBingResult(expectedResult);
    }
}
