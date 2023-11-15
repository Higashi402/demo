package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BookRequestCommand implements ActionCommand {

    private static final String PARAM_ACTION= "action";

    @Override
    public String execute(HttpServletRequest request) {
        String action = request.getParameter(PARAM_ACTION);
        String page = null;
        Map<Integer, BookRequest> bookRequests = new HashMap<>();
        BookDictionary iniBooks = BookDictionary.createBookDictionaryWithInitialData();
        if (action != null) {
            switch (action) {
                case "add":
                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        BookRequestManager.addBookRequest(bookRequests, iniBooks, id);
                        request.setAttribute("resultMessage",
                                MessageManager.getProperty("message.addingrequestsucces"));
                        // Ваша логика добавления книги в заявки
                    } catch (IllegalArgumentException e) {
                        request.setAttribute("resultMessage",
                                MessageManager.getProperty("message.existserror"));
                    }
                    break;
                case "view":
                    BookRequestManager.getAllBookRequests(bookRequests);
                    request.setAttribute("requestsDicionary", bookRequests);
                    break;
                case "remove":
                    int removeId = Integer.parseInt(request.getParameter("removeId"));
                    BookRequestManager.removeBookRequest(bookRequests, removeId);
                    request.setAttribute("requestsDicionary", bookRequests);
                    break;
                default:
                    // Обработка других действий (по желанию)
                    break;
            }


            // Здесь можно определить, какая страница должна быть отображена после операции

        }
        else {  request.setAttribute("errorBookRequestMessage",
                MessageManager.getProperty("message.bookRequestError")); }
        System.out.println("Запрос выполнен");
        page = ConfigurationManager.getProperty("path.page.admin");
        return page; // Возвращаете актуальный путь
    }
}
