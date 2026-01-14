package ru.leonid.server.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Модель url для хранения и валидации данных.
 *
 * @author Leonid Platonov
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductValidator {
    @NotBlank(message = "URL не может быть пустым.")
    @Pattern(regexp = "^https://www\\.wildberries\\.ru/(catalog/.+|seller/\\d+)$",
            message = "Неправильный формат ссылки")
    private String urlForm;

    @Override
    public String toString() {
        return "ProductValidator{"
                + "url_form='" + urlForm + '\''
                + '}';
    }
}
