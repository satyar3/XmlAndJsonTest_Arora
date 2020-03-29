package rough;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class TestXMLtestng
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("src/test/resources/locators/testng-failed.xml");

		//System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList list = doc.getElementsByTagName("test");
		
		for(int i = 0; i<list.getLength(); i++)
		{
			Node n = list.item(i);
			System.out.println(n.getAttributes().getNamedItem("name").getNodeValue().replaceAll("\\(failed\\)", ""));
		}
	}
}
