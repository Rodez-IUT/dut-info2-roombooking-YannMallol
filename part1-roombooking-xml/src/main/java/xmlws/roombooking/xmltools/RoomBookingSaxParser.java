package xmlws.roombooking.xmltools;

import xmlws.roombooking.xmltools.samples.RoomBookingBasicHandler;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RoomBookingSaxParser implements RoomBookingParser {
    @Override
    public RoomBooking parse(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingBasicHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
