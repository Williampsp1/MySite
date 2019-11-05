package app;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;
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

     
    String url = "https://www.amazon.com/gp/product/B07B41WS48/ref=ox_sc_act_title_7?smid=ATVPDKIKX0DER&psc=1";
    Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2").timeout(0).ignoreHttpErrors(true).get();
    Elements question = document.select("#priceblock_ourprice");
    price = ("Amazon Price: " + question.html());
    

    app.get("/ajax", ctx -> {

            ctx.result(price);

    });

/*
    app.ws("/websocket/:path", ws -> {
      ws.onConnect(ctx -> {
        ctx.send(price);
      });
    });
    */
  }

}

 
  

