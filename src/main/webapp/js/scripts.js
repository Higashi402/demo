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

document.addEventListener('DOMContentLoaded', function () {
    var rows = document.querySelectorAll('.book-row');

    rows.forEach(function (row) {
        row.addEventListener('click', function () {
            var bookId = row.dataset.id;
            var bookTitle = row.cells[1].innerText;
            var bookAuthor = row.cells[2].innerText;
            var bookRating = row.cells[3].innerText;

            // Создаем слой подложки
            var overlay = document.createElement('div');
            overlay.classList.add('overlay');
            document.body.appendChild(overlay);

            // Создаем форму
            var form = document.createElement('div');
            form.classList.add('book-form');

            // Добавляем информацию о книге в форму
            form.innerHTML = `
                <button class="close-button" onclick="closeForm()"></button>
                <h2>${bookTitle}</h2>
                <p>Автор: ${bookAuthor}</p>
                <p>Рейтинг: ${bookRating}</p>
                <button onclick="makeRequest(${bookId})">Сделать заявку</button>
            `;

            // Добавляем форму к телу документа
            document.body.appendChild(form);

            // Закрытие формы и слоя подложки при клике на overlay
            overlay.addEventListener('click', function () {
                closeForm();
            });
        });
    });
});
