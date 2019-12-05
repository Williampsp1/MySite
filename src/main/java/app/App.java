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

  private static String CPU = "https://www.amazon.com/gp/product/B07B41WS48/ref=ox_sc_act_title_7?smid=ATVPDKIKX0DER&psc=1";
  private static String GPU = "https://www.amazon.com/gp/product/B077VX31FZ/ref=ox_sc_act_title_1?smid=A1SD3U9M25WHJW&psc=1";
  private static String RAM = "https://www.amazon.com/gp/product/B06XJ5LT72/ref=ox_sc_act_title_3?smid=ATVPDKIKX0DER&psc=1";
  private static String MB = " https://www.amazon.com/gp/product/B07GRNSWNR/ref=ox_sc_act_title_6?smid=ATVPDKIKX0DER&psc=1";
  private static String ST = "https://www.amazon.com/gp/product/B073SBZ8YH/ref=ox_sc_act_title_2?smid=ATVPDKIKX0DER&psc=1";
  private static String PS = "https://www.amazon.com/gp/product/B01N3OAFHD/ref=ox_sc_act_title_5?smid=ATVPDKIKX0DER&psc=1";
  private static String CASE = "https://www.amazon.com/gp/product/B07GVL3CKJ/ref=ox_sc_act_title_4?smid=ATVPDKIKX0DER&th=1";
  private static String ICPU = "https://www.amazon.com/gp/product/B07HHLX1R8/ref=ox_sc_act_title_1?smid=A23NVCSO4PYH3S&psc=1";
  private static String ICPUF = "https://www.amazon.com/gp/product/B079NXZQBC/ref=ox_sc_act_title_1?smid=ATVPDKIKX0DER&psc=1";
  private static String IGPU = "https://www.amazon.com/gp/product/B07MC23VS4/ref=ox_sc_act_title_5?smid=ATVPDKIKX0DER&psc=1";
  private static String IRAM = "https://www.amazon.com/gp/product/B0134EW7G8/ref=ox_sc_act_title_7?smid=ATVPDKIKX0DER&psc=1";
  private static String IMB = "https://www.amazon.com/gp/product/B07CBKQ75V/ref=ox_sc_act_title_1?smid=A1FJ9SEK1UVDTX&psc=1";
  private static String IST = "https://www.amazon.com/dp/B078DPCY3T/ref=twister_B07P5VF5TL?_encoding=UTF8&psc=1";
  private static String IPS = "https://www.amazon.com/gp/product/B01B72W1VA/ref=ox_sc_act_title_2?smid=ATVPDKIKX0DER&psc=1";
  private static String ICASE = "https://www.amazon.com/gp/product/B01N9JPSEU/ref=ox_sc_act_title_3?smid=ATVPDKIKX0DER&th=1";
  private static String ACPU = "https://www.amazon.com/gp/product/B07HHN6KBZ/ref=ox_sc_act_title_1?smid=A17MC6HOH9AVE6&psc=1";
  private static String ACPUF = "https://www.amazon.com/gp/product/B079NXZQBC/ref=ox_sc_act_title_1?smid=ATVPDKIKX0DER&psc=1";
  private static String AGPU = "https://www.amazon.com/gp/product/B07GG9L5X1/ref=ox_sc_act_title_8?smid=ATVPDKIKX0DER&psc=1";
  private static String ARAM = "https://www.amazon.com/gp/product/B01CYILUB8/ref=ox_sc_act_title_7?smid=ATVPDKIKX0DER&psc=1";
  private static String AMB = "https://www.amazon.com/gp/product/B07J6Z9KJ2/ref=ox_sc_act_title_3?smid=AVCN3MVCVULPH&psc=1";
  private static String AST = "https://www.amazon.com/dp/B078DPCY3T/ref=twister_B07P5VF5TL?_encoding=UTF8&psc=1";
  private static String APS = "https://www.amazon.com/gp/product/B01B72W1VA/ref=ox_sc_act_title_2?smid=ATVPDKIKX0DER&psc=1";
  private static String ACASE = "https://www.amazon.com/gp/product/B01N9JPSEU/ref=ox_sc_act_title_3?smid=ATVPDKIKX0DER&th=1";
  private static Document document1;
  private static Document document2;
  private static Document document3;
  private static Elements price1;
  private static Elements price2;
  private static Elements price3;
  private static String[] BParts = { CPU, GPU, RAM, MB, ST, PS, CASE };
  private static String[] IParts = { ICPU, ICPUF, IGPU, IRAM, IMB, IST, IPS, ICASE };
  private static String[] AParts = { ACPU, ACPUF, AGPU, ARAM, AMB, AST, APS, ACASE };
  private static String result = "";
  private static String Iresult = "";
  private static String Aresult = "";

  public static void main(String[] args) throws IOException {

    Javalin app = Javalin.create(config -> {
      config.addStaticFiles("./HTML files");
      config.addStaticFiles("./Images");

    }).start(8080);

    for (int i = 0; i < BParts.length; i++) {
      document1 = Jsoup.connect(BParts[i]).userAgent(
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
          .timeout(0).get();
      price1 = document1.select("#priceblock_ourprice");
      result += ("Amazon Price: " + price1.html()) + ",";

    }

    for (int i = 0; i < IParts.length; i++) {
      document2 = Jsoup.connect(IParts[i]).userAgent(
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
          .timeout(0).get();
      price2 = document2.select("#priceblock_ourprice");
      Iresult += ("Amazon Price: " + price2.html()) + ",";
    }

    for (int i = 0; i < AParts.length; i++) {
      document3 = Jsoup.connect(AParts[i]).userAgent(
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
          .timeout(0).get();
      price3 = document3.select("#priceblock_ourprice");
      Aresult += ("Amazon Price: " + price3.html()) + ",";
    }

    app.get("/getBeginnerParts", ctx -> {

      ctx.result(result);
    });

    app.get("/getIntermediateParts", ctx -> {

      ctx.result(Iresult);

    });

    app.get("/getAdvancedParts", ctx -> {

      ctx.result(Aresult);

    });

  }
}
  

