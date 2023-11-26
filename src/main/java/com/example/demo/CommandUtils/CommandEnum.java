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
    REDIRECTTOADDBOOKPAGECOMMAND {
        {
            this.command = new RedirectToAddBookPageCommand();
        }
    },
    ADDBOOKSCOMMAND {
        {
            this.command = new AddBooksCommand();
        }
    },
    REDIRECTTOUPDATEBOOKCOMMAND {
        {
            this.command = new RedirectToUpdateBookCommand();
        }
    },
    UPDATEBOOKCOMMAND {
        {
            this.command = new UpdateBookCommand();
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
