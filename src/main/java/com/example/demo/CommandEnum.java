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
    BOOKREQUESTADDCOMMAND {
        {
            this.command = new BookRequestAddCommand();
        }

    },
    BOOKREQUESTVIEWCOMMAND {
        {
            this.command = new BookRequestsViewCommand();
        }

    },
    BOOKREQUESTDELETECOMMAND {
        {
            this.command = new BookRequestDeleteCommand();
        }

    },
    VIEWBOOKS {
        {
            this.command = new ViewBooksCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
