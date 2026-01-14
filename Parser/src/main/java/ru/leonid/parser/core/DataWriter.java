package ru.leonid.parser.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import ru.leonid.parser.models.Product;

/**
 * Интерфейс для записи данных о продуктах.
 *
 * @author Leonid Platonov
 */
public interface DataWriter {
    /**
     * Записывает список продуктов.
     *
     * @param products список продуктов
     * @throws JsonProcessingException если происходит ошибка при обработке JSON
     */
    void writeProducts(List<Product> products) throws JsonProcessingException;
}
