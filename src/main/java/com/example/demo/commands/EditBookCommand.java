package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.utils.BookContainer;
import com.example.demo.utils.BookEntry;
import com.example.demo.utils.ConfigurationManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class EditBookCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    @Override
    public void send() throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("titleValue");
        String author = request.getParameter("authorValue");
        String amount = request.getParameter("amountValue");
        String rating = request.getParameter("rating");
        System.out.println(id);
        System.out.println(title);
        System.out.println(author);
        System.out.println(amount);
        System.out.println(rating);
        // Проверяем, не являются ли атрибуты пустыми
        if (title != null && !title.isEmpty() && author != null && !author.isEmpty() && amount != null &&
                !amount.isEmpty() && rating != null && !rating.isEmpty() && id != null && !id.isEmpty()) {
            try {
                System.out.println("123");
                // Парсим значение рейтинга в число
                int intamount = Integer.parseInt(amount);
                int intid = Integer.parseInt(id);
                double doublerating = Double.parseDouble(rating);
                BookContainer.bookInfo.updateBookById(intid, title, author, intamount, doublerating);
                request.setAttribute("bookDictionary", BookContainer.bookInfo.getAllBooks());
                forward(ConfigurationManager.getProperty("path.page.catalog"));
            } catch (NumberFormatException e) {
                forward(ConfigurationManager.getProperty("path.page.catalog"));
                // Обработка ошибки, если значение рейтинга не удалось преобразовать в число
                e.printStackTrace(); // или другая логика обработки ошибки
            }
        }
        System.out.println("Не изменилось");
    }
}
