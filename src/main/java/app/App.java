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
            config.addStaticFiles("/HTML files");
            config.addStaticFiles("/Images");
            
        }).start(7000); 
       
        app.post("/login",  ctx -> {
           // console.log(`tried to login with url params ${req.query.username} and ${req.query.password}`);
          
            if ((ctx.formParam("uname").equals("Will")) && (ctx.formParam("psw").equals("pass"))) {
              ctx.redirect("Part1.html");
            }
            else{
               
              ctx.redirect("indexPrac.html");
              
             // ctx.html(hey);
              //ctx.html(pws);
            }
          });
       // app.post("/", handler)
        
      //  FixedAccessManager hey = new FixedAccessManager(un.,password);

		
    }
        
}

