package app;
import io.javalin.Javalin;


/**
 * Hello world!
 */
public class App {
dgdgdf
dgdgdfdf
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
    }
}
