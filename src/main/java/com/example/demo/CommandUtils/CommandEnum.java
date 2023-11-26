package com.example.demo.CommandUtils;

import com.example.demo.commands.*;

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
            this.command = new ViewRequestsCommand();
        }

    },
    BOOKREQUESTDELETECOMMAND {
        {
            this.command = new BookRequestDeleteCommand();
        }

    },
    VIEWBOOKS {
        {
            this.command = new viewbooksuniversalcommand();
        }
    },
    CLOSE {
        {
            this.command = new CloseCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
