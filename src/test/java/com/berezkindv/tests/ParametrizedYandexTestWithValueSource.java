package com.berezkindv.tests;

import com.berezkindv.pages.YaPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.berezkindv.tests.TestData.yaSearch;


public class ParametrizedYandexTestWithValueSource {

    YaPage yaPage = new YaPage();

    @ValueSource(strings = {"Selenide", "Allure", "Junit"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {
        yaPage.openPage(yaSearch)
                .typeYaSearchData(testData)
                .pushYaSubmitButton()
                .checkYaResult(testData);
    }

}
