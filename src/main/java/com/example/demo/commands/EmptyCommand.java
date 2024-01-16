package com.example.demo.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class EmptyCommand extends Command {

    @Override
    public void send() throws ServletException, IOException {
        forward("login");
    }
}
