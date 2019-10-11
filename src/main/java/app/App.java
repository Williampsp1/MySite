package app;

import org.eclipse.jetty.server.Authentication.User;
import org.eclipse.jetty.util.security.Password;

import io.javalin.Javalin;
import io.javalin.http.Context;



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
       
        app.post("/login",  ctx -> {
           // console.log(`tried to login with url params ${req.query.username} and ${req.query.password}`);
          
            if ((ctx.formParam("uname").equals("ELI")) && (ctx.formParam("psw").equals("iloveyou"))) {
              ctx.redirect("Part1.html");
            }
            else{
               String hey = ctx.formParam("uname");
               String pws = ctx.formParam("psw");
              ctx.redirect("indexPrac.html");
              System.out.printf("%s,%s",hey ,pws );
             // ctx.html(hey);
              //ctx.html(pws);
            }
          });
       // app.post("/", handler)
        
      //  FixedAccessManager hey = new FixedAccessManager(un.,password);

		
    }
        
}

