function openForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = 'block';
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

function closeMyForm(formId) {
    var form = document.getElementById(formId);
    form.style.display = 'none';
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
                <form action="controller" method="POST">
                    <input type="hidden" name="command" value="bookrequestaddcommand">
                    <input type="hidden" name="id" value="${bookId}">
                    <button  id="button-hover" onclick="submitForm()" >Сделать заявку</button>
                </form>
            `;

        // Добавляем форму к телу документа
        document.body.appendChild(form);
}

function submitForm() {
    // Получение формы и ее данных
    var form = document.querySelector('.book-form form');
    var formData = new FormData(form);

    // Создание объекта XMLHttpRequest
    var xhr = new XMLHttpRequest();

    // Настройка запроса
    xhr.open('POST', form.action, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Отправка данных формы
    xhr.send(new URLSearchParams(formData));

    // Обработка ответа
    xhr.onload = function() {
        if (xhr.status === 200) {
            // Успешный ответ, обработайте его, как вам необходимо
            var messageContainer = document.getElementById('message-container');
            messageContainer.innerHTML = '<p>Заявка успешно отправлена!</p>';
            // Теперь можно добавить логику для обновления словаря на клиентской стороне (если необходимо)
        } else {
            // Обработка ошибки
            console.error('Произошла ошибка при отправке формы');
        }
    };
}


