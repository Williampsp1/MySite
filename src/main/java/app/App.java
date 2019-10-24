package app;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.log.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public final class App extends HttpServlet {

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
      // config.addSinglePageRoot("/", "/vue/Start.html");
      config.addStaticFiles("/HTML files");
      config.addStaticFiles("/Images");

    }).start(7000);

    app.
    String url = "https://www.amazon.com/Intel-i5-9600K-Desktop-Processor-Unlocked/dp/B07HHLX1R8/ref=sr_1_4?keywords=cpu+i5&qid=1571698422&s=electronics&sr=1-4";
    Document document = Jsoup.connect(url).get();
    Elements question = document.select("#priceblock_ourprice");
     price = ("Price is " + question.html());

    File input = new File("src/main/resources/HTML files/Prices.html");
   

    Document doc = Jsoup.parse(input, "utf-8");
    Element p = doc.select("div").first();
    p.text("My Example Text");

    app.ws("/websocket/:path", ws -> {
      ws.onConnect(ctx -> {
        ctx.send(price);
      });
    });
   

  }

  
    @Override protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException
              { String message = "Hello World"; request.setAttribute("message",
              message); // This will be available as ${message}
              request.getRequestDispatcher("/PC needs.html").forward(request,
              response);
              
              }
   

}

 
  

