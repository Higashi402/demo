function saveFormState(formId, isOpen) {
    localStorage.setItem(formId, isOpen ? "1" : "0");
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

function closeForm() {
    var form = document.querySelector('.book-form');
    var overlay = document.querySelector('.overlay');
    if (form) {
        form.remove();
    }
    if (overlay) {
        overlay.remove();
    }
}






    function displayBookInfo(element) {
    var bookTitle = element.dataset.title;
    var bookAuthor = element.dataset.author;
    var bookRating = element.dataset.rating;
    var bookId = element.dataset.id;
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    var form = document.createElement('div');
    form.classList.add('book-form');
        form.innerHTML = `
               <button class="close-button" onclick="closeForm()"></button>
                <h2>${bookTitle}</h2>
                <p>Автор тест: ${bookAuthor}</p>
                <p>Рейтинг: ${bookRating}</p>
                <form action="controller" method="post">
                <input type="hidden" name="command" value="bookrequestaddcommand">
                <input type="hidden" name="id" value="${bookId}">
                <button type="submit" id="button-hover" >Сделать заявку</button>
    </form>`;

        // Добавляем форму к телу документа
        document.body.appendChild(form);
}

function displayBookInfoForAdmin(element) {
    var bookTitle = element.dataset.title;
    var bookAuthor = element.dataset.author;
    var bookRating = element.dataset.rating;
    var bookId = element.dataset.id;
    var overlay = document.createElement('div');
    overlay.classList.add('overlay');
    document.body.appendChild(overlay);
    var form = document.createElement('div');
    form.classList.add('book-form');
    form.innerHTML = `
               <button class="close-button" onclick="closeForm()"></button>
                <h2>${bookTitle}</h2>
                <p>Автор тест: ${bookAuthor}</p>
                <p>Рейтинг: ${bookRating}</p>
               <form action="controller" method="post">
    <input type="hidden" name="bookId" value="${bookId}">
    <button type="submit" name="command" value="deleteBookCommand">Удалить книгу</button>
    <button type="submit" name="command" value="redirecttoupdatebookcommand">Редактировать книгу</button>
</form>`;

    // Добавляем форму к телу документа
    document.body.appendChild(form);
}

