$(document).ready(function() {

    showAllUsers();

    $('#btnRegister').on('click', function() {
        signup();
    });
});

function signup() {
    let userName = $('#userName').val();
    let userEmail = $('#userEmail').val();
    let userPassword = $('#userPassword').val();
    let userPasswordConfirm = $('#userPasswordConfirm').val();
    let userSexType = $('#userSexType').val();

    console.log(
        userName + " " + userEmail + " " + 
        userPassword + " " + userPasswordConfirm +
        userSexType
    );

    // name
    // email
    // password
    // passwordConfirm
    // sexType

    let user = {
        name: userName,
        email: userEmail,
        password: userPassword,
        passwordConfirm: userPasswordConfirm,
        sexType: userSexType
    };
    console.log(JSON.stringify(user));

    // Server URL : http://localhost:8080/
    // Endpoint: PostMapping("/users")
    $.ajax({
        url: SERVER_URL + 'users',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(user),
        complete: function(serverResponse) {
            console.log(serverResponse);
        }
    });
}

function showAllUsers() {
    $.ajax({
        url: SERVER_URL + 'users',
        method: 'GET',
        contentType: 'application/json',
        complete: function(serverResponse) {
            console.log(serverResponse);
        }
    });


}