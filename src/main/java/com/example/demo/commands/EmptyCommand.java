package com.example.demo.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class EmptyCommand extends Command {

    @Override
    public void send() throws ServletException, IOException {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        forward("login");
    }
}
