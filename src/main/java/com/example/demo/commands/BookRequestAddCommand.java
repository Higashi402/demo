package com.example.demo.commands;

import com.example.demo.CommandUtils.ActionCommand;
import com.example.demo.roles.RoleType;
import com.example.demo.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BookRequestAddCommand extends Command {

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);

    }

    public void send() throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        // Проверка наличия пользователя и его роли
        if (user != null && user.getRole() == RoleType.USER) {
            int id = Integer.parseInt(request.getParameter("id"));
            RegularUser regularUser = (RegularUser) user;
            if (!regularUser.getApplications().containsKey(id)) {
                try {
                    // Добавление заявки пользователю в его словарь
                    UserContainer.addBookRequestToUser(regularUser, id, new BookRequest(BookContainer.bookInfo.getBookById(id), "Отправлена"));
                    request.getSession().setAttribute("user", regularUser);// здесь должен быть ваш объект BookRequest
                    request.setAttribute("resMessage", MessageManager.getProperty("message.addingrequestsucces"));
                    System.out.println("Заявка добавлена для пользователя: " + regularUser.getUsername());
                } catch (Exception e) {
                    request.setAttribute("resMessage", MessageManager.getProperty("message.existserror"));
                }
            } else {
                request.setAttribute("resMessage", MessageManager.getProperty("message.existserror"));
                System.out.println("Заявка уже существует для пользователя: " + regularUser.getUsername());
            }
        } else {
            request.setAttribute("resMessage", MessageManager.getProperty("message.permissionerror"));
            System.out.println("Недостаточно прав для добавления заявки");
        }

        // Остальная часть вашего кода (получение данных и перенаправление)
        BookDictionary iniBooks = BookDictionary.createBookDictionaryWithInitialData();
        Map<Integer, BookEntry> bookDictionary = iniBooks.getAllBooks();
        request.setAttribute("bookDictionary", bookDictionary);

        System.out.println("Запрос выполнен");
        forward(ConfigurationManager.getProperty("path.page.bookinfo"));
    }
}
