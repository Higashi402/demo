package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.BookContainer;
import com.example.demo.utils.BookDictionary;
import com.example.demo.utils.BookEntry;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AddBooksCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        System.out.println("запрос есть");
        // Проверяем, не являются ли атрибуты пустыми
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null && !amount.isEmpty()) {
            try {
                // Парсим значение рейтинга в число
                int intamount = Integer.parseInt(amount);
                int newBookId = generateNewBookId(BookContainer.bookInfo);
                BookContainer.bookInfo.addBook(newBookId, title, author, intamount, 0);
                Map<Integer, BookEntry> bookDictionary =  BookContainer.bookInfo.getAllBooks();
                request.setAttribute("bookDictionary", bookDictionary);
                // Вероятно, у вас есть другая логика для возврата страницы
                String page = ConfigurationManager.getProperty("path.page.catalog");
                return page;
            } catch (NumberFormatException e) {
                // Обработка ошибки, если значение рейтинга не удалось преобразовать в число
                e.printStackTrace(); // или другая логика обработки ошибки
            }
        }

        // Вероятно, здесь нужно предусмотреть другие случаи, например, если атрибуты пустые или неверные
        // Возвращаем страницу с ошибкой или другую страницу по умолчанию
        String errorPage = ConfigurationManager.getProperty("path.page.error");
        return errorPage;
    }
    private int generateNewBookId(BookDictionary bookDictionary) {
        // Ваша логика генерации уникального идентификатора (может быть использовано, например, bookDictionary.size() + 1)
        // Возвращаем новый уникальный идентификатор
        return bookDictionary.getDictionarySize() + 1;
    }
}

