function saveFormState(formId, isOpen) {
    localStorage.setItem(formId, isOpen ? "1" : "0");
}

function openViewBooksPage() {
    window.location.href = 'jsp/requests.jsp';
}

// Функция для открытия формы
function openForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = "block";
    saveFormState(formId, true);
    if(formId == 'confirmExitForm') {
        localStorage.clear();
        saveFormState(formId, false);
    }
}

// Функция для закрытия формы
function closeForm(formId) {
    var form = document.getElementById(formId);
    var form_main = document.getElementById('newForm');
    if (formId == 'viewBooksForm') {
        form.style.display = "none";
        form_main.style.display = "none";
    }
    form.style.display = "none";
    saveFormState(formId, false);
}

// Функция для восстановления состояния форм после обновления страницы
function restoreFormState() {
    for (var i = 0; i < localStorage.length; i++) {
        var formId = localStorage.key(i);
        var isOpen = localStorage.getItem(formId);

        if (isOpen === "1") {
            openForm(formId);
        }
    }
}

document.addEventListener('DOMContentLoaded', function () {
    var tableRows = document.querySelectorAll('#bookTableBody tr');

    tableRows.forEach(function (row) {
        row.addEventListener('mouseover', function () {
            this.classList.add('hover');
        });

        row.addEventListener('mouseout', function () {
            this.classList.remove('hover');
        });

        row.addEventListener('click', function () {
            var rowIndex = this.getAttribute('data-row-index'); // Получаем номер строки
            openNewFormWithData(row.cells[0].innerText, row.cells[1].innerText, row.cells[2].innerText, row.cells[3].innerText);

        });
    });
});

function openNewFormWithData(bookId, bookTitle, bookAuthor, bookRating) {
    var newForm = document.getElementById('newForm');
    newForm.style.display = 'block';
    var formContent = '<h2>Данные книги</h2>' +
        '<p><strong>ID:</strong> ' + bookId + '</p>' +
        '<p><strong>Название:</strong> ' + bookTitle + '</p>' +
        '<p><strong>Автор:</strong> ' + bookAuthor + '</p>' +
        '<p><strong>Рейтинг:</strong> ' + bookRating + '</p>' +
        '<form action="controller" method="post">' +
        '<input type="hidden" name="command" value="bookrequestaddcommand">' +
        '<input type="hidden" name="id" value="' + bookId + '">' +
        '<button type="submit" id="button-hover" onclick="openForm(\'newForm\'); closeForm(\'viewBooksForm\');"  > Отправить заявку на книгу</button>' +
        '</form>';

    newForm.innerHTML = formContent;

    // Добавление обработчика события на отправку формы при нажатии на кнопку
    document.getElementById('bookRequestForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Предотвращаем стандартное действие отправки формы

        var closeButton = document.createElement('div');
        closeButton.className = 'close-button';
        closeButton.onclick = function () {
            closeForm('newForm');
        };
        newForm.appendChild(closeButton);
    });
}

window.addEventListener('load', restoreFormState);