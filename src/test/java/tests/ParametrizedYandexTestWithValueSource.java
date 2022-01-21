package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TestPages;

import static tests.TestData.yaSearch;

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
