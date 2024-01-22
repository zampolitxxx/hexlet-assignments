@import exercise.dto.users.UserPage
@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <title></title>
    </head>
    <body>
        @if(page.getHeader().isEmpty())
            <p>Пока нет пользователей</p>
        @else
            @for(var user : page.getUsers())
                <h2><a href="/users/${user.getId()}">${user.getId()}${user.getFirstName()} ${user.getLastName()}</a></h2>
            @endfor
        @endif
    </body>
</html>
