@import exercise.dto.users.UsersPage
@param UsersPage page
@template.layout.page(
header = @`
    <h2>Пользователи</h2>
    <h5><a href="/"> Main Page</a> </h5>
    <h5><a href="/users/"> Пользователи </a> </h5>
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