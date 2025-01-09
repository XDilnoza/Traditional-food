package org.example;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
    public ReplyKeyboardMarkup sendMainButtons(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("\uD83C\uDF7D Restoranlar")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("\uD83C\uDF5B Retseptlari")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("✔\uFE0F Kaloriya")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Taomlar haqida qiziqarli faktlar")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn3);
        row2.add(btn4);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboardMarkup sendDishes(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("\uD83C\uDDEE\uD83C\uDDF9 Italyan taomlari")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("\uD83C\uDDEF\uD83C\uDDF5 Yapon taomlari")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("\uD83C\uDDE8\uD83C\uDDF3 Xitoy taomlari")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("\uD83C\uDDEB\uD83C\uDDF7 Fransuz taomlari")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("\uD83C\uDDEE\uD83C\uDDF3 Hind taomlari")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("\uD83C\uDDF9\uD83C\uDDED Tay taomlari")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("\uD83C\uDDF9\uD83C\uDDF7 Turk taomlari")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("\uD83C\uDDFA\uD83C\uDDFF O'zbek taomlari")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Asosiy menuga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn5);
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn9);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboardMarkup sendLocationsItaly(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Shaxrisabz")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Olmazor")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Bobur ko'chasi")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Amir Temur")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Uzbekistan ovozi ko'chasi")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Zulfiya Xonim")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Buyuk Turon ko'chasi")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Navoi Avenue")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Yusuf Xos Xojib")
                .build();

        KeyboardButton btn10 = KeyboardButton.builder()
                .text("O'zbekiston shoh ko'chasi")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btn10);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboardMarkup sendRecipesItaly(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Lasagna")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Risotto")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Pizza")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Tiramisu")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Carbonara")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Cacio e pepe")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Gelato")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Gnocchi")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Arancini")
                .build();

        KeyboardButton btn10 = KeyboardButton.builder()
                .text("Focaccia")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btn10);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboardMarkup locationButtons(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("\uD83C\uDDEE\uD83C\uDDF9 Italyan restaronlari")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("\uD83C\uDDEF\uD83C\uDDF5 Yapon restaronlari")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("\uD83C\uDDE8\uD83C\uDDF3 Xitoy restaronlari")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("\uD83C\uDDEB\uD83C\uDDF7 Fransuz restaronlari")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("\uD83C\uDDEE\uD83C\uDDF3 Hind restaronlari")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("\uD83C\uDDF9\uD83C\uDDED Tay restaronlari")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("\uD83C\uDDF9\uD83C\uDDF7 Turk restaronlari")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("\uD83C\uDDFA\uD83C\uDDFF O'zbek restaronlari")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Asosiy menuga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn5);
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn9);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendLocationsJapan(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Tashkent city \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Niyozbek yo'li \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Abdulla Qahhor \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Bog'ibo'ston \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Shaxrisabz \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Qushbegi \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Шота Руставели \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Massiv \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Yusuf Xos Xojib \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn10 = KeyboardButton.builder()
                .text("Bilol ko'chasi \uD83C\uDDEF\uD83C\uDDF5")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btn10);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendLocationsChina(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Abdulla Kahhar")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Tashkent")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Amir Temur Avenue")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Taras Shevchenko")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Fargona Road")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Yusuf Khos Khodjib")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Chilanzar Street")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Tafakkur")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Little Ring Road")
                .build();

        KeyboardButton btn10 = KeyboardButton.builder()
                .text("Afrosiab")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btn10);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendLocationsFrench(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Tashkent \uD83C\uDDEB\uD83C\uDDF7")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Shakhrisabz")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Pakhtakor")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Muqimiy")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Babur ko'chasi")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Niyozbek Yuli")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Osiyo ko'chasi")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Usta Olim")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Шота Руставели")
                .build();

        KeyboardButton btn10 = KeyboardButton.builder()
                .text("Makhmud Tarabi")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btn10);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboard sendLocationsHind(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Abdulla Kodiriy")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Sebzor")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Oybek")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Оg'abegim")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Kichik xalqa")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboard sendLocationsThai(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Taras Shevchenko")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Tashkent \uD83C\uDDF9\uD83C\uDDED")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Shaxrisabz \uD83C\uDDF9\uD83C\uDDED")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Parkent")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn3);
        row2.add(btn4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboard sendLocationsTurk(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Yahyo Gulyamov")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Ismailata")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Mahmud Tarobiy")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Ecobazar")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Mirzo Ulugbek")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }

    public ReplyKeyboard sendLocationUzbek(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Turkiston")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Muqimiy")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Batir Zakirov")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Kushbegi")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Shota Rustaveli")
                .build();

        KeyboardButton btn11 = KeyboardButton.builder()
                .text("Davlatlar ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);
        row1.add(btn5);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn11);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesJapan(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Sushi")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Ramen")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Tempura")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Soba")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Udon")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Shabu-shabu.")
                .build();

        KeyboardButton btn7 = KeyboardButton.builder()
                .text("Curry rice")
                .build();

        KeyboardButton btn8 = KeyboardButton.builder()
                .text("Karaage")
                .build();

        KeyboardButton btn9 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);
        row1.add(btn4);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn5);
        row2.add(btn6);
        row2.add(btn7);
        row2.add(btn8);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn9);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesChina(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Fried rice")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Soup dumplings")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Wonton soup")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Hot pot")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("CHow mein")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn4);
        row2.add(btn5);
        row2.add(btn6);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesFrench(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Beef bourguignon")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Ratatouille")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("French onion soup")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Bouillabaisse")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Tarte Tatin")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn4);
        row2.add(btn5);
        row2.add(btn6);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesHind(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Butter chicken")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Tandoori chicken")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Biryani")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Dal Makhani")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Rogan Josh")
                .build();

        KeyboardButton btn6 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);
        row1.add(btn3);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn4);
        row2.add(btn5);
        row2.add(btn6);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesThai(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Pad thai")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Tom Yum Goong Spicy shrimp soup")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Phat kaphrao")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Tom kha gai")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn3);
        row2.add(btn4);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn5);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesTurk(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("pide")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Lahmacun")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Doner kebab")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Baklava")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn4);
        row2.add(btn3);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn5);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
    public ReplyKeyboardMarkup sendRecipesUzbek(Long chatId) {
        KeyboardButton btn1 = KeyboardButton.builder()
                .text("Plov")
                .build();

        KeyboardButton btn2 = KeyboardButton.builder()
                .text("Samsa")
                .build();

        KeyboardButton btn3 = KeyboardButton.builder()
                .text("Manti")
                .build();

        KeyboardButton btn4 = KeyboardButton.builder()
                .text("Chuchvara")
                .build();

        KeyboardButton btn5 = KeyboardButton.builder()
                .text("Davlat taomlari ro'yxatiga qaytish")
                .build();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(btn3);
        row2.add(btn4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(btn5);

        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();

        return markup;
    }
//    public ReplyKeyboardMarkup sendButton05(Long chatId, String text) {
//
//        KeyboardButton btn1 = KeyboardButton.builder()
//                .text("Italyan")
//                .build();
//
//        KeyboardRow row1 = new KeyboardRow();
//        row1.add(btn1);
//
//        List<KeyboardRow> rows = new ArrayList<>();
//        rows.add(row1);
//
//        ReplyKeyboardMarkup markup = ReplyKeyboardMarkup.builder()
//                .keyboard(rows)
//                .resizeKeyboard(true)
//                .oneTimeKeyboard(true)
//                .build();
//
//        return markup;
//    }
}
