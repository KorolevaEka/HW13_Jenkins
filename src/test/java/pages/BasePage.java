package pages;


import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {

        public void removeBanners() {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        }
}
