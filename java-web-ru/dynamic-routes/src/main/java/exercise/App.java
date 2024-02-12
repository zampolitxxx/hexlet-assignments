package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            Map<String, String> result = new HashMap<>();
            for (Map<String, String> i : COMPANIES) {
                var n = i.get("id");
                if (n.equals(id.toString())) {
                    result.putAll(i);
                }
            }
            if (result.isEmpty()) {
                ctx.status(404);
                ctx.result("Company not found");
            } else {
                ctx.json(result);
            }

        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
