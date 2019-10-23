package app;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public final class App {

  private App() {
  }

  /**
   * Says hello to the world.
   * 
   * @param args The arguments of the program.
   */
  static String title;

  public static void main(String[] args) throws IOException {

    Javalin app = Javalin.create(config -> {
      // config.addSinglePageRoot("/", "/vue/Start.html");
      config.addStaticFiles("/HTML files");
      config.addStaticFiles("/Images");

    }).start(7000);

    app.post("/login", ctx -> {
      // console.log(`tried to login with url params ${req.query.username} and
      // ${req.query.password}`);

      if ((ctx.formParam("uname").equals("Will")) && (ctx.formParam("psw").equals("pass"))) {
        ctx.redirect("Part1.html");
      } else {

        ctx.redirect("indexPrac.html");

      }
    });

    String url = "https://www.amazon.com/Intel-i5-9600K-Desktop-Processor-Unlocked/dp/B07HHLX1R8/ref=sr_1_4?keywords=cpu+i5&qid=1571698422&s=electronics&sr=1-4";

    
    Document document = Jsoup.connect(url).get();
   Elements question = document.select("#priceblock_ourprice");
System.out.println("Price is " + question.html());

   // title = document.title();
  //  System.out.println(spanElement.text());
    
    app.ws("/websocket/:path", ws -> {
      ws.onConnect(ctx -> 
      ctx.send(title));
    });
   // window.location ="PC needs.html" + title;
     
  


		
    }
    public String getString(){
       return title;
     }
        
}

