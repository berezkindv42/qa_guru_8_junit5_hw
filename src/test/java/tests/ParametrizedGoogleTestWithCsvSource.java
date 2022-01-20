package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TestPages;

public class ParametrizedGoogleTestWithCsvSource {

    TestPages testPages = new TestPages();

    @ValueSource(strings = {"Selenide", "Allure", "Junit"})
    @ParameterizedTest(name = "Тестирование общего алгоритма поиска с тестовыми данными: {0}")
    void commonSearchTest(String testData) {
        testPages.openPage("https://google.com/")
                .typeSearchData(testData)
                .pushYaSubmitButton()
                .checkResult(testData);
    }
}
