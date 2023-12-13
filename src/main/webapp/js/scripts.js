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
    var username = parentRow.getAttribute('data-user');
    document.getElementById('Username').value = username;
    document.getElementById('user-request-form').submit();
}




function submitUserRequest(element) {
    var parentRow = element.closest('.book-row');
    var username = parentRow.getAttribute('data-user');
    var requestId = parentRow.getAttribute('data-request-id');

    document.getElementById('requestId').value = requestId;
    document.getElementById('username').value = username;

    document.getElementById('request-form').submit();
}



