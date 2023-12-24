package com.example.demo.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TimeoutSessionListener implements HttpSessionListener {

    private static final int MAX_INACTIVE_DURATION = 30 * 60;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval((int) MAX_INACTIVE_DURATION);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        long sessionCreationTime = session.getCreationTime();
        long currentTime = System.currentTimeMillis();

        if (currentTime - sessionCreationTime > MAX_INACTIVE_DURATION) {
            session.invalidate(); // Удаляем сессию, если прошло больше 30 минут

        }
    }
}