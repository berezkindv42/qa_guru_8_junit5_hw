package com.berezkindv.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GooPage {

    private static final SelenideElement
            gooSearchFieldInput = $("input[type='text']"),
            gooSubmitButton = $("input[type='submit']");

    private static final ElementsCollection gooResultsCollection = $$("div.g");

    public GooPage openPage(String value) {
        open(value);
        return this;
    }

    public GooPage gooSearchData(String value) {
        gooSearchFieldInput.setValue(value);
        return this;
    }

    public GooPage pushGooSubmitButton() {
        gooSubmitButton.click();
        return this;
    }

    public void checkGooResult(String value) {
        gooResultsCollection
                .findBy(text(value))
                .shouldHave(text(value));
    }
}
