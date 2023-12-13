package com.example.demo.utils;

public enum RequestStatus {
    INPROCESSING(1, "В рассмотрении"),
    READYFORPICKUP(2, "Готова к выдаче"),
    ISSUED(3, "Выдана");

    private final int code;
    private final String description;

    RequestStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
