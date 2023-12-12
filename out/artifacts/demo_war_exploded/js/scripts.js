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


/*function displayBookInfo(element) {
        var bookTitle = element.dataset.title;
        var bookAuthor = element.dataset.author;
        var bookRating = element.dataset.rating;
        var bookId = element.dataset.id;
        var messageContainer = document.getElementById('message-container');
        var resMessage = (messageContainer.getAttribute('data-res-message') !== null) ? messageContainer.getAttribute('data-res-message') : '';
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
        <form id="book-request-form" action="controller" method="POST">
            <input type="hidden" name="command" value="bookrequestaddcommand">
            <input type="hidden" name="id" value="${bookId}">
            <button id="button-hover" >Сделать заявку</button>
        </form>
    `;
        document.body.appendChild(form);
}*/
function submitForm(element) {
    var parentRow = element.closest('.book-row');
    var bookId = parentRow.getAttribute('data-id');
    var bookTitle = parentRow.getAttribute('data-title');
    var bookAuthor = parentRow.getAttribute('data-author');
    var bookRating = parentRow.getAttribute('data-rating');

    document.getElementById('bookId').value = bookId;
    document.getElementById('bookTitle').value = bookTitle;
    document.getElementById('bookAuthor').value = bookAuthor;
    document.getElementById('bookRating').value = bookRating;

    document.getElementById('book-request-form').submit();
}

function submitUserForm(element) {
    var parentRow = element.closest('.book-row');
    var userId = parentRow.getAttribute('user-id');
    document.getElementById('userId').value = userId;
    document.getElementById('user-request-form').submit();
}

function checkChanges() {

    var currentUsername = document.getElementById('name').value;
    var currentUserFIO = document.getElementById('fio').value;
    var currentUserDOB = document.getElementById('birthdate').value;
    var currentUserPassword = document.getElementById('password').value;
    document.getElementById('username').value = currentUsername;
    document.getElementById('userFIO').value = currentUserFIO;
    document.getElementById('userDOB').value = currentUserDOB;
    document.getElementById('userPassword').value = currentUserPassword;

}




function submitUserRequest(element) {
    var parentRow = element.closest('.book-row');
    var username = parentRow.getAttribute('data-user');
    var requestId = parentRow.getAttribute('data-id');
    var requestTitle = parentRow.getAttribute('data-title');
    var requestAuthor = parentRow.getAttribute('data-author');
    var requestStatus = parentRow.getAttribute('data_status');
    document.getElementById('requestId').value = requestId;
    document.getElementById('username').value = username;
    document.getElementById('requestTitle').value = requestTitle;
    document.getElementById('requestAuthor').value = requestAuthor;
    document.getElementById('requestStatus').value = requestStatus;
    document.getElementById('request-form').submit();
}
/*
function sendRequest(element) {
    var bookId = element.dataset.id;
    var bookTitle = element.dataset.title;
    var bookAuthor = element.dataset.author;
    var bookRating = element.dataset.rating;

    // Формируем строку с параметрами запроса
    var params = new URLSearchParams();
    params.append('command', 'VIEWBOOKINFORMATION');
    params.append('id', bookId);
    params.append('title', bookTitle);
    params.append('author', bookAuthor);
    params.append('rating', bookRating);

    // Отправляем запрос на сервер
    fetch('controller?' + params, {
        method: 'POST'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Произошла ошибка: ' + response.status);
            }
            return response.text();
        })
        .then(data => {
            // Обработка успешного ответа от сервера
            console.log('Запрос успешно выполнен:', data);

            // Перенаправление на другую страницу (например, 'bookinfo.jsp')
            window.location.href = 'jsp/bookinfo.jsp';
        })
        .catch(error => {
            // Обработка ошибки при выполнении запроса
            console.error('Произошла ошибка при выполнении запроса:', error);
        });
}
*/

/*function submitForm() {
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
}*/


