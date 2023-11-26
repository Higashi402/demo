package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.BookContainer;
import com.example.demo.utils.BookEntry;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UpdateBookCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        String rating = request.getParameter("rating");
        // Проверяем, не являются ли атрибуты пустыми
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null &&
                !amount.isEmpty() && rating != null && !rating.isEmpty() && id != null && !id.isEmpty()) {
            try {
                // Парсим значение рейтинга в число
                int intamount = Integer.parseInt(amount);
                int intid = Integer.parseInt(id);
                double doublerating = Double.parseDouble(rating);
                BookContainer.bookInfo.updateBookById(intid, title, author, intamount, doublerating);
                Map<Integer, BookEntry> bookDictionary =  BookContainer.bookInfo.getAllBooks();
                request.setAttribute("bookDictionary", bookDictionary);
                String page = ConfigurationManager.getProperty("path.page.catalog");
                return page;
            } catch (NumberFormatException e) {
                // Обработка ошибки, если значение рейтинга не удалось преобразовать в число
                e.printStackTrace(); // или другая логика обработки ошибки
            }
        }

        // Вероятно, здесь нужно предусмотреть другие случаи, например, если атрибуты пустые или неверные
        // Возвращаем страницу с ошибкой или другую страницу по умолчанию
        System.out.println("что то пошло не так");
        String errorPage = ConfigurationManager.getProperty("path.page.error");
        return errorPage;
    }
}
