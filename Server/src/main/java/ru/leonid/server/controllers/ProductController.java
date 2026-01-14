package ru.leonid.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leonid.server.models.ProductValidator;
import ru.leonid.server.models.Products;
import ru.leonid.server.services.ProductService;

/**
 * Контроллер для работы с продуктами через веб-интерфейс.
 * Обрабатывает HTTP-запросы для операций с продуктами.
 *
 * @author Leonid Platonov
 */
@Controller
@RequestMapping("/products")  // Базовый путь для всех методов контроллера
public class ProductController {

    // Сервис для работы с продуктами
    private final ProductService productService;

    /**
     * Конструктор с автоматическим внедрением зависимостей.
     *
     * @param productService Сервис для работы с продуктами
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Обрабатывает GET-запрос для отображения начальной страницы продуктов.
     *
     * @param products Модель данных продукта для связывания с формой
     * @return Имя представления для отображения
     */
    @SuppressWarnings("checkstyle:MultipleStringLiterals")
    @GetMapping
    public String index(@ModelAttribute("products") ProductValidator products) {
        // Возвращает имя шаблона представления
        return "products/start";
    }

    /**
     * Обрабатывает POST-запрос для создания нового продукта.
     *
     * @param products Данные продукта из формы
     * @param bindingResult Результат валидации формы
     * @return Перенаправление на страницу списка пользователей
     * @throws JsonProcessingException Если возникает ошибка при обработке JSON
     */
    @PostMapping()
    public String create(@ModelAttribute("products") @Valid ProductValidator products, BindingResult bindingResult)
            throws JsonProcessingException {
        // Проверка на наличие ошибок валидации
        if (bindingResult.hasErrors()) {
            return "products/start"; // Возврат на ту же страницу, чтобы отобразить ошибки
        }


        Products products1 = new Products();
        products1.setUrl(products.getUrlForm());

        productService.create(products1);

        return "products/continue";
    }

}
