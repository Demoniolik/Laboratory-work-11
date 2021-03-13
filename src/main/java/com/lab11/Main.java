package com.lab11;

import com.lab11.model.Verifier;
import com.lab11.parser.DOMController;
import com.lab11.parser.SAXController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        String inputFile = scanner.nextLine();
        System.out.print("Enter output file name: ");
        String outputFile = scanner.nextLine();
        SAXController saxController = new SAXController(inputFile);
        try {
            saxController.parse();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        Verifier.changeAverageScoreIfIncorrect(saxController.getGroup());

        try {
            DOMController.saveToXML(saxController.getGroup(), outputFile);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
