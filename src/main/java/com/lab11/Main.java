package com.lab11;

import com.lab11.model.Verifier;
import com.lab11.parser.DOMController;
import com.lab11.parser.SAXController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXController saxController = new SAXController("group.xml");
        try {
            saxController.parse();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        Verifier.changeAverageScoreIfIncorrect(saxController.getGroup());

        try {
            DOMController.saveToXML(saxController.getGroup(), "output.xml");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
