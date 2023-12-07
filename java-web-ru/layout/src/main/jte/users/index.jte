@import exercise.dto.users.UsersPage
@param UsersPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
        @for(var user : page.getUsers())
            <h5><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()} ${user.getEmail()}</a></h5>
        @endfor
</body>
</html>