package com.example.demo;

import javax.servlet.http.HttpServletRequest;

public class BookRequestAddCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
                    int id = Integer.parseInt(request.getParameter("id"));

                    if (!BookRequestsContainer.bookRequests.containsKey(id)) {
                        try {
                            BookRequestManager.addBookRequest(BookRequestsContainer.bookRequests, BookDictionary.createBookDictionaryWithInitialData(), id);
                            request.setAttribute("resMessage",
                                    MessageManager.getProperty("message.addingrequestsucces"));
                            System.out.println("Книга добавлена");
                            System.out.println(BookRequestsContainer.bookRequests.get(id));
                            // Ваша логика добавления книги в заявки
                        } catch (IllegalArgumentException e) {
                            request.setAttribute("resMessage",
                                    MessageManager.getProperty("message.existserror"));
                        }
                    } else {
                        request.setAttribute("resMessage",
                                MessageManager.getProperty("message.existserror"));
                        System.out.println("Книга уже есть");// Устанавливаем сообщение об ошибке, что книга с таким ID уже существует
                    }
        String page = ConfigurationManager.getProperty("path.page.catalog");
        return page; // Возвращаете актуальный путь
    }
}
