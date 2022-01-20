package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestPages {

    private static final SelenideElement yaSearchField = $("#text"),
            yaSubmitButton = $("button[type='submit']"),
            gooSearchField = $("input[type='text']"),
            gooSubmitButton = $("input[type='submit']");

    private static final ElementsCollection yaResultsCollection = $$("li.serp-item");

    public TestPages openPage(String value) {
        open(value);
        return this;
    }

    public TestPages typeSearchData(String value) {
        yaSearchField.setValue(value);
        return this;
    }
    public TestPages pushYaSubmitButton() {
        yaSubmitButton.click();
        return this;
    }

    public TestPages checkResult(String value) {
        yaResultsCollection.findBy(text(value))
                .shouldHave(text(value));
        return this;
    }

}
