import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedYandexTest {

    @Test
    void selenideSearchTest() {
        open("https://ya.ru");
        $("#text").setValue("Selenide");
        $("button[type='submit']").click();
        $$("li.serp-item")
                .first()
                .shouldHave(text("Selenide"));
    }

    @Test
    void junitSearchTest() {
        open("https://ya.ru");
        $("#text").setValue("Junit");
        $("button[type='submit']").click();
        $$("li.serp-item")
                .first()
                .shouldHave(text("Junit"));
    }

}
