package ru.leonid.parser.core;

import org.openqa.selenium.WebDriver;

/**
 * Интерфейс для навигации по странице.
 *
 * @author Leonid Platonov
 */
public interface PageNavigator {
    /**
     * Прокручивает страницу, чтобы загрузить все элементы.
     *
     * @param driver WebDriver для управления браузером
     */
    void scrollPage(WebDriver driver);
}
