package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

@FunctionalInterface
public interface AccessManager2 {
    void manage(Handler handler, Context ctx, String username, String password) throws Exception;
}