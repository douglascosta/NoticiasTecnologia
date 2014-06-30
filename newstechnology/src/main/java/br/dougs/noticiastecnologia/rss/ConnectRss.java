package br.dougs.noticiastecnologia.rss;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import br.dougs.noticiastecnologia.models.News;

/**
 * Criado por Douglas (douglas.cst90@gmail.com) em 07/06/14.
 */
public class ConnectRss {

     News objBean;
     Vector<News> vectParse;

    int mediaThumbnailCount;
    boolean urlflag;
    int count = 0;

    public  List<News> getNoticias() {

        List<News> noticias = new ArrayList<News>();

        try {

            vectParse = new Vector<News>();
            URL url = new URL("http://globoesporte.globo.com/servico/semantica/editorias/plantao/futebol/times/atletico-mg/feed.rss");
            URLConnection con = url.openConnection();

            System.out.println("Connection is : " + con);

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            System.out.println("Reader :" + reader);

            String inputLine;
            String fullStr = "";
            while ((inputLine = reader.readLine()) != null)
                fullStr = fullStr.concat(inputLine + "\n");

            InputStream istream = url.openStream();

            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            Document doc = builder.parse(istream);

            doc.getDocumentElement().normalize();


            NodeList nList = doc.getElementsByTagName("item");

            System.out.println();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    objBean = new News();
                    vectParse.add(objBean);

                    objBean.setTitle(getTagValue("title", eElement));
                    objBean.setDescription(getTagValue("description", eElement));
                    String noHTMLString = objBean.getDescription().replaceAll("\\<.*?\\>", "");
                    objBean.setDescription(noHTMLString);
                    objBean.setLink(getTagValue("link", eElement));
                    objBean.setPubdate(getTagValue("pubDate", eElement));

                }
            }

            for (int index1 = 0; index1 < vectParse.size(); index1++) {

                News ObjNB = (News) vectParse.get(index1);

                System.out.println("Item No : " + index1);
                System.out.println();

                System.out.println("Title is : " + ObjNB.getTitle());
                System.out.println("Description is : " + ObjNB.getDescription());
                System.out.println("Link is : " + ObjNB.getLink());
                System.out.println("Pubdate is : " + ObjNB.getPubdate());

                System.out.println();
                System.out
                        .println("-------------------------------------------------------------------------------------------------------------");

                noticias.add(ObjNB);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return noticias;
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
                .getChildNodes();

        Node nValue = (Node) nlList.item(0);

        if (nValue != null && nValue.getNodeValue() != null) {
            return nValue.getNodeValue();
        }

        return "";
    }
}
