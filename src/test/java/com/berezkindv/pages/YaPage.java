package com.berezkindv.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YaPage {

    private static final SelenideElement
            yaSearchFieldInput = $("#text"),
            yaSubmitButton = $("button[type='submit']");

    private static final ElementsCollection yaResultsCollection = $$("li.serp-item");

    public YaPage openPage(String value) {
        open(value);
        return this;
    }

    public YaPage typeYaSearchData(String value) {
        yaSearchFieldInput.setValue(value);
        return this;
    }
    public YaPage pushYaSubmitButton() {
        yaSubmitButton.click();
        return this;
    }

    public void checkYaResult(String value) {
        yaResultsCollection
                .findBy(text(value))
                .shouldHave(text(value));
    }
}
