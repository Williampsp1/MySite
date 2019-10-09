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

        
        Javalin.create(config -> {
          //  config.addSinglePageRoot("/", "/vue/Start.html");
            config.addStaticFiles("/vue");
        }).start(7000);            

        
                
    }
}
