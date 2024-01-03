@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage

@param LoginPage page
@template.layout.page(
    content = @`
        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="text" placeholder="nickname" name="nickname">
            <input type="password" placeholder="password" name="password">
            <input type="submit">
        </form>
    `
)
