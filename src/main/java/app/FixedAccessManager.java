package app;

import io.javalin.core.security.BasicAuthCredentials;
import io.javalin.core.util.Header;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class FixedAccessManager implements AccessManager2 {
    private String password;
    private String username;

    public FixedAccessManager(String username, String password) {
        this.password = password;
        this.username = username;
    }


@Override
public void manage(Handler handler, Context ctx, String username, String password) throws Exception {
	// TODO Auto-generated method stub
	BasicAuthCredentials credentials = ctx.basicAuthCredentials();
        if (credentials == null || !credentials.getUsername().equals("will")
                || credentials.getPassword().equals("pass")) {
            ctx.res.sendRedirect("Part1.html");
            ctx.header(Header.WWW_AUTHENTICATE, "Basic");
            ctx.result("Access denied");
            ctx.status(401);

        }
}


}