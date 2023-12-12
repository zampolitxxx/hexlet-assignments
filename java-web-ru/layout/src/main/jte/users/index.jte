@import exercise.dto.users.UsersPage
@param UsersPage page
@template.layout.page(
header = @`
    <h2>Пользователи</h2>
    @for(var user : page.getUsers())
        <tr>
            <td>
                ${user.getId()}
            </td>
            <td>
                <a href="/users/${user.getId()}"> ${user.getFirstName()} ${user.getLastName()}</a>
            </td>
        </tr>
    @endfor
`,
footer = @`
    <a href="https://github.com/zampolitxxx">Github</a>
`
)