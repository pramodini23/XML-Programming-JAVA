package Assignment3_XMLParser;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserDTD {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        final boolean[] exceptionOccured = {false};
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setValidating(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                exceptionOccured[0] = true;
                exception.printStackTrace();
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                exceptionOccured[0] = true;

                exception.printStackTrace();
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                exceptionOccured[0] = true;

                exception.printStackTrace();
            }
        });
        Document doc = builder.parse("data.xml");
        if (exceptionOccured[0] == false){
            System.out.println("XML is parsed against DTD successfully and validation is complete with zero errors");
        }
    }
}
