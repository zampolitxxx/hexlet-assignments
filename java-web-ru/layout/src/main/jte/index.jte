@import exercise.dto.users.UsersPage
@import exercise.dto.users.UserPage
@param UsersPage page
@param UserPage upage
@template.layout.page(
header = @`
    <a href="/">Main Page</a>
    <a href="/users">Пользователи</a>
`,
footer = @`
    <a href="https://github.com/zampolitxxx">Github</a>
`
)
