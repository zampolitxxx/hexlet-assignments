package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    public static void index(Context ctx) {
        var pag = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int size = PostRepository.getEntities().size();
        int start = (pag - 1) * 5;
        int end = 0;
        if(pag * 5 < size) {
            end = pag * 5;
        } else {
            end = size;
        }
        var posts = PostRepository.getEntities().subList(start, end);
        var page = new PostsPage(pag, posts);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
