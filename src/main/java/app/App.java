package app;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public final class App extends HttpServlet{

  private App() {
  }

  /**
   * Says hello to the world.
   * 
   * @param args The arguments of the program.
   */
  static String title;

  public static void main(String[] args)  throws IOException {

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
    String price = ("Price is " + question.html());

System.out.println(new File(".").getAbsoluteFile());

    File input = new File("src/main/resources/HTML files/Prices.html");
   /*  Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
    
    org.jsoup.nodes.Element div = doc.select("div").first(); // <div></div>
    div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
div.prepend("<p>First</p>");
div.append("<p>Last</p>");
// now: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>

org.jsoup.nodes.Element span = doc.select("span").first(); // <span>One</span>
span.wrap("<li><a href='http://example.com/'></a></li>");*/
// now: <li><a href="http://example.com"><span>One</span></a></li>
   // title = document.title();
  //  System.out.println(spanElement.text());
 
  Document doc = Jsoup.parse(input,"utf-8");
Element p = doc.select("div").first();
p.text("My Example Text");

    app.ws("/websocket/:path",ws -> {
      ws.onConnect(ctx -> {
        ctx.send(price);
      });
    });
   // window.location ="PC needs.html" + title;
     
  


		
    }
  


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Hello World";
        request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("/PC needs.html").forward(request, response);
    

    }
  }

