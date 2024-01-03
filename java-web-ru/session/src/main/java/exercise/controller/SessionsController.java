package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }
    //Создаем сессию
    public static void create(Context ctx) throws Exception {
        try {
            var nickname = ctx.formParamAsClass("nickname", String.class)
                    .check(UsersRepository::existsByName, "Wrong user or password")
                    .get();
            var passwordHash = encrypt(ctx.formParam("password"));
            var user = UsersRepository.findByName(nickname);
            if (user != null && user.getPassword().equals(passwordHash)) {
                ctx.sessionAttribute("currentUser", nickname);
                ctx.redirect(NamedRoutes.rootPath());
            } else {
                throw new NotFoundResponse("Wrong username or password");
            }
        } catch (NotFoundResponse e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
