package app;
import javax.xml.ws.soap.Addressing;

import org.eclipse.jetty.util.PathWatcher.Config;

import io.javalin.plugin.rendering.vue.VueComponent;

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
            config.addSinglePageRoot("/", "/vue/index.html");
        }).start(7000);            

        
                
    }
}
