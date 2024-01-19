@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title></title>
</head>
<body>
@if(page.getHeader().isEmpty())
    <p>Пока нет пользователей</p>
@else
        <h2>First name: ${page.getUser().getFirstName()}</h2>
        <h2>Last name: ${page.getUser().getLastName()}</h2>
        <h2>Email: ${page.getUser().getEmail()}</h2>
@endif
</body>
</html>