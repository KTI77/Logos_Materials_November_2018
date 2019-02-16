$(document).ready(function() {

    showAllUsers();

    $('#btnRegister').on('click', function() {
        signup();
    });

    $(document).on('click', '#usersTable tbody button', function(e){
        console.log(e.target.id);
        let btnId = e.target.id;
        let userId = btnId.split('-')[1];
        deleteUser(userId);
    })
});

function deleteUser(userId) {
    let deleteUser = confirm('Ви впевнені що хочете видалити цього user-а?');
    if(deleteUser) {
        alert('Delete user with id[' + userId + ']');
    }
}

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
            if (serverResponse.status == 201) {
                alert('User added to database');
                $('#addUserForm')[0].reset();
                $('#usersTable tbody').empty();
                showAllUsers();
            }
        }
    });
}

function showAllUsers() {
    $.ajax({
        url: SERVER_URL + 'users',
        method: 'GET',
        contentType: 'application/json',
        complete: function(serverResponse) {
            console.log(serverResponse.responseJSON);
            let users = serverResponse.responseJSON;

            $.each(users, function(key, value){
                $('#usersTable tbody').append(
                    `
                    <tr>
                        <td>${ value.id }</td>
                        <td>${ value.name }</td>
                        <td>${ value.email }</td>
                        <td>${ value.password }</td>
                        <td>${ value.sexType }</td>
                        <td>
                            <button class="btn btn-danger btn-sm" id="user-${value.id}">Delete</button>
                        </td>
                    </tr>
                    `
                );
            });
        }
    });


}