package pages.component;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialog {
    public ModalDialog verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ModalDialog verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public void checkIfHidden() {
    }

    public ModalDialog checkIfVisible() {
        return this;
    }

    public void checkTitle(String thanksForSubmittingTheForm) {
    }

    public void checkTableValue(String fieldLabel, String fieldValue) {
    }
}
