package SoftMebel;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Divan {
    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.trustStore", "F:/Projects/hypermarketmebel/cert/hypermarketmebel.crt.jks");
        String Path = "https://hypermarketmebel.ru/catalog/divany_dlya_ofisa/";

        Document doc1 = Jsoup.connect(Path).get();
        Elements links1 = doc1.getElementsByClass("main-item__total-link view2");
        Elements Category = doc1.getElementsByClass("section-h1");
        Elements Name = doc1.getElementsByClass("main-item__title-name");
        Elements lHref = doc1.select("a.d_block");


        int y = 0;
        for (Element link1 : links1) {

            String addressUrl = links1.get(y).select("a[href]").attr("abs:href");
////try
           Document doc2 = Jsoup.connect(addressUrl).get();
            Elements Price = doc2.getElementsByClass("card-mid__price-newprice");
            Elements CartBot = doc2.getElementsByClass("card-bot__prop-name");
            Elements Values = doc2.getElementsByClass("card-bot__prop-value");
            Elements DetalText = doc2.getElementsByClass("detailText");
            Elements Images = doc2.getElementsByClass("card__img-slider-block");

            System.out.print(Category.text()+ " ; " + Name.get(y).text() + ";" + Price.text() + ";" );

            int val=0;
            for (Element Value : Values){
                System.out.print(CartBot.get(val).text()+ ";"+ Values.get(val).text()+ ";" );
                val++;
            }
   //         System.out.print(DetalText.text()+"; " + Images.select("a[href]").attr("abs:href"));
            System.out.print(DetalText.text()+"; " + " ;");

            int valImg=0;
            for (Element Image:Images){
                System.out.print( Images.get(valImg).select("a[href]").attr("abs:href")+ " ; ");
                valImg++;
            }


            System.out.println();


            y++;
        }

    }
}
