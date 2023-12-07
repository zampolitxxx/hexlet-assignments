@import exercise.dto.users.UserPage
@import gg.jte.Content
@param Content header
@param Content footer
@param UserPage page

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
    ${header}
        <h5>${page.getUser().getFirstName()} ${page.getUser().getLastName()} ${page.getUser().getEmail()}</h5>
    ${footer}
</body>
</html>