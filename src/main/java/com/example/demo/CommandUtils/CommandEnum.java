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
    REDIRECTTOADDBOOKPAGECOMMAND {
        {
            //this.command = new RedirectToAddBookPageCommand();
        }
    },
    REDIRECTTOMAINMENU {
        {
            this.command = new RedirectToMainMenuCommand();
        }
    },
    ADDBOOKSCOMMAND {
        {
            this.command = new AddBooksCommand();
        }
    },
    REDIRECTTOUPDATEBOOKCOMMAND {
        {
            //this.command = new RedirectToUpdateBookCommand();
        }
    },
    UPDATEBOOKCOMMAND {
        {
            //this.command = new UpdateBookCommand();
        }
    },
    REDIRECTTOCATALOG {
        {
            this.command = new RedirectToCatalogCommand();
        }
    },
    VIEWUSERINFORMATION {
        {
            this.command = new ViewUserInformationCommand();
        }
    },
    VIEWUSERREQUESTS {
        {
            this.command = new ViewUserRequests();
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
