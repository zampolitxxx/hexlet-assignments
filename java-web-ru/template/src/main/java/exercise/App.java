package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.stream.Collectors;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var header = "header";
            var page = new UsersPage(header, USERS);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        app.get("/users/{id}", ctx -> {
            var header = "header";
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            List<User> user = USERS.stream()
                    .filter(x -> x.getId() == id)
                    .toList();
            if (user.isEmpty()) {
                ctx.status(404);
                ctx.result("User not found");
            } else {
                var page = new UserPage(user.get(0), header);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
