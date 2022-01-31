package com.berezkindv.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BingPage {

    private static final SelenideElement
            bingFieldInput = $("#sb_form_q"),
            bingSubmitButton = $("label[id='search_icon']");

    private static final ElementsCollection bingResultsCollection = $$("li.b_algo");

    public BingPage openPage(String value) {
        open(value);
        return this;
    }

    public BingPage bingSearchData(String value) {
        bingFieldInput.setValue(value);
        return this;
    }

    public BingPage pushBingSubmitButton() {
        bingSubmitButton.click();
        return this;
    }

    public void checkBingResult(String value) {
        bingResultsCollection
                .findBy(text(value))
                .shouldHave(text(value));
    }

}
