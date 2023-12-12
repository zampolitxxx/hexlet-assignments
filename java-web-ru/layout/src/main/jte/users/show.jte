@import exercise.dto.users.UserPage
@param UserPage page
@template.layout.page(
header = @`
    <h5>${page.getUser().getFirstName()} ${page.getUser().getLastName()} ${page.getUser().getEmail()}</h5>
`,
footer = @`
    <a href="https://github.com/zampolitxxx">Github</a>
`
)
