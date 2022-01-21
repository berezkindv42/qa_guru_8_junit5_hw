package com.berezkindv.tests;

import com.berezkindv.pages.TestPages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.berezkindv.tests.TestData.yaSearch;


public class ParametrizedYandexTestWithValueSource {

    TestPages testPages = new TestPages();

    @ValueSource(strings = {"Selenide", "Allure", "Junit"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {
        testPages.openPage(yaSearch)
                .typeYaSearchData(testData)
                .pushYaSubmitButton()
                .checkYaResult(testData);
    }

}
