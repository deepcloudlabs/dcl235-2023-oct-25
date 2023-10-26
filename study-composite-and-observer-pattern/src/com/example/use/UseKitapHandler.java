package com.example.use;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

import com.example.domain.Kitap;
import com.example.handler.GenericHandler;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class UseKitapHandler {
    public static void main(String[] args) {

        try {
			XMLReader parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            GenericHandler<Kitap> handler = new GenericHandler<Kitap>(Kitap.class);
            parser.setContentHandler(handler);
            parser.parse("resources/books.xml");
            for (Kitap kitap : handler.getElements(Kitap.class)) {
                System.err.println("Kitap AdÄ±: " + kitap.getBaşlık());
                System.err.println("Yazar    : " + kitap.getYazar());
                System.err.println("YayÄ±n Evi: " + kitap.getYayın_evi());
                System.err.println("YÄ±l      : " + kitap.getYıl());
                System.err.println("Sayfa    : " + kitap.getSayfa());
                System.err.println("Fiyat    : " + kitap.getFiyat());
                System.err.println("Kod      : " + kitap.getKod());
                System.err.println("------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
