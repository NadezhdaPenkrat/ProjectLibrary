package src.com.freeit.applibrary.xmlestablish;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.com.freeit.applibrary.model.Book;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {


    public static List<Book> readXML() {

        File file = new File("book.xml");

        List<Book> list = new ArrayList<>();

        try {
            DocumentBuilder docParser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = docParser.parse(file);

            Node root = document.getDocumentElement();

            NodeList books = root.getChildNodes();

            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);

                if (book.getNodeType() != Node.TEXT_NODE) {
                    list.add(getBook(book));

                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static Book getBook(Node node) {
        Book book = new Book();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            book.setTitle(getTagValue("title", element));
            book.setISBN(getTagValue("ISBN", element));

            NodeList ofParameters = node.getChildNodes();

            for (int i = 0; i < ofParameters.getLength(); i++) {
                if (ofParameters.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element parameter = (Element) ofParameters.item(i);

                    switch (parameter.getNodeName()) {
                        case "author":
                            book.setAuthor(element.getTextContent());
                            break;

                        case "genre":
                            book.setGenre(element.getTextContent());
                            break;
                    }
                }
            }

        }


        return book;
    }

    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}

