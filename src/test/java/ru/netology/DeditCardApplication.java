package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class DeditCardApplication {
    @Test
    void personalDataPositiveTest() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void emptyNameField() {
        open("http://localhost:9999");
        $("[type='text']").setValue("");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void wrongPohneNumber() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("788875");
        $(".checkbox__box").click();
        $("button").click();
        $(".input_invalid").shouldHave(exactText("Мобильный телефон\nТелефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
    @Test
    public void emptyPohneField() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("");
        $(".checkbox__box").click();
        $("button").click();
        $(".input_invalid").shouldHave(exactText("Мобильный телефон\nПоле обязательно для заполнения"));
    }
    @Test
    public void latinNameSurname() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Ivanov Ivan");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    } @Test
    public void emptyForm() {
        open("http://localhost:9999");
        $("[type='text']").setValue("");
        $("[type='tel']").setValue("");
        $(".checkbox__box").click();
        $("button").click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}

