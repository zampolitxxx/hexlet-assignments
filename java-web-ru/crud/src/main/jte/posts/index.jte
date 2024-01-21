@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes;

@param PostsPage page
@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            @for(var post : page.getPosts())
                <div>
                    <p><h5><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>   ${post.getBody()}</h5></p>
                </div>
            @endfor
            <p><a href="${NamedRoutes.postsPath() + "?page=" + (page.getPag() - 1)}">назад</a>  <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPag() + 1)}">вперед</a></p>
        </main>
    </div>
`
)