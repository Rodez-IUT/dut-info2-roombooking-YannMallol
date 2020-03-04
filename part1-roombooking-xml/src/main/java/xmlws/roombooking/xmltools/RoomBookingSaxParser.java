package xmlws.roombooking.xmltools;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class for objects responsible of RoomBooking xml files parsing
 * SAX version
 */
public class RoomBookingSaxParser {
    String valeur;
    String tmpLocalName;

    public RoomBooking roomBooking = new RoomBooking();

    /**
     * Parse an xml file provided as an input stream
     *
     * @param inputStream the input stream corresponding to the xml file
     */
    public RoomBooking parse(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingBasicHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomBooking;
    }

    private class RoomBookingBasicHandler extends DefaultHandler {

        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts)
                throws SAXException {
            tmpLocalName = localName;
            System.out.println("In element: " + localName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            SimpleDateFormat dateDebut = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat dateFin = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            valeur = new String(ch, start, length);
            if (valeur != null) {
                if (valeur.equals("label")) {
                    roomBooking.setRoomLabel(valeur);
                }
                if (valeur.equals("username")) {
                    roomBooking.setUsername(valeur);
                }
                if (valeur.equals("startDate")) {

                    try {
                        roomBooking.setStartDate(dateDebut.parse(valeur));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (valeur.equals("endDate")) {
                    try {
                        roomBooking.setEndDate(dateDebut.parse(valeur));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}


