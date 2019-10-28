package app;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
  static String price;

  public static void main(String[] args) throws IOException {

    Javalin app = Javalin.create(config -> {
      config.addStaticFiles("./HTML files");
      config.addStaticFiles("./Images");

    }).start(7000);

    
    String url = "https://www.amazon.com/Intel-i5-9600K-Desktop-Processor-Unlocked/dp/B07HHLX1R8/ref=sr_1_4?keywords=cpu+i5&qid=1571698422&s=electronics&sr=1-4";
    Document document = Jsoup.connect(url).get();
    Elements question = document.select("#priceblock_ourprice");
    price = ("Price is " + question.html());
    System.out.print(price);

    app.get("/ajax", ctx -> {

            ctx.result(price);

    });


    app.ws("/websocket/:path", ws -> {
      ws.onConnect(ctx -> {
        ctx.send(price);
      });
    });

  }

}

 
  

