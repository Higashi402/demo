package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BookRequestCommand implements ActionCommand {

    private static final String PARAM_ACTION= "action";
    private static  Map<Integer, BookRequest> bookRequests = new HashMap<>();
    private static final BookDictionary iniBooks = BookDictionary.createBookDictionaryWithInitialData();

    @Override
    public String execute(HttpServletRequest request) {
        String action = request.getParameter(PARAM_ACTION);
        String page = null;
        if (action != null) {
            switch (action) {
                case "add":
                    int id = Integer.parseInt(request.getParameter("id"));

                    if (!bookRequests.containsKey(id)) {
                        try {
                            BookRequestManager.addBookRequest(bookRequests, iniBooks, id);
                            request.setAttribute("resultMessage",
                                    MessageManager.getProperty("message.addingrequestsucces"));
                            System.out.println("Книга добавлена");
                            System.out.println(bookRequests.get(id));
                            // Ваша логика добавления книги в заявки
                        } catch (IllegalArgumentException e) {
                            request.setAttribute("resultMessage",
                                    MessageManager.getProperty("message.existserror"));
                        }
                    } else {
                        request.setAttribute("resultMessage",
                                MessageManager.getProperty("message.existserror"));
                        System.out.println("Книга уже есть");// Устанавливаем сообщение об ошибке, что книга с таким ID уже существует
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
                MessageManager.getProperty("message.bookRequestError"));
            System.out.println("Ошибка");}
        System.out.println("Содержимое переменной bookRequests:");
        for (Map.Entry<Integer, BookRequest> entry : bookRequests.entrySet()) {
            System.out.println("ID книги: " + entry.getKey() + ", Данные о запросе: " + entry.getValue());
        }
        page = ConfigurationManager.getProperty("path.page.admin");
        return page; // Возвращаете актуальный путь
    }
}
