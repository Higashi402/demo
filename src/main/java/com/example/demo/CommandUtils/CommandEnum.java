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
            //this.command = new ViewUsersCommand();
        }

    },
    BOOKREQUESTADDCOMMAND {
        {
            this.command = new BookRequestAddCommand();
        }

    },
    VIEWREQUESTS {
        {
            this.command = new ViewRequestsCommand();
        }

    },
    BOOKREQUESTDELETECOMMAND {
        {
            //this.command = new BookRequestDeleteCommand();
        }

    },
    VIEWBOOKS {
        {
            this.command = new ViewBooksCommand();
        }
    },
    DELETEBOOK {
        {
            this.command = new DeleteBookCommand();
        }
    },
    EDITBOOK {
        {
            this.command = new EditBookCommand();
        }
    },
    REDIRECTTOADDBOOKPAGECOMMAND {
        {
            this.command = new RedirectToAddBookPageCommand();
        }
    },
    REDIRECTTOMAINMENU {
        {
            this.command = new RedirectToMainMenuCommand();
        }
    },
    ADDBOOK {
        {
            this.command = new AddBooksCommand();
        }
    },
    REDIRECTTOEDITBOOK {
        {
            this.command = new RedirectToEditBookCommand();
        }
    },
    REDIRECTTOCATALOG {
        {
            this.command = new RedirectToCatalogCommand();
        }
    },
    VIEWBOOKINFORMATION {
        {
            this.command = new ViewBookInformation();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
