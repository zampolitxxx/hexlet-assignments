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
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}">
        <input type="submit" value="Search">
    </form>
    @for(var user : page.getUsers())
        <div>
            <h5>
                ${user.getFirstName()}
            </h5>
        </div>
    @endfor
</body>
</html>