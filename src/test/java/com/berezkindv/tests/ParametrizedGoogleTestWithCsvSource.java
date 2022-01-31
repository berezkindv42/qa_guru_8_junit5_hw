package com.berezkindv.tests;

import com.berezkindv.pages.GooPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.berezkindv.tests.TestData.gooSearch;


public class ParametrizedGoogleTestWithCsvSource {

    GooPage gooPage = new GooPage();

    @CsvSource(value = {
            "Selenide, это фреймворк для автоматизированного тестирования",
            "Allure, Allure Report is a flexible",
            "Junit, JUnit 5 is the next generation of"
    })
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData, String expectedResult) {
        gooPage.openPage(gooSearch)
                .gooSearchData(testData)
                .pushGooSubmitButton()
                .checkGooResult(expectedResult);
    }
}
