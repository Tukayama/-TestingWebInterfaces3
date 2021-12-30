package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class DeditCardApplication {
    @BeforeEach
    @Test
    void personalDataPositiveTest() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void emptyNameField() {
        open("http://localhost:9999");
        $("[type='text']").setValue("");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void wrongPohneNumber() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("788875");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void emptyPohneField() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void latinNameSurname() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Ivanov Ivan");
        $("[type='tel']").setValue("+79678883455");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void emptyForm() {
        open("http://localhost:9999");
        $("[type='text']").setValue("");
        $("[type='tel']").setValue("");
        $(".checkbox__box").click();
        $("button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    } @Test
    void unmarkedСheckbox() {
        open("http://localhost:9999");
        $("[type='text']").setValue("Иванов Иван");
        $("[type='tel']").setValue("+79678883455");
//        $(".checkbox__box").click();
       $("button").click();
        $(".checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй "));
    }
}

