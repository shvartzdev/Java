package ru.wirbel.lab01.mylib;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GreetingsBuilder {
    private static final String BUNDLE_BASE_NAME = "messages";

    private int language = Greetings.LANGUAGE_RU;
    private int style = Greetings.STYLE_FORMAL;
    private String name;

    public GreetingsBuilder withLanguage(int language) {
        this.language = language;
        return this;
    }

    public GreetingsBuilder withStyle(int style) {
        this.style = style;
        return this;
    }

    public GreetingsBuilder to(String name) {
        this.name = name;
        return this;
    }

    public String build() {
        // Инициализируем StringBuilder
        StringBuilder greetings = new StringBuilder();
        // Загруажем коллекцию сообщений
        ResourceBundle messages = getMessages(this.language);

        // Формируем начало приветствия в зависимости от выбранного стиля
        switch (this.style) {
            case Greetings.STYLE_FRIENDLY:
                greetings.append(messages.getString("greetings.friendly"));
                break;
            case Greetings.STYLE_FORMAL:
            default:
                greetings.append(messages.getString("greetings.formal"));
        }

        // Добавляем имя, если указано
        if (this.name != null && !this.name.isEmpty()) {
            greetings.append(", " + this.name);
        }

        greetings.append("!");

        // Формируем строку
        return greetings.toString();
    }

    // Загрузка коллекции сообщений с учётом выбранного языка (локали)
    private ResourceBundle getMessages(int language) {
        Locale locale;

        switch (language) {
            case Greetings.LANGUAGE_EN:
                locale = new Locale("en", "US");
                break;
            case Greetings.LANGUAGE_RU:
            default:
                locale = new Locale("ru", "RU");
        }

        // Загружаем файл properties из classpath'а
        return PropertyResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);
    }
}