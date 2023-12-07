@import exercise.dto.users.UsersPage
@param UsersPage page
@template.layout.page(
header = @`
    <a href="/">Main Page</a>
    <a href="/users">Пользователи</a>
`,
footer = @`
    <a href="https://github.com/zampolitxxx">Github</a>
`
)