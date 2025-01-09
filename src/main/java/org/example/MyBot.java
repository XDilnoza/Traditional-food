package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyBot extends TelegramLongPollingBot {
    Buttons buttons = new Buttons();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            String text = message.getText();
            String[] words = text.split(" ");

//            String response = getAIResponse(text);
//
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.setChatId(chatId);
//            sendMessage.setText(response);
//
//            try {
//                execute(sendMessage);
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }

            switch (text){
                case "/start" -> {
                    String firstName = update.getMessage().getFrom().getFirstName();
                    sendMessage(chatId,"Assalomu alaykum " + firstName + "! Botimizga xush kelibsiz" +
                            "\n" +
                            "\n" +
                            "Nimada boshlaymiz?");
                    break;
                }
                case "✔\uFE0F Kaloriya" ->{
                    sendMessageAI(chatId,"@somethinga23_bot");
                    break;
                }
                case "\uD83C\uDF7D Restoranlar" -> {
                    sendRestaurantsMessage(chatId,"Bugun qaysi millatning taomini tanovul qilishni xohlaysiz?");
                    break;
                }
                case "\uD83C\uDF5B Retseptlari" -> {
                    sendRecipes(chatId,"Bugun qaysi millatning taomini tanovul qilishni xohlaysiz?");
                    break;
                }
                case "\uD83C\uDDEE\uD83C\uDDF9 Italyan restaronlari" ->{
                    sendMessageItalyRestaurants(chatId,"Qaysi joy sizge qulay?");
                    break;
                }
                case "Shaxrisabz" -> {
                    sendLocation(chatId, 41.31192566776267, 69.28562968973682);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Shaxrisabz Italy menu/2022-04-03.jpg",
                    "Syrovarnya\n"+ "Address: Shakhrisabz Street 31Б, 181301, Tashkent\n" +
                                    "Phone: 90 815 31 31");
                    break;
                }
                case "Olmazor" -> {
                    sendLocation(chatId,41.317994667013615, 69.25273891934475);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Olmazor Italy menu/2024-06-01.jpg",
                            "\n" +
                            "CuCucina" +
                            "\n" +
                            "Olmazor koʻchasi, 2А, Tashkent, Uzbekistan\n" +
                            "+998 33 088 03 18\n");
                    break;
                }
                case "Bobur ko'chasi" -> {
                    sendLocation(chatId,41.29464606071605, 69.25035448650937);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Babur Italy menu/2020-01-29.jpg",
                            "\n" +
                            "Affresco\n" +
                            "Babur Street 14, Tashkent, Uzbekistan\n" +
                            "+998 78 129 90 90");
                    break;
                }
                case "Amir Temur" -> {
                    sendLocation(chatId,41.30503345391294, 69.27895827926773);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AmirTemur Italy/2018-10-07.jpg",
                            "Address: Amir Temur Avenue 19, Tashkent\n" +
                            "Basilic Restaurant \n" +
                            "Hours: \n" +
                            "Phone: 71 233 99 05");
                    break;
                }
                case "Uzbekistan ovozi ko'chasi" -> {
                    sendLocation(chatId,41.31128737833067, 69.28765658704278);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Uzb Ovozi Italy/20220825_205816.jpg",
                            "\n" +
                            "Portofino Restaurant\n" +
                            "Located in: Le Grande Plaza Hotel\n" +
                            "Phone: 99 209 90 09");
                    break;
                }
                case "Zulfiya Xonim" -> {
                    sendLocation(chatId,41.32962165694986, 69.26269473069158);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Zulfiya Italy/2024-11-28-2.jpg",
                            "QUADRO\n" +
                            "Address: Zulfiya khonum St 24, Tashkent\n" +
                            "Phone: 78 113 13 38");
                    break;
                }
                case "Buyuk Turon ko'chasi" -> {
                    sendLocation(chatId,41.31149150609331, 69.26843051212845);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/BuyukTuron Italy/IMG_6352.JPG",
                            "\n" +
                            "Bella Notte Italian Restaurant\n" +
                            "Located in: Lotte City Hotel Tashkent Palace\n" +
                            "Phone: 98 125 58 00");
                    break;
                }
                case "Navoi Avenue" -> {
                    sendLocation(chatId,41.31104021345615, 69.27186373979173);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/NavoiItaly/unnamed.jpg",
                            "Sette Restaurant & Bar\n" +
                            "Address: Navoi Avenue 1, 100017, Tashkent\n" +
                            "Phone: 71 207 13 71");
                    break;
                }
                case "Yusuf Xos Xojib" -> {
                    sendLocation(chatId,41.295064377009616, 69.25423925952803);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/2024-05-08.jpg",
                            "\n" +
                            "Pasado\n" +
                            "Address: Yusuf Khos Khodjib Street 72, Tashkent\n" +
                            "Phone: 71 215 50 44");
                    break;
                }
                case "O'zbekiston shoh ko'chasi" -> {
                    sendLocation(chatId,41.30981526055036, 69.27066211010958);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/UzbSHohItaly/IMG20230411201504.jpg",
                            "L`Opera ristorante\n" +
                            "Located in: Central Department Store\n" +
                            "Phone: 95 198 08 88");
                    break;
                }
                case "\uD83C\uDDEF\uD83C\uDDF5 Yapon restaronlari" -> {
                    sendMessageJapanRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Tashkent city \uD83C\uDDEF\uD83C\uDDF5" -> {
                    sendLocation(chatId,41.316818604282176, 69.24559136880367);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/2023-01-13.jpg","Address: Ташкент сити, улица Укчи, дом 5, квартира 9, 100000, Tashkent\n" +
                            "Phone: 90 829 39 99");
                    break;
                }
                case "Niyozbek yo'li \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.32548591919115, 69.28968994513349);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/IMG_3976.JPG","Address: Building 6A, Ниёзбек Йўли 3-тор кўчаси, Тоshkent, Toshkent\n" +
                            "Phone: 95 005 61 32");
                    break;
                }
                case "Abdulla Qahhor \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.2775828760841, 69.26394073765893);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/2022-07-09.jpg","Address: Abdulla Kahhar Street 56А, 100000, Tashkent\n" +
                            "Phone: 98 125 33 66");
                    break;
                }
                case "Bog'ibo'ston \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.26684090720926, 69.22675473811212);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/2024-07-30.jpg","Address: bog’iboston 7, 100000, Tashkent\n" +
                            "Phone: 77 124 44 44");
                    break;
                }
                case "Shaxrisabz \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.31241152177416, 69.29156425088959);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/2023-06-28.jpg","Address: Shakhrisabz Street 33а, Tashkent\n" +
                            "Phone: 90 955 55 45");
                }
                case "Qushbegi \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.275008637154194, 69.24538733881856);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/unnamed.jpg","Address: Kushbegi St 6/1, 100022, Tashkent\n" +
                            "Phone: 71 205 59 59");
                }
                case "Yusuf Xos Xojib \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.298355711685026, 69.2622101543686);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AmirTemur Italy/2023-03-29.jpg","Address: Yusuf Khos Khodjib Street 62, Tashkent\n" +
                            "Phone: 71 255 42 00");
                }
                case "Шота Руставели \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.28648973433126, 69.26186683160228);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AmirTemur Italy/2024-04-08.png","Address: Ташкент Шота Руставели 69 А бывший текстильный круг, напротив кафе \"Фрегат, 100070, Tashkent\n" +
                            "Phone: 71 253 12 13");
                }
                case "Massiv \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.32672212276584, 69.27800300161967);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AmirTemur Italy/2024-10-09.jpg","Address: Массив Киёт,2А, 100000, Tashkent\n" +
                            "Phone: 97 700 44 22");
                }
                case "Bilol ko'chasi \uD83C\uDDEF\uD83C\uDDF5"->{
                    sendLocation(chatId,41.23874970166425, 69.33943277325676);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Babur Italy menu/2022-10-29.jpg","Address: улица Билола Нозима 2, Тоshkent, Toshkent Viloyati\n" +
                            "Phone: 99 051 33 55");
                }
                case "\uD83C\uDDE8\uD83C\uDDF3 Xitoy restaronlari" -> {
                    sendMessageChinaRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Abdulla Kahhar" -> {
                    sendLocation(chatId,41.29964898450471, 69.2923975542699);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China.jpg","Address: Abdulla Kahhar Street 42, Tashkent\n" +
                            "Phone: 99 819 96 66");
                    break;
                }
                case "Tashkent" -> {
                    sendLocation(chatId,41.29062089883125, 69.28141122574742);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2023-03-30.jpg","Address: Tashkent\n" +
                            "Phone: 90 975 98 68");
                    break;
                }
                case "Amir Temur Avenue" -> {
                    sendLocation(chatId,41.29706965895858, 69.29651742746583);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2019-09-06.jpg","Address: 77VP+G3P, Amir Temur Avenue, Tashkent\n" +
                            "Phone: 95 169 59 10");
                    break;
                }
                case "Taras Shevchenko" -> {
                    sendLocation(chatId,41.30274404051394, 69.30544381939035);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2023-05-21.jpg","Address: Taras Shevchenko Street 30, Tashkent\n" +
                            "Phone: 93 850 68 68");
                    break;
                }
                case "Fargona Road" -> {
                    sendLocation(chatId,41.28752526752817, 69.34698587411596);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/IMG_4787.JPG","Address: 78M3+5WC, Fargona Road, Tashkent\n" +
                            "Phone: 93 566 18 88");
                    break;
                }
                case "Yusuf Khos Khodjib" -> {
                    sendLocation(chatId,41.29582183214454, 69.25562778229434);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/IMG_0645.jpg","Address: Yusuf Khos Khodjib Street 62, Tashkent\n" +
                            "Phone: 71 255 42 00");
                    break;
                }
                case "Chilanzar Street" -> {
                    sendLocation(chatId,41.286809989239146, 69.2288165376074);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2023-04-21.jpg","Address: Chilanzar Street 10, 100115, Tashkent");
                    break;
                }
                case "Tafakkur" -> {
                    sendLocation(chatId,41.2948127819326, 69.26046215767289);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2024-12-16.jpg","Address: Tashkent, Tafakkur St, Konstitutsiya MFY38-uy");
                    break;
                }
                case "Little Ring Road" -> {
                    sendLocation(chatId,41.27154528313275, 69.20881728836447);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2023-03-10.jpg","");
                    break;
                }
                case "Afrosiab" -> {
                    sendLocation(chatId,41.307128451748454, 69.27704517170973);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/China/2022-01-11.jpg","Address: Afrosiab Street 6, 100001, Tashkent\n" +
                            "Phone: 90 018 68 88");
                    break;
                }
                case "\uD83C\uDDEB\uD83C\uDDF7 Fransuz restaronlari" -> {
                    sendMessageFrenchRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Tashkent \uD83C\uDDEB\uD83C\uDDF7" -> {
                    sendLocation(chatId,41.29743525348195, 69.28483380830761);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/TashkentFrench.jpeg","Address: 2-й проезд 10, Tashkent\n" +
                            "Phone: 71 237 44 44");
                    break;
                }
                case "Shakhrisabz" -> {
                    sendLocation(chatId,41.32090322489761, 69.29650678236274);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ShaxrisabzFrench.jpeg","Address: Shakhrisabz Street 2, 100000, Tashkent\n" +
                            "Phone: 55 504 44 41");
                    break;
                }
                case "Pakhtakor" -> {
                    sendLocation(chatId,41.316212547501756, 69.25349479207476);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/PaxtakorFrench.jpeg","Address: Pakhtakor Bus Station, Batir Zakirov Street, Tashkent\n" +
                            "Phone: 88 167 18 89");
                    break;
                }
                case "Muqimiy" -> {
                    sendLocation(chatId,41.27969290330779, 69.24977069949527);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/MuqimiyF.jpeg","Address: Muqimiy 1st Dr 8A, Тоshkent, Toshkent\n" +
                            "Phone: 55 511 21 11");
                    break;
                }
                case "Babur ko'chasi" -> {
                    sendLocation(chatId,41.30381323482719, 69.24754287436913);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/BOBurF.jpeg","Address: Узбекистан, 174/1, Babur Street, 100003, Tashkent\n" +
                            "Phone: 78 555 55 53");
                    break;
                }
                case "Niyozbek Yuli" -> {
                    sendLocation(chatId,41.330700536816934, 69.2985667189607);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/NiyozF.jpeg","Address: Niyozbek Yuli Street 29/5, Tashkent\n" +
                            "Phone: 77 703 88 00");
                    break;
                }
                case "Osiyo ko'chasi" -> {
                    sendLocation(chatId,41.3294115009917, 69.30028333279235);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/OsiyoF.jpeg","Address: Osiyo Street 3, Tashkent\n" +
                            "Phone: 93 000 03 03");
                    break;
                }
                case "Usta Olim" -> {
                    sendLocation(chatId,41.339964770978064, 69.25591160135043);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/UstaF.jpeg","Address: Usta Olim tupik 5, 100019, Тоshkent, Toshkent\n" +
                            "Phone: 71 205 00 20");
                    break;
                }
                case "Шота Руставели" -> {
                    sendLocation(chatId,41.271725182755006, 69.24266025531304);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/SHotaF.jpeg","Address: 1-й проезд Шота Руставели 6, 100022, Tashkent\n" +
                            "Phone: 97 814 14 14");
                    break;
                }
                case "Makhmud Tarabi" -> {
                    sendLocation(chatId,41.28414870801187, 69.25775358785975);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/MahmudF.jpeg","Address: Makhmud Tarabi St 29, Tashkent\n" +
                            "Phone: 77 302 90 90");
                    break;
                }
                case "\uD83C\uDDEE\uD83C\uDDF3 Hind restaronlari" -> {
                    sendHindRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Abdulla Kodiriy" -> {
                    sendLocation(chatId,41.32992711838235, 69.28277387170965);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AbdullaH.jpeg","Address: Abdulla Kodiriy 1, Tashkent\n" +
                            "Phone: 78 140 60 00");
                }
                case "Sebzor" -> {
                    sendLocation(chatId,41.32684995138908, 69.24532525902332);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/SebzorH.jpeg","Address: Sebzor St 3, 100011, Tashkent\n" +
                            "Phone: 90 066 33 22");
                }
                case "Oybek" -> {
                    sendLocation(chatId,41.29769318918096, 69.29616345959649);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/AybekH.jpeg","Address: Aybek Street 65, 100015, Tashkent\n" +
                            "Phone: 94 659 15 55");
                }
                case "Оg'abegim" -> {
                    sendLocation(chatId,41.28453716801168, 69.2834605172423);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/OgabegimH.jpeg","Address: Огабегим, 36, 100060, Tashkent\n" +
                            "Phone: 90 327 59 99");
                }
                case "Kichik xalqa" -> {
                    sendLocation(chatId,41.26760050512267, 69.25159000320555);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/KichikH.jpeg","Address: Kichik Halka, Durmon Yuli St 10, Tashkent\n" +
                            "Phone: 99 775 55 59");
                }
                case "\uD83C\uDDF9\uD83C\uDDED Tay restaronlari" -> {
                    sendThaiRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Taras Shevchenko \uD83C\uDDF9\uD83C\uDDED" -> {
                    sendLocation(chatId,41.303109603229835, 69.28964032703625);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/TarasThai.jpeg","Address: Taras Shevchenko Street 21А, Tashkent\n" +
                            "Phone: 94 787 77 77");
                }
                case "Tashkent \uD83C\uDDF9\uD83C\uDDED" -> {
                    sendLocation(chatId,41.30758258524693, 69.23686782512614);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/TashkentThai.jpeg","Address: Tashkent\n" +
                            "Phone: 94 689 36 11");
                }
                case "Shaxrisabz \uD83C\uDDF9\uD83C\uDDED" -> {
                    sendLocation(chatId,41.30878345926797, 69.29410352299851);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ShaxrizabsThai.jpeg","Address: Шахрисабзский проезд, 6, Tashkent");
                }
                case "Parkent" -> {
                    sendLocation(chatId,41.32657553240032, 69.31435956621183);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ParkentThai.jpeg","Address: Parkent Street 43a, 100077, Tashkent");
                }
                case "\uD83C\uDDF9\uD83C\uDDF7 Turk restaronlari" -> {
                    sendTurkRestaurants(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Yahyo Gulyamov"->{
                    sendLocation(chatId,41.316004016526215, 69.29685010512907);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/YahyoTurk.jpeg","Address: Yahyo Gulyamov Street 38A, Tashkent\n" +
                            "Phone: 71 233 00 38");
                    break;
                }
                case "Ismailata"->{
                    sendLocation(chatId,41.34075414092056, 69.33015241346284);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/IsmailataTurk.jpeg","Address: Исмаилата 23, р-н, улица, Tashkent\n" +
                            "Phone: 99 882 10 00");
                    break;
                }
                case "Mahmud Tarobiy"->{
                    sendLocation(chatId,41.28439796682578, 69.25821873575225);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/MahmudTurk.jpeg","Address: Mahmud Tarobiy Street No:27, 100100, Tashkent\n" +
                            "Phone: 95 621 21 21");
                    break;
                }
                case "Ecobazar"->{
                    sendLocation(chatId,41.35802209430946, 69.36027446561089);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/EcoTurk.jpeg","\n" +
                            "Phone: 94 983 99 99");
                    break;
                }
                case "Mirzo Ulugbek"->{
                    sendLocation(chatId,41.32477076084413, 69.32731548004344);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/MirzoTurk.jpeg","Address: Mirzo Ulugbek Avenue 35, Tashkent\n" +
                            "Phone: 90 091 03 00");
                    break;
                }
                case "\uD83C\uDDFA\uD83C\uDDFF O'zbek restaronlari" -> {
                    sendUzbekRestauratns(chatId,"Qaysi joy sizga qulay?");
                    break;
                }
                case "Turkiston"->{
                    sendLocation(chatId,41.29251964084957, 69.28712131196542);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/TurkistonUzb.jpeg","Address: Turkiston Street 12a, Tashkent\n" +
                            "Phone: 90 026 36 36");
                }
                case "Muqimiy \uD83C\uDDFA\uD83C\uDDFF"->{
                    sendLocation(chatId,41.28504951685415, 69.26073450384034);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/MuqimiyUzb.jpeg","Address: Muqimiy 1st Dr 8A, Тоshkent, Toshkent\n" +
                            "Phone: 55 511 21 11");
                }
                case "Batir Zakirov"->{
                    sendLocation(chatId,41.320383914522225, 69.26554102256895);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/BatirUzb.jpeg","Address: Batir Zakirov Street 7, Tashkent\n" +
                            "Phone: 77 109 88 77");
                }
                case "Kushbegi"->{
                    sendLocation(chatId,41.280921623359205, 69.26176447213933);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/KushUzb.jpeg","Address: Kushbegi St 6, 100022, Tashkent\n" +
                            "Phone: 95 198 08 01");
                }
                case "Shota Rustaveli"->{
                    sendLocation(chatId,41.29846336736659, 69.26931757299852);
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ShotaUzb.jpeg","Address: Shota Rustaveli Street 13а, Tashkent\n" +
                            "Phone: 78 148 10 01");
                }

                //-----------------------------------------------------------------------------------------------------------------------------
                //ITALY RECIPES//
                case "\uD83C\uDDEE\uD83C\uDDF9 Italyan taomlari" ->{
                    sendItaly(chatId,"Taomlardan birini tanlang");
                    break;
                }case "Lasagna" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ItalyFood/lasagna.jpeg","Go‘sht: Ushbu juda go‘shtli lasanya shirin italyan kolbasasi va yog‘li bo‘lmagan mol go‘shti bilan tayyorlanadi.\n" +
                            "\n" +
                            "Piyoz va sarimsoq: Bir piyoz va ikkita sarimsoq tilimi go‘sht bilan pishiriladi, bu ta'mni yanada boyitadi.\n" +
                            "\n" +
                            "Pomidor mahsulotlari: Sizga bir banka ezilgan pomidor, ikkita banka pomidor sousi va ikkita banka pomidor pastasi kerak bo‘ladi.\n" +
                            "\n" +
                            "Shakar: Oq shakarni ikki osh qoshiq qo‘shish, sousning ta'mini yanada oshiradi va shirinlik beradi.\n" +
                            "\n" +
                            "Ziravorlar va ta'mlar: Ushbu lasanya retsepti yangi maydanoz, quritilgan reyhan, tuz, italyan ziravorlari, fenhel urug‘i va qora murch bilan ta'mlanadi.\n" +
                            "\n" +
                            "Lasanya makaronlari: Do‘kondan sotib olingan yoki uyda tayyorlangan lasanya makaronlaridan foydalaning.\n" +
                            "\n" +
                            "Pishloqlar: Parmesan, mozzarella va rikotta pishloqlari bu lasanyani juda mazali qiladi.\n" +
                            "\n" +
                            "Tuxum: Rikottani birlashtirish uchun tuxum ishlatiladi, shunda lasanyani kesganingizda rikotta chiqib ketmaydi.\n" +
                            "\n" +
                            "Lasanya tayyorlash bo‘yicha qadam-baqadam ko‘rsatmalar\n");
                    break;
                }
                case "Risotto" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Risotto.jpg","Risotto tayyorlash\n" +
                            "\n" +
                            "INGREDIENTLAR\n" +
                            "\n" +
                            "Tovuq buloni: Sizga yoqadigan past natriyli tovuq bulonidan foydalaning—uyda tayyorlangan bulon yanada yaxshi bo‘ladi!\n" +
                            "\n" +
                            "Yorma: Ushbu retseptda arborio yoki carnaroli yormasidan foydalanishingiz mumkin: Ikki turdagi guruch ham qisqa donli bo‘lib, mukammal qaymoq hosil qilish uchun kerakli kraxmal miqdorini ta'minlaydi. Ko‘pchilik carnaroli turini afzal ko‘radi, chunki uning donalari to‘liq pishganida ham alohida va aniq qoladi. Arborio esa tezroq pishadi va ko‘proq axlatga aylanadi, shuning uchun uni ishlatayotgan bo‘lsangiz, 10 daqiqa pishirib ko‘ring va donalarning tayyorligini tekshirib ko‘ring.\n" +
                            "\n" +
                            "Oq vino: Bu yerda ichadigan oq vinoingizni ishlating—Chardonnay yoki Pinot Grigio ajoyib tanlov bo‘ladi.\n" +
                            "\n");
                    break;
                }
                case "Pizza" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/ItalyFood/pizza.jpeg","Xamir uchun:\n" +
                            "\n" +
                            "1 1/2 stakan (355 ml) iliq suv (105°F-115°F)\n" +
                            "1 paket (2 1/4 choy qoshiq) quruq xamirturush\n" +
                            "3 3/4 stakan (490 g) bug'doy uni\n" +
                            "2 osh qoshiq zaytun moyi (agar pizza yog'och olovli pechda pishirilsa, qo'shilmaydi)\n" +
                            "2 choy qoshiq kosher tuzi\n" +
                            "1 choy qoshiq shakar\n" +
                            "Pizza tayyorlash va garnit uchun:\n" +
                            "\n");
                    break;
                }
                case "Tiramisu" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Tiramisu.jpeg","Kerakli mahsulotlar:\n" +
                            "\n" +
                            "Dame blanka: Men ularni sotib olaman, lekin siz ularni o'zingiz tayyorlashingiz mumkin.\n" +
                            "Maskarpone: agar mutlaqo kerak bo'lmasa, krem \u200B\u200Bpishloq bilan almashtirishingiz mumkin, ammo haqiqiy tiramisu maskarpone bo'lmasdan bo'lmaydi.\n" +
                            "Qahva: Men espresso ishlataman\n" +
                            "Qaymoq\n" +
                            "Granulasiya qilingan shakar\n" +
                            "Vanil ekstrakti: yoki sun'iy vanil bilan almashtiring\n" +
                            "Kakao kukuni: ustiga sepish uchun\n" +
                            "Tiramisu tayyorlash:\n" +
                            "\n");
                    break;
                }
                case "Carbonara" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Carbonara_6a.jpg.webp","Guanciale: Bu qurutilgan mol go'shti karbonara uchun muhim bo'lib, bekon va pancettaga o'xshash. Siz uni pancetta yoki qalin kesilgan bekon bilan almashtirishingiz mumkin.\n" +
                            "Parmigiano-Reggiano: Yuqori sifatli Parmesan pishloqi, yangi qirg'ichdan o'tkazilgan (oldindan maydalangan emas). Pecorino Romano yoki ularning kombinatsiyasidan ham foydalanish mumkin.\n" +
                            "Tuxum: Boylik uchun butun tuxum va sariqlarning kombinatsiyasi.\n" +
                            "Makaron pishirish suvi: Qaymoqli sous yaratish uchun kraxmalli suv juda muhimdir.\n" +
                            "Spageti: Karbonara uchun eng keng tarqalgan makaron shakli.\n" +
                            "Qora murch: Ta'mga ko'ra yangi maydalangan qora murch.\n" +
                            "Muhim eslatmalar:\n" +
                            "\n");
                    break;
                }
                case "Cacio e pepe" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Cacio-e-Pepe-Recipe-5-1.jpg","Cacio e Pepe uchun mahsulotlar:\n" +
                            "\n" +
                            "Makaron: Qalin spageti, bukatini yoki tonnarelli" +
                            "Pekorino Romano: Ushbu qari pishloq Rim pastalarida har doim an'anaviy ravishda ishlatiladi " +
                            "Sariyog': Ha! Men bilaman, bu kacio e pepe-da tortishuvli va, albatta, an'anaviy bo'lmagan ingredient" +
                            "Qora qalampir");
                    break;
                }
                case "Gelato" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/gelato.jpeg","Tarkibi:\n" +
                            "\n" +
                            "2 stakan sut\n" +
                            "1 stakan qaymoq\n" +
                            "4 dona tuxum sarig'i\n" +
                            "½ stakan shakar\n" +
                            "Tayyorlash usuli:\n" +
                            "\n" +
                            "Kerakli mahsulotlarni tayyorlang.\n" +
                            "Sut va qaymoqni o'rtacha olovda qizdiring. Qirralari atrofida ko'pik hosil bo'lguncha qizdiring. Olovdan oling.\n" +
                            "Katta idishda tuxum sarig'i va shakarni ko'pik hosil bo'lguncha urting. Issiq sutni asta-sekin tuxum sarig'i va shakarga quyib, doimiy ravishda aralashtiring. Aralashmani yana kastryulga qaytaring; o'rta olovda aralashma biroz qotib, qoshiqning orqa tomonini qoplamaguncha aralashtirib pishiring. Agar kichik tuxum bo'lakchalari paydo bo'la boshlasa, darhol olovdan oling.\n" +
                            "Aralashmani elak yoki ingichka filtrdan idishga o'tkazing. Yoping va bir necha soat yoki bir kechaga sovuting.\n" +
                            "Aralashmani muzqaymoq tayyorlagichga quying va ishlab chiqaruvchi ko'rsatmalariga muvofiq muzlattiring. Hermetik idishga o'tkazing va qotib qolguncha muzlatgichga qo'ying. Agar muzqaymoq juda qattiq bo'lsa, kerakli qalinlikka erishguncha muzlatgichga qo'ying.");
                    break;
                }
                case "Gnocchi" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/gnocchi.webp","Uyda gnocchi tayyorlash uchun kerakli uchta ingredient:\n" +
                            "\n" +
                            "Kartoshka: Russet kabi kraxmalli kartoshka ishlating.\n" +
                            "Un: Umumiy maqsadli un namlikni yutadi va gluten hosil bo'lishiga yordam beradi.\n" +
                            "Tuxum: Tuxum namlik beradi va bog'lovchi vazifasini bajaradi, ya'ni dumplinglarni bir-biriga yopishtirib turishga yordam beradi.\n" +
                            "Tuz: Kosher tuzi umumiy ta'mni yaxshilaydi.\n" +
                            "Uy qurilishi gnocchi tayyorlash\n" +
                            "\n" +
                            "Gnocchi tayyorlash jarayonida nimalarni kutish mumkinligi haqida juda qisqacha ma'lumot:\n" +
                            "\n" +
                            "Kartoshkani qaynatib, suvini to'kib tashlang, so'ngra maydalang yoki qaynatgichdan o'tkazing.\n" +
                            "Ingredientlarni aralashtiring, so'ngra xamirga yopishtiring.\n" +
                            "Xamirni to'rt teng qismga bo'ling va \"ilon\" shakliga keltiring.\n" +
                            "Ilonlarni bo'laklarga kesing.\n" +
                            "Gnocchi-ni qaynatib, suvini to'kib tashlang.");
                    break;
                }
                case "Arancini" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Arancini.jpeg","Tarkibi:\n" +
                            "\n" +
                            "Risotto uchun: Arborio guruchi, piyoz, sarimsoq, tuz, qora murch, pomidor pastasi, petrushka, sariyog', tovuq buloni, parmesan pishloq.\n" +
                            "Ichlik uchun: Mozarella pishloq.\n" +
                            "Qoplama uchun: Umumiy maqsadli un, tuxum, panko non bo'lagi.\n" +
                            "Yog' uchun: Zaitun moyi, uzum yoki sabzavot yog'i.\n" +
                            "Arancini tayyorlash:\n" +
                            "\n" +
                            "Arancini tayyorlash juda oddiy, garchi barcha bosqichlardan o'tish uchun biroz sabr-toqat talab etilsa-da. Sizga va'da beraman, bu arancini retsepti bunga loyiq!\n" +
                            "\n");
                    break;
                }
                case "Focaccia" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Focaccia.jpeg","Tarkibi:\n" +
                            "\n" +
                            "1 (¼ oz.) paket quruq xamirturush (taxminan 2¼ choy qoshiq)\n" +
                            "2 choy qoshiq asal\n" +
                            "5 stakan (625 g) umumiy maqsadli un\n" +
                            "5 choy qoshiq Diamond Crystal yoki 1 osh qoshiq Morton kosher tuzi\n" +
                            "6 osh qoshiq ekstra virgin zaytun moyi, bo'lib tashlangan, qo'llar uchun qo'shimcha\n" +
                            "4 osh qoshiq tuzsiz sariyog', pan uchun qo'shimcha\n" +
                            "Qirg'ichli dengiz tuzi\n" +
                            "2-4 dona sarimsoq chinnigullari\n" +
                            "Tayyorlash usuli:\n");
                    break;
                }
                //JAPAN RECIPES//
                case "\uD83C\uDDEF\uD83C\uDDF5 Yapon taomlari" -> {
                    sendJapan(chatId,"Taomlardan birini tanlang");
                    break;
                }
                case "Sushi" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/sushi.jpeg","Tarkibi:\n" +
                            "\n" +
                            "1 ⅓ stakan suv\n" +
                            "⅔ stakan pishirilmagan qisqa donli oq guruch\n" +
                            "3 osh qoshiq guruch sirka\n" +
                            "3 osh qoshiq oq shakar\n" +
                            "1 ½ choy qoshiq tuz\n" +
                            "4 varaq nori dengiz o'ti varaqlari\n" +
                            "½ funt imitatsiya qisqichbaqasi go'shti, parchalangan\n" +
                            "1 dona avokado - po'sti tozalangan, urug'i olingan va bo'laklarga bo'lingan\n" +
                            "½ dona bodring - po'sti tozalangan, mayda chiziqlarga kesilgan\n" +
                            "2 osh qoshiq tuzlangan zanjabil");
                    break;
                }
                case "Ramen" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/ramen11.jpeg","Tarkibi:\n" +
                            "\n" +
                            "1 osh qoshiq kunjut yog'i\n" +
                            "3 choy qoshiq maydalangan zanjabil\n" +
                            "4 choy qoshiq maydalangan sarimsoq\n" +
                            "4 stakan sho'rva (men tovuq go'shtidan foydalandim, lekin sabzavot ham ishlaydi)\n" +
                            "4 stakan suv\n" +
                            "1 untsiya quritilgan shiitake qo'ziqorini\n" +
                            "2 paket tez pishadigan ramen (faqat makaron!)\n" +
                            "1/2 stakan tug'ralgan piyoz yoki chives\n" +
                            "2 stakan tug'ralgan karam (yoki ismaloq)\n" +
                            "1 stakan maydalangan sabzi (yoki boshqa sabzavot, masalan, bok choy)\n" +
                            "Ta'mga ko'ra Sriracha\n" +
                            "Tepasiga mo'rt oltin panko non bo'lagi");
                    break;
                }
                case "Tempura" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/Tempura.jpeg","Here's the translation of the ingredients list in Uzbek:\n" +
                            "\n" +
                            "Tarkibi:\n" +
                            "\n" +
                            "Qisqichbaqa\n" +
                            "Baliq\n" +
                            "Tovuq go'shti\n" +
                            "Tuxum\n" +
                            "Sabzavotlar - lotos urug'i, kabocha, piyoz, qovoq, baqlajon, qo'ziqorin\n" +
                            "Shiso barglari");
                    break;
                }
                case "Soba" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/Soba.jpeg","Soba makaronini qanday pishirish kerak\n" +
                            "\n" +
                            "Agar siz ilgari soba pishirmagan bo'lsangiz, ushbu retseptni boshlashdan oldin bilishingiz kerak bo'lgan bir nechta narsalar mavjud. Soba paketini katta yopishqoq xamirga aylantirish oson, ammo agar siz ushbu maslahatlarga amal qilsangiz, albatta soba muvaffaqiyatiga erishasiz!\n" +
                            "\n" +
                            "Birinchidan, oddiy makaronlardan farqli o'laroq, sobani tuzsiz suvda pishirish juda muhimdir.\n" +
                            "\n" +
                            "Ularni qaynatmaslikka ishonch hosil qiling! Paketda ko'rsatilgan vaqt uchun oshxona taymerini o'rnatishni unutmang.\n" +
                            "\n" +
                            "Makaroningiz tayyor bo'lganda, ularni lavaboda to'kib tashlang va yopishqoqlikka sabab bo'lgan kraxmallarni olib tashlash uchun sovuq suv bilan yaxshilab yuving.\n" +
                            "\n" +
                            "Va nihoyat, ularni iste'mol qilishga tayyorgarlik ko'rmaguningizcha yangi saqlash uchun bir qoshiq yog' bilan aralashtiring!");
                    break;
                }
                case "Udon" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/udon.jpeg","Udon makaronining asosiy tarkibiy qismlari bug'doy uni, suv va tuz hisoblanadi. Udon makaronlari odatda chewy va guruch makaronlari kabi boshqa turlarga qaraganda qalinroq bo'lib, tekis yoki yumaloq bo'lishi mumkin.");
                    break;
                }
                case "Shabu-shabu." -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/shabu shabu.jpeg","Shabu-shabu - yapon qaynoq idish taomi bo'lib, uning asosiy tarkibiy qismlari sho'rvada pishirish uchun ingichka bo'laklarga bo'lingan go'sht va sabzavotlar hamda so'ruv uchun sosdir.\n" +
                            "\n" +
                            "Shabu-shabu tayyorlash bo'yicha ba'zi maslahatlar:\n" +
                            "\n" +
                            "\"Shabu-shabu\" nomi sho'rvada ingredientlarni aralashtirish uchun ishlatiladigan chayqalish harakatidan kelib chiqqan.\n" +
                            "Bazani yaratish uchun sarimsoq va piyoz kabi yuqori ta'mga ega bo'lgan ingredientlardan boshlang, so'ngra qo'ziqorin va mol go'shti kabi boyroq ingredientlarni qo'shing.\n" +
                            "Ingredientlarni navbat bilan qo'shing, suvni sekin qaynab turishiga erishing.\n" +
                            "Sevimli so'ruv soslaringiz bilan dasturxon tuzing.");
                    break;
                }
                case "Curry rice" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/Curry rice.jpeg","Curry rice odatda guruch, karri va piyoz, sarimsoq va ziravorlar kabi boshqa ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Ziravorlar: Karri uchun keng tarqalgan ziravorlarga zira, koriandr, zanjabil, chili qalampiri, chinnigullar, muskat yong'og'i, yulin, xantal va qora murch kiradi. Zanjabil karriga o'ziga xos sariq rangini beradi, qalampir yoki paprika esa unga qizil rang beradi.\n" +
                            "\n" +
                            "Sabzavotlar: Karri uchun keng tarqalgan sabzavotlarga piyoz, sabzi, kartoshka, pomidor va no'xat kiradi.\n" +
                            "\n" +
                            "Boshqa ingredientlar: Sarimsoq va zanjabil karri rice-da asosiy ta'm beruvchi komponentlardir.");
                    break;
                }
                case "Karaage" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Japan/Kaargae.jpeg","Karaage - yapon qovurilgan tovuq taomi bo'lib, odatda quyidagi ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Suyaksiz, terisiz tovuq go'shti: Ushbu tovuq go'shti sharbati saqlaydi.\n" +
                            "Kartoshka kraxmal: Engil va qortib turadigan qoplama hosil qiladi.\n" +
                            "Soy sousi: Chuqur, mazali ta'm va umami qo'shadi.\n" +
                            "Mirin: Umami va shirin ta'mlarni qo'shadigan shirin guruch sharobi.\n" +
                            "Zanjabil: Yangi zanjabil eng yaxshi ishlaydi.\n" +
                            "Sarimsoq: Sarimsoqni Microplane bilan maydalash sarimsoq ta'mini maksimal darajada oshiradi.\n" +
                            "Hon tsuyu: Soy sousi, niboshi yog'i va chiqarilgan bonito'dan tayyorlangan umami boy sho'rva bazasi.\n" +
                            "Sake: Guruchdan tayyorlangan alkogolli ichimlik bo'lib, tovuq go'shtidagi umamini kuchaytiradi.\n" +
                            "O'simlik yog'i: Karaage qovurish uchun kanola yoki yerfıstığı yog'i kabi neytral ta'mga va yuqori tutun nuqtasiga ega yuqori sifatli yog' eng yaxshisidir.");
                    break;
                }
                //CHINA RECIPES//
                case "\uD83C\uDDE8\uD83C\uDDF3 Xitoy taomlari" ->{
                    sendChina(chatId,"Taomlardan birini tanlang");
                    break;
                }
                case "Fried rice"->{
                    sendPhoto(chatId,"","Tarkibi:\n" +
                            "\n" +
                            "3/4 stakan mayda to'g'ralgan piyoz\n" +
                            "2 1/2 osh qoshiq yog'\n" +
                            "1 dona engil urug'langan tuxum (yoki ko'proq tuxum, agar xohlasangiz)\n" +
                            "3 tomchi soya sousi\n" +
                            "3 tomchi kunjut yog'i\n" +
                            "8 untsiya pishirilgan yog'siz go'sht yoki 8 untsiya tovuq go'shti, maydalangan\n" +
                            "1/2 stakan mayda to'g'ralgan sabzi (juda kichik)\n" +
                            "1/2 stakan muzlatilgan no'xat, erigan");
                    break;
                }
                case "Soup dumplings" ->{
                    sendPhoto(chatId,"","Soup dumplinglar odatda quyidagi ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Xamir: Umumiy maqsadli un, suv va tuzdan xamir tayyorlanadi. Xamir juda silliq va yumshoq bo'lguncha yoğrilishi kerak.\n" +
                            "\n" +
                            "Ichlik: Soup dumplinglar odatda ta'mga keltirilgan cho'chqa go'shti bilan to'ldiriladi. Ichlikka karam, piyoz, sarimsoq va zanjabil kabi boshqa ingredientlar ham qo'shilishi mumkin.\n" +
                            "\n" +
                            "Aspik yoki jelatin: Bu bulonni qaynatib, sovutib, qattiqlashishiga yo'l qo'yish orqali tayyorlanadi.");
                    break;
                }
                case "Wonton soup" ->{
                    sendPhoto(chatId,"","Wonton sho'rvasi uchun odatda quyidagi ingredientlar mavjud:\n" +
                            "\n" +
                            "Vontonlar\n" +
                            "Bulon\n" +
                            "Qo'ziqorinlar\n" +
                            "Vontonlar kvadrat shaklidagi xamir o'ramasini tekis yoyib, o'rtasiga ozgina ichlik qo'yib, so'ngra qirralarini bir-biriga bosish orqali muhrlanadi.\n" +
                            "\n" +
                            "Siz wonton sho'rvasini idishdan wontonlarni olish uchun taxta tayoqchalar va bulonni iste'mol qilish uchun sopol qoshiq bilan iste'mol qilishingiz mumkin.");
                    break;
                }
                case "Hot pot" ->{
                    sendPhoto(chatId,"","Qaynoq idish uchun odatda quyidagi ingredientlar mavjud:\n" +
                            "\n" +
                            "Oqsil: Ingichka bo'laklarga bo'lingan go'sht, dengiz mahsulotlari yoki loviya mahsulotlari\n" +
                            "Sabzavotlar: Bok choy, suv terisi, yoki Napa karam kabi bargli ko'katlar, shuningdek, qo'ziqorinlar, ildiz sabzavotlari va bo'laklarga bo'lingan kartoshka\n" +
                            "Kraxmalli ingredientlar: Vermikelli, tuxumli dumplinglar, tofu yoki qaynoq idish to'plari\n" +
                            "Soslar: Soya sousi, kunjut yog'i, qora sirka, chili yog'i yoki kunjut pastasi\n" +
                            "Xushbo'y hidli o'tlar: Yashil piyoz, sarimsoq yoki koriandr");
                    break;
                }
                case "CHow mein" ->{
                    sendPhoto(chatId,"","Makaron:\n" +
                            "\n" +
                            "Qovurilgan makaron\n" +
                            "Qaynatilgan lo mein makaroni\n" +
                            "Chow mein makaroni\n" +
                            "Yaki-soba makaroni\n" +
                            "Sos:\n" +
                            "\n" +
                            "Soya sousi\n" +
                            "Ustritsa sousi\n" +
                            "Asal\n" +
                            "Kunjut yog'i\n" +
                            "Makkajo'xori uni\n" +
                            "Xitoy oshxona sharobi\n" +
                            "Tovuq buloni\n" +
                            "Sabzavotlar:\n" +
                            "\n" +
                            "Sabzi\n" +
                            "Karam\n" +
                            "Koleraba\n" +
                            "Yashil piyoz\n" +
                            "Qizil qalampir (qalampir)\n" +
                            "Oqsil:\n" +
                            "\n" +
                            "Tovuq go'shti\n" +
                            "Mol go'shti\n" +
                            "Boshqa:\n" +
                            "\n" +
                            "Mung loviya unib chiqqanidan keyingi holiga o'xshash oziq-ovqat");
                    break;
                }
                //FRENCH RECIPES//
                case "\uD83C\uDDEB\uD83C\uDDF7 Fransuz taomlari" -> {
                    sendFrench(chatId,"\uD83C\uDDEB\uD83C\uDDF7 Fransuz taomlari");
                }
                case "Beef bourguignon" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/French/Beef-Bourguignon.jpeg","Mol go'shti: Chuck - beef bourguignon uchun klassik kesma hisoblanadi, chunki u arzon va uzoq vaqt davomida pishirish jarayonida parchalanib, yumshoq bo'lish uchun etarli miqdorda biriktiruvchi to'qimaga ega.\n" +
                            "Qizil sharob: Pinot noir, kaberne yoki merlot - barchasi yaxshi tanlovdir. Shuningdek, Côtes du Rhône yoki Beaujolais-dan foydalanishingiz mumkin.\n" +
                            "Un: Bir necha qoshiq un sosni smetana kabi qalinlikka qadar qalinlashtiradi.\n" +
                            "Bekon: Bekon sosni ta'mga keltirish uchun juda muhimdir.\n" +
                            "Boshqa ingredientlar:\n" +
                            "\n" +
                            "Yangi sarimsoq\n" +
                            "Pomidor pastasi\n" +
                            "Kam natriyli bulon\n" +
                            "Yangi o'tlar\n" +
                            "Sabzi\n" +
                            "Qo'ziqorinlar\n" +
                            "Bu klassik fransuz taomi uchun ajoyib ingredientlar ro'yxati!");
                    break;
                }
                case "Ratatouille" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/French/ratatouille-casserole.jpg","Ratatouille uchun asosiy ingredientlar to'g'ri.\n" +
                            "\n" +
                            "Baqlajon: Binafsha rang va kremsiy ohanglarni qo'shadi.\n" +
                            "Pomidor: Yangi pomidorlar yangi, jonli ta'm uchun eng yaxshisidir. Siz ularni maydalashingiz yoki oziq-ovqat protsessorida maydalashingiz mumkin.\n" +
                            "Piyoz va sarimsoq: Antioksidant va yallig'lanishga qarshi xususiyatlarga ega bo'lgan mazali bazani yaratadi.\n" +
                            "O'tlar: Reyhan va petrushka sabzavotlarning tabiiy ta'mini chiqaradi. Shuningdek, dafna bargi, kekik yoki herbes de Provence kabi yashil o'tlar aralashmasidan foydalanishingiz mumkin.\n" +
                            "Boshqa sabzavotlar:\n" +
                            "\n" +
                            "Kabak, sariq yozgi kabak va shirin qalampir keng tarqalgan qo'shimchalardir. Sosga maydalangan sabzi ham qo'shishingiz mumkin.\n" +
                            "Bu klassik frantsuz taomi uchun ajoyib ingredientlar ro'yxati!");
                    break;
                }
                case "French onion soup" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/French/French-Onion-Soup.jpeg","Mol go'shti buloni: Go'sht, sabzavot va o'tlarni qaynatish yo'li bilan tayyorlanadi.\n" +
                            "Karamellashgan piyoz: Haqiqiy frantsuz piyoz sho'rvasi ta'mi uchun asosiy ingredient.\n" +
                            "Pishloq: Gruyère klassik tanlovdir, ammo shveytsariya, parmesan, fontina yoki mozzarella ham mazali bo'lishi mumkin.\n" +
                            "Non: An'anaviy ravishda qobiqli fransuz noni, ammo glutensiz variantlar mavjud.\n" +
                            "Ko'pincha qo'shilgan boshqa ingredientlar:\n" +
                            "\n" +
                            "Un: Bulonni qalinlashtirish uchun.\n" +
                            "Oq sharob: Tavani tozalash va ta'mga murakkablik qo'shish uchun.\n" +
                            "O'tlar: Rosemary, kekik yoki petrushka kabi yangi o'tlar.\n" +
                            "Sabzavot buloni: Bulon ta'mini oshirish uchun ishlatilishi mumkin, ammo kam natriyli variantlarni tanlang.");
                    break;
                }
                case "Bouillabaisse" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/French/Bouillabaisse.jpeg", "Baliq: Chayon baliq, qizil mullet yoki st. pierre kabi oq go'shtli baliq an'anaviy hisoblanadi, ammo cod, monkfish yoki dengiz bassasi ham ishlashi mumkin.\n" +
                            "Qisqichbaqa: Qobig'i bilan birga yangi qisqichbaqa sho'rvaga ajoyib ta'm qo'shadi.\n" +
                            "Middiya: \"Haqiqiy\" retseptning bir qismi bo'lmasa-da, tirik middiya ko'pincha kiritiladi va mazali sho'r ta'm qo'shadi.\n" +
                            "Zaytun moyi: Yuqori sifatli ekstra virgin zaytun moyi sho'rvaning asosi uchun juda muhimdir.\n" +
                            "Zafran: Ozgina sof zafran iplari sho'rvaga chiroyli oltin rang va noyob, nozik ta'm beradi.\n" +
                            "Sarimsoq: Yangi sarimsoq sho'rvaga o'tkir va xushbo'y chuqurlik qo'shadi.\n" +
                            "Yangi kekik: Dengiz mahsulotlarini to'ldiradigan nozik o'simlik murakkabligini qo'shadi.\n" +
                            "Piyoz: Asosiy ingredient bo'lib, piyoz sho'rvaga shirinlik va chuqurlikni beradi.\n" +
                            "Pomidor: Yangi, pishgan pomidorlar sho'rvaga ozgina kislotali va shirinlik qo'shadi.\n" +
                            "Ushbu ingredientlar kombinatsiyasi chinakam mazali va qoniqarli dengiz mahsulotlari sho'rvasini yaratadi.");
                    break;
                }
                case "Tarte Tatin" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/French/tarte.jpeg","Tarte tatin uchun asosiy ingredientlar olma, sariyog', shakar va xamir:\n" +
                            "\n" +
                            "Olma: Granny Smith olma yaxshi tanlovdir, chunki ular karamellashtirish jarayoniga yaxshi bardosh beradi va ularning nordonligi boy karamelni to'ldiradi.\n" +
                            "\n" +
                            "Sariyog': Tuzsiz sariyog' karamel uchun ishlatiladi.\n" +
                            "\n" +
                            "Shakar: Donador shakar karamel uchun ishlatiladi.\n" +
                            "\n" +
                            "Xamir: Siz do'konda sotib olingan yoki uy qurilishi puf xamiri yoki pirog qobig'i xamirini ishlatishingiz mumkin.");
                    break;
                }
                //HIND RECIPES//
                case "\uD83C\uDDEE\uD83C\uDDF3 Hind taomlari" ->{
                    sendIndia(chatId,"Taomlardan birini tanlang");
                    break;
                }
                case "Butter chicken" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/India/butterchicken.jpeg","Tarkibi:\n" +
                            "\n" +
                            "1 stakan sariyog', bo'lib tashlangan\n" +
                            "1 dona maydalangan piyoz\n" +
                            "1 osh qoshiq maydalangan sarimsoq\n" +
                            "1 (15 untsiya) konserva pomidor sousi\n" +
                            "3 stakan qaymoq\n" +
                            "2 choy qoshiq tuz\n" +
                            "1 choy qoshiq qizil qalampir\n" +
                            "1 choy qoshiq garam masala\n" +
                            "1 ½ funt terisiz, suyaksiz tovuq ko'krak go'shti, mayda bo'laklarga bo'lingan\n" +
                            "2 osh qoshiq o'simlik yog'i\n" +
                            "2 osh qoshiq tandoori masala");
                    break;
                }
                case "Tandoori chicken" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/India/tandoori.jpeg","Tandoori tovuq - tovuq, qatiq va turli xil ziravorlar bilan tayyorlanadi va an'anaviy ravishda tandoor - loy pechda pishiriladi. Tandoori tovuq uchun asosiy ingredientlar quyidagilardir:\n" +
                            "\n" +
                            "Tovuq: Tandoori tovuq uchun eng ko'p ishlatiladigan oqsil, garchi siz paneer ham ishlatishingiz mumkin.\n" +
                            "Qatiq: Marinadning asosi bo'lib, qatiq qaymoqlilikni qo'shadi va tovuqni yumshatadi.\n" +
                            "Tandoori masala: Odatda zira, koriandr, dolchin, kardamon va chinnigullarni o'z ichiga olgan ziravorlar aralashmasi.\n" +
                            "Qizil chili kukuni: Tovuqqa o'ziga xos chuqur qizil rangini beradi.\n" +
                            "Zanjabil va sarimsoq pastasi: Ta'm qo'shadi va go'shtni yumshatadi.\n" +
                            "Ohak sharbati: Chili issiqligini bartaraf etishga yordam beradi.");
                    break;
                }
                case "Biryani" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/India/biryani.jpeg","Biryani odatda quyidagi ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Guruch:\n" +
                            "\n" +
                            "Uzoq donli basmati guruchi idealdir, ammo jasmin guruchi o'rnini bosuvchi sifatida ishlatilishi mumkin.\n" +
                            "Qari basmati guruchi yumshoqroq, Sella basmati guruchi esa mustahkamroq va qaynatishga bardoshli.\n" +
                            "Yumshoq donalarni oldini olish uchun guruchni yuving va ho'llang.\n" +
                            "Ziravorlar:\n" +
                            "\n" +
                            "Biryani ziravorlar aralashmasi odatda zira, koriandr, zanjabil, zanjabil va dolchinni o'z ichiga oladi.\n" +
                            "Boshqa keng tarqalgan ziravorlarga dafna barglari, kardamon podalari va garam masala kiradi.\n" +
                            "O'tlar:\n" +
                            "\n" +
                            "Yangi koriandr va yalpiz barglari yorqinlik va yangilikni qo'shadi.\n" +
                            "Piyoz:\n" +
                            "\n" +
                            "Shirinlik va chuqurlikni qo'shing.\n" +
                            "Qovurilgan piyoz qortib turadigan garnit sifatida ishlatilishi mumkin.\n" +
                            "Qatiq:\n" +
                            "\n" +
                            "Tovuqni marinatlash uchun qatiq ishlatiladi, bu uni yumshatadi va ta'mlarni yaxshilaydi.\n" +
                            "Agar siz qatiq yemaydigan bo'lsangiz, uni kokos suti bilan almashtirishingiz mumkin.\n" +
                            "Zafran:\n" +
                            "\n" +
                            "Rang va hashamatli xushbo'y hidni qo'shadi.\n" +
                            "Ghee:\n" +
                            "\n" +
                            "Uy qurilishi ghee biryani-ga o'ziga xos ta'm va xushbo'y hidni beradi.\n" +
                            "Boshqa ingredientlar:\n" +
                            "\n" +
                            "Konserva kubik shaklida kesilgan pomidorlar, o'simlik yog'i va iliq sut ham qo'shilishi mumkin.");
                    break;
                }
                case "Dal Makhani" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/India/dalmakhani.jpeg","Qora no'xot (Urad Dal): Shouning yulduzi! Ular kremsi, boy tuzilishga qadar pishiriladi.\n" +
                            "Qizil loviya: Qalin matoni va ozgina shirinlikni qo'shing.\n" +
                            "Sariyog' va qaymoq: Ushbu hashamatli, baxmalsimon boylik uchun zarur.\n" +
                            "Piyoz: Ta'm uchun asos, ko'pincha chuqurlik uchun karamellashtiriladi.\n" +
                            "Ziravorlar:\n" +
                            "Zanjabil: Issiqlik va ozgina o'tkirlik uchun.\n" +
                            "Garam Masala: Murakkablikni qo'shadigan ziravorlar aralashmasi.\n" +
                            "Zira: Yerga o'xshash va iliq.\n" +
                            "Qizil Chili kukuni: Issiqlik qo'shadi (sizning xohishingizga ko'ra sozlang).\n" +
                            "Tuz va qalampir: Ta'mga ko'ra ziravor qilish uchun.\n" +
                            "Pomidor: Silliq, mazali sos uchun pomidor pyuresi va passata ajoyib tanlovdir.");
                    break;
                }
                case "Rogan Josh" ->{
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/India/rogan.jpeg","Rogan Josh - bu xushbo'y ziravorlar va boshqa ingredientlar bilan qovurilgan qo'y go'shti yoki qo'y go'shti bilan tayyorlanadigan klassik Kashmir karrisi. Umumiy ingredientlar quyidagilarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Ziravorlar: Chinnigullar, dafna barglari, kardamon, dolchin, yulin urug'i, Kashmir chili kukuni, zira urug'i, muskat yong'og'i, zanjabil va qora murch\n" +
                            "\n" +
                            "Boshqa ingredientlar: Sarimsoq, zanjabil, piyoz, qatiq, pomidor pastasi, suyak iligi, qizil chili pastasi va ghee\n" +
                            "\n" +
                            "Qo'shimcha ingredientlar: Garam masala, pran (yovvoyi piyoz pastasi) va kokos suti");
                    break;
                }

                //THAI RECIPES//
                case "\uD83C\uDDF9\uD83C\uDDED Tay taomlari" ->{
                    sendThai(chatId,"Taomlardan birini tanlang");
                    break;
                }

                case "Pad thai" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Thai/Pad thai.jpeg","Asosiy tarkibiy qismlar:\n" +
                            "\n" +
                            "Makaron: Guruch makaroni\n" +
                            "Oqsil: Tovuq, qisqichbaqa, tofu\n" +
                            "Sos bazasi: Baliq sousi, tamarind pastasi\n" +
                            "Ta'm berish: Sarimsoq, shalot\n" +
                            "Toppings: Mung loviya unib chiqqanidan keyingi holiga o'xshash oziq-ovqat, yashil piyoz, maydalangan yerfıstığı, ohak bo'laklari\n" +
                            "Qo'shimcha qo'shimchalar: Qizil chili qalampiri, yangi chili qalampiri");
                    break;
                }
                case "Tom Yum Goong Spicy shrimp soup" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Thai/Tom Yum Goong Spicy shrimp soup.jpeg","Tom yum goong, achchiq va xushbo'y xushbo'y tay sho'rvasi, odatda quyidagi ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Limon o'ti: Xushbo'y ingredient\n" +
                            "Qisqichbaqa: Tanlangan oqsil, lekin siz boshqa dengiz mahsulotlaridan ham foydalanishingiz mumkin\n" +
                            "Makrut ohak barglari: Sho'rvaning o'simlik ta'mi uchun asosiy ingredient\n" +
                            "Galangal: Sho'rvaning o'simlik ta'mi uchun asosiy ingredient\n" +
                            "Tay chili: Juda achchiq bo'lgan kichik, ingichka chili\n" +
                            "Baliq sousi: Sho'rvaning ta'mi uchun asosiy ingredient\n" +
                            "Ohak sharbati: Nordon ta'm qo'shadi\n" +
                            "Qo'ziqorinlar: Tom yum sho'rvasida keng tarqalgan ingredient\n" +
                            "Koriandr: Yangi koriandr ko'pincha sho'rva bilan birga beriladi");
                    break;
                }
                case "Phat kaphrao" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Thai/Phat kaphrao.jpeg","Phat kaphrao, an'anaviy tay stir-frysi uchun ingredientlar quyidagilarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Go'sht: Maydalangan go'sht yoki dengiz mahsulotlari, masalan, tovuq, cho'chqa go'shti, mol go'shti yoki boshqa oqsillar\n" +
                            "Tay muqaddas reyhani: Phat kaphrao-da asosiy ingredient\n" +
                            "Sarimsoq: Phat kaphrao-da keng tarqalgan ingredient\n" +
                            "Shalot: Phat kaphrao-da keng tarqalgan ingredient\n" +
                            "Chili qalampiri: Phat kaphrao-da keng tarqalgan ingredient\n" +
                            "Soya sousi: Phat kaphrao-da asosiy ziravor\n" +
                            "Tay baliq sousi: Phat kaphrao-da asosiy ziravor\n" +
                            "Ustritsa sousi: Phat kaphrao-da ixtiyoriy ziravor\n" +
                            "Qand: Phat kaphrao-da asosiy ziravor\n" +
                            "Qush ko'zi chili: Phat kaphrao-da asosiy ziravor");
                    break;
                }
                case "Tom kha gai" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Thai/Tom kha gai.jpeg","Tom kha gai, tay kokosli tovuq sho'rvasi, odatda quyidagi ingredientlarni o'z ichiga oladi:\n" +
                            "\n" +
                            "Kokos suti: Sho'rvaning kremsi bazasi\n" +
                            "Tovuq: Suyaksiz, terisiz tovuq ko'krak go'shti yoki qanotlari\n" +
                            "Galangal: Tom kha gai-da asosiy ingredient\n" +
                            "Limon o'ti: Tom kha gai-da asosiy ingredient\n" +
                            "Ohak barglari: Tom kha gai-da asosiy ingredient\n" +
                            "Baliq sousi: Tom kha gai-da keng tarqalgan ingredient\n" +
                            "Ohak sharbati: Sho'rvaning ta'mini muvozanatlashtiradigan asosiy ingredient\n" +
                            "Qo'ziqorinlar: Shiitake, tugma, somon yoki ostriga kabi turli xil turlari bilan almashtirilishi mumkin bo'lgan ko'p qirrali ingredient");
                    break;
                }
                //TURK RECIPES//
                case "\uD83C\uDDF9\uD83C\uDDF7 Turk taomlari" -> {
                    sendTurk(chatId,"Taomlardan birini tanlang");
                    break;
                }
                case "pide" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Turk/pide.jpeg","Xamir uchun\n" +
                            "Un - 500 g\n" +
                            "Tuz - 1 choy qoshiq\n" +
                            "Suv - 200 ml\n" +
                            "Zaytun yog‘i yoki oddiy yog‘ - 2 osh qoshiq\n" +
                            "Xamirturush - 1 choy qoshiq (quruq)\n" +
                            "Ichlik uchun (pidaning ichidagi mahsulotlar)\n" +
                            "Go‘sht (mol yoki qo‘y) - 300 g, mayda maydalangan\n" +
                            "Piyoz - 1 dona, mayda to‘g‘ralgan\n" +
                            "Pomidor - 1 dona, kub shaklida to‘g‘ralgan\n" +
                            "Ko‘katlar (kashnich, ukrop yoki maydanoz) - ta’bga qarab, maydalangan\n" +
                            "Tuz va ziravorlar - ta’bga qarab (zira, qora murch, qizil murch)\n" +
                            "Sariyog‘ yoki yog‘ - 1 osh qoshiq (ichlikni yumshoq qilish uchun)\n" +
                            "Pishirish uchun\n" +
                            "Tuxum sarig‘i - 1 dona (xamir yuziga surtish uchun)");
                    break;
                }
                case "Lahmacun" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Turk/lahmacun.jpeg","Xamir uchun\n" +
                            "Un - 500 g\n" +
                            "Suv - 250 ml\n" +
                            "Zaytun yog‘i yoki oddiy yog‘ - 2 osh qoshiq\n" +
                            "Tuz - 1 choy qoshiq\n" +
                            "Shakar - 1 choy qoshiq\n" +
                            "Xamirturush - 1 choy qoshiq (quruq yoki yangi)\n" +
                            "Ichlik uchun (lahmacunning ustiga surtiladigan aralashma)\n" +
                            "Mol go‘shti yoki qo‘y go‘shti - 250-300 g, maydalangan\n" +
                            "Piyoz - 1 dona, maydalangan\n" +
                            "Pomidor - 2 dona, maydalab to‘g‘ralgan yoki blenderdan chiqarilgan\n" +
                            "Bolg‘or qalampiri - 1 dona, mayda to‘g‘ralgan yoki blenderdan o‘tkazilgan\n" +
                            "Sarimsoq - 2 dona, maydalangan\n" +
                            "Ko‘katlar (kashnich yoki maydanoz) - 1 bog‘, maydalangan\n" +
                            "Ziravorlar - ta’bga qarab: tuz, qora murch, qizil murch, paprika, zira\n" +
                            "Zaytun yog‘i yoki oddiy yog‘ - 2-3 osh qoshiq\n" +
                            "Tayyorlash uchun\n" +
                            "Xamirni tayyorlab, 30-40 daqiqa dam oldiring.\n" +
                            "Ichlikni tayyorlash uchun barcha mahsulotlarni birlashtirib, yaxshilab aralashtiring.\n" +
                            "Xamirni yupqa qilib yoyib, ustiga ichlikni surting.\n" +
                            "Pechda 220°C da 10-15 daqiqa davomida pishiring.");
                    break;
                }
                case "Doner kebab" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Turk/doner.jpeg","Un - 500 g\n" +
                            "Suv - 250 ml\n" +
                            "Tuz - 1 choy qoshiq\n" +
                            "Xamirturush - 1 choy qoshiq\n" +
                            "Sabzavotlar va qo‘shimchalar:\n" +
                            "\n" +
                            "Pomidor - dilimlangan\n" +
                            "Bolg‘or qalampiri - somon shaklida to‘g‘ralgan\n" +
                            "Salat barglari - bir nechta bo‘lak\n" +
                            "Piyoz - mayda to‘g‘ralgan (yoki sirka bilan marinadlangan)\n" +
                            "Bodring - bo‘laklarga kesilgan yoki tuzlangan bodr");
                    break;
                }
                case "Baklava" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/Turk/Baklava.jpeg","Xamir uchun (agar o'zingiz qilmoqchi bo‘lsangiz):\n" +
                            "Un - 500 g\n" +
                            "Tuxum - 2 dona\n" +
                            "Sut yoki suv - 150 ml\n" +
                            "Sariyog‘ - 2 osh qoshiq\n" +
                            "Tuz - 1 chimdim\n" +
                            "Sirka yoki limon sharbati - 1 choy qoshiq\n" +
                            "(Yoki tayyor filo xamiridan foydalanish mumkin.)\n" +
                            "\n" +
                            "Ichlik uchun:\n" +
                            "Yong‘oq (pista, bodom yoki oddiy yong‘oq) - 300-400 g\n" +
                            "Shakar - 100 g\n" +
                            "Dolchin - 1 choy qoshiq (ixtiyoriy)\n" +
                            "Surtish uchun:\n" +
                            "Sariyog‘ - 250 g\n" +
                            "Sirop uchun:\n" +
                            "Shakar - 500 g\n" +
                            "Suv - 250 ml\n" +
                            "Limon sharbati - 1 osh qoshiq\n" +
                            "Asal - 1-2 osh qoshiq (ixtiyoriy)");
                    break;
                }

                case "\uD83C\uDDFA\uD83C\uDDFF O'zbek taomlari" -> {
                    sendUzbek(chatId,"Taomlardan birini tanlang");
                    break;
                }
                case "Plov" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/osh.jpeg","Go'sht (mol go'shti yoki qo'y go'shti) – 500 g\n" +
                            "Yong'oq – 1-1.5 stakan (yong'oq sifatida mol go'shti qo'shilgan)\n" +
                            "Piyoz – 2-3 dona (katta va mayda to'g'ralgan)\n" +
                            "Sabzi – 2-3 dona (katta to'g'ralgan yoki uzun shaklda kesilgan)\n" +
                            "Guruch – 2 stakan (yaxshi yuvilgan)\n" +
                            "Sarimsak – 1 bosh (butun holda, yuqori qismidan kesib, qalqib turadi)\n" +
                            "O'simlik yog'i yoki sariyog' – 100-150 ml\n" +
                            "Zira – 1-2 choy qoshiq (plovga mazali ta'm beradi)\n" +
                            "Qora murch – ta'bga qarab\n" +
                            "Tuz – ta'bga qarab\n" +
                            "Suv – 4-5 stakan (go'sht va guruchni pishirish uchun)");
                    break;
                }
                case "Samsa" -> {
                    sendPhoto(chatId,"samsa.jpeg","Xamir uchun:\n" +
                            "Un – 500 g\n" +
                            "Suv – 200 ml\n" +
                            "Tuz – 1 choy qoshiq\n" +
                            "O'simlik yog'i – 2-3 osh qoshiq (xamirni yumshoq qilish uchun)\n" +
                            "Yog' (cho'zilgan xamir uchun) – 100 g (ixtiyoriy)\n" +
                            "Tuxum – 1 dona (yuvish uchun, ixtiyoriy)\n" );
                    break;
                }
                case "Manti" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/manti.jpeg","Xamir uchun:\n" +
                            "Un – 500 g\n" +
                            "Suv – 200 ml\n" +
                            "Tuxum – 1 dona (ixtiyoriy)\n" +
                            "Tuz – 1 choy qoshiq\n" +
                            "Nachinka (ichiga solinadigan):\n" +
                            "Go'sht – 500 g (mol, qo'y yoki qo'shma go'sht, mayda to'g'ralgan yoki maydalangan)\n" +
                            "Piyoz – 3-4 dona (mayda to'g'ralgan)\n" +
                            "Qo'y yog'i – 100 g (mayda to'g'ralgan, ixtiyoriy)\n" +
                            "Tuz – ta'bga qarab\n" +
                            "Qora murch – ta'bga qarab\n" +
                            "Zira – ta'bga qarab (ixtiyoriy)\n" +
                            "Qovoq yoki kartoshka (ixtiyoriy, mayda kub shaklida kesilgan)\n");
                    break;
                }
                case "Chuchvara" -> {
                    sendPhoto(chatId,"/Users/macbok/IdeaProjects/TraditionalFood_bot/src/main/resources/chuchvara.jpeg","Xamir uchun:\n" +
                            "Un - 500 g\n" +
                            "Tuxum - 1 dona\n" +
                            "Suv - 150-200 ml\n" +
                            "Tuz - 1 choy qoshiq\n" +
                            "\n" +
                            "Nachinka (ichiga solinadigan) uchun:\n" +
                            "Go'sht (mol yoki qo'y go'shti, maydalangan) - 300-400 g\n" +
                            "Piyoz - 2-3 dona (mayda to'g'ralgan)\n" +
                            "Tuz - ta'bga qarab\n" +
                            "Qora murch - ta'bga qarab\n" +
                            "Zira - ta'bga qarab (ixtiyoriy)\n" +
                            "\n");
                    break;
                }
                case "Taomlar haqida qiziqarli faktlar" -> {
                    sendMessageAI(chatId,"@FunFactsAboutFood_bot.");
                    break;
                }
            }
            if (text.equals("Davlatlar ro'yxatiga qaytish")){
                sendMessageBackToCountries(chatId,"Davlatlar ro'yxati");
            } else if (text.equals("Asosiy menuga qaytish")){
                sendBackToMain(chatId,"Asosiy menu");
            }else if (text.equals("Davlat taomlari ro'yxatiga qaytish")){
                sendBackToRecipes(chatId,"Davlat taomlari");
            }
        }
    }

    private void sendBackToRecipes(Long chatId, String davlatTaomlari) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(davlatTaomlari);
        message.setReplyMarkup(buttons.sendDishes(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageAI(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

//    private String getAIResponse(String userInput) {
//
////        String text = "You are the Gemini 1.5 Flash API version. Your task is to respond only with the current weather information for Uzbekistan's regions in degrees Celsius. List the weather for each region of Uzbekistan in a simple format. Avoid including unrelated information, additional explanations, or weather data outside Uzbekistan's regions. " + LocalDate.now()  + userInput;
//        String text = "You are a calory counter.When user gives you product you will calculate how many calories are there in product.Everything should be in Uzbek language"  + userInput;
//        try {
//            HttpClient client = HttpClient.newHttpClient();
//            String jsonBody = "{\n" +
//                    "  \"contents\": [\n" +
//                    "    { \"parts\": [{ \"text\": \"" + text + "\" }] }\n" +
//                    "  ]\n" +
//                    "}";
//
//
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + "AIzaSyDk0jRLSM94axl7krb_51vk7180uXP3Sv0"))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
//                    .build();
//
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//
//            if (response.statusCode() == 200) {
//                JsonElement json = JsonParser.parseString(response.body());
//                JsonArray array = json.getAsJsonObject().getAsJsonArray("candidates");
//                if (array != null && array.size() > 0) {
//                    JsonObject candidate = array.get(0).getAsJsonObject();
//                    JsonObject content = candidate.getAsJsonObject("content");
//                    JsonArray parts = content.getAsJsonArray("parts");
//                    if (parts != null && parts.size() > 0) {
//                        JsonObject part = parts.get(0).getAsJsonObject();
//                        return part.get("text").getAsString();
//                    }
//                }
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "I think there's some problem. Because of that, I can't generate response. Please contact with [Your contact info]";
//    }

    private void sendUzbek(Long chatId, String taomlardanBiriniTanlang) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(taomlardanBiriniTanlang);
        message.setReplyMarkup(buttons.sendRecipesUzbek(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendTurk(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendRecipesTurk(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendThai(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendRecipesThai(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendIndia(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendRecipesHind(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendFrench(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendRecipesFrench(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendChina(Long chatId, String taomlardanBiriniTanlang) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(taomlardanBiriniTanlang);
        sendMessage.setReplyMarkup(buttons.sendRecipesChina(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendJapan(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendRecipesJapan(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendItaly(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendRecipesItaly(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendUzbekRestauratns(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendLocationUzbek(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendTurkRestaurants(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendLocationsTurk(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendThaiRestaurants(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendLocationsThai(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendHindRestaurants(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendLocationsHind(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageFrenchRestaurants(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendLocationsFrench(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendBackToMain(Long chatId, String asosiyMenu) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(asosiyMenu);
        sendMessage.setReplyMarkup(buttons.sendMainButtons(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageBackToCountries(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.locationButtons(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageChinaRestaurants(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendLocationsChina(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageJapanRestaurants(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendLocationsJapan(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageItalyRestaurants(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendLocationsItaly(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendPhoto(Long chatId, String s,String caption) {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId);
        photo.setCaption(caption);
        photo.setPhoto(new InputFile(new File(s)));
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendLocation(Long chatId, double latitude, double longitude) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(latitude);
        sendLocation.setLongitude(longitude);
//        sendLocation.setReplyMarkup(buttons.sendLocationsItaly(chatId));

        try {
            execute(sendLocation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void sendRecipes(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(buttons.sendDishes(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendRestaurantsMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(buttons.locationButtons(chatId));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage(Long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        message.setReplyMarkup(buttons.sendMainButtons(chatId));
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "@TraditionalFoods_bot";
    }
    @Override
    public String getBotToken() {
        return "8031906374:AAE1dSUbd3AA8o237CcZnghF67DIYDofyb4";
    }
}
