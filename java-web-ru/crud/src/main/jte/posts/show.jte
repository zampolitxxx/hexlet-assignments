@import exercise.util.NamedRoutes;
@import exercise.dto.posts.PostPage

@param PostPage page
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <a href="${NamedRoutes.postsPath()}">Все посты</a>
            <p><h5>${page.getPost().getName()}</h5></p>
            <p><h6>${page.getPost().getBody()}</h6></p>
        </main>
    </div>
`
)