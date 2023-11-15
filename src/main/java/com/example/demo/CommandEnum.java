package com.example.demo;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    VIEWUSERS {
        {
            this.command = new ViewUsersCommand();
        }

    },
    BOOKREQUESTCOMMAND {
        {
            this.command = new BookRequestCommand();
        }

    },
    VIEWBOOKS {
        {
            this.command = new ViewBooksCommand();
        }
    },
    VIEWREQUESTS {
        {
            this.command = new ViewRequests();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
