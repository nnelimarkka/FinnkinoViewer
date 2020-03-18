package my.app.finnkinoviewer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class XmlReader {
    private static XmlReader xml = null;

    private XmlReader() {
    }

    public static XmlReader getXmlReader() {
        if (xml == null) {
            xml = new XmlReader();
        }
        return(xml);
    }

    public void readAreasXml() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString1 = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString1);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i < nList.getLength(); i++) {
                String name;
                int id;
                Theatres temp = new Theatres();
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    id = Integer.valueOf(element.getElementsByTagName("ID").item(0).getTextContent());
                    name = element.getElementsByTagName("Name").item(0).getTextContent();
                    temp.setTheatres(name, id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
