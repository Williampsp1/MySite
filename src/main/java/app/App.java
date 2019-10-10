package app;

import io.javalin.Javalin;


/**
 * Hello world!
 */
public final class App {
    

    private App() {
    }
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        
       Javalin app = Javalin.create(config -> {
          //  config.addSinglePageRoot("/", "/vue/Start.html");
            config.addStaticFiles("/vue");
        }).start(7000); 

        app.get("submit", ctx -> {
           // console.log(`tried to login with url params ${req.query.username} and ${req.query.password}`);
          
            if (ctx.req.username == "will" && req.query.password == "pass") {
              ctx.res.sendFile(path.join(__dirname, "Part1.html"));
            }
            else{
              ctx.res.sendFile(ctx.path.join(__dirname, "unauthorized.html"));
            }
          })
        
}
}
