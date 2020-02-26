package xmlws.roombooking.xmltools.samples;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RoomBookingBasicHandler  extends DefaultHandler {
    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts)
            throws SAXException {
        System.out.println("In element: "+localName);
    }
    public void characters(char ch[], int start, int length)
            throws SAXException {
        System.out.println(new String(ch, start, length));
    }
}
