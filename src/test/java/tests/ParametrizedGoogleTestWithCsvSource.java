package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.TestPages;

import static tests.TestData.gooSearch;

public class ParametrizedGoogleTestWithCsvSource {

    TestPages testPages = new TestPages();

    @CsvSource(value = {
            "Selenide, это фреймворк для автоматизированного тестирования",
            "Allure, Allure Report is a flexible",
            "Junit, JUnit 5 is the next generation of"
    })
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, String expectedResult) {
        testPages.openPage(gooSearch)
                .gooSearchData(testData)
                .pushGooSubmitButton()
                .checkGooResult(expectedResult);
    }
}
