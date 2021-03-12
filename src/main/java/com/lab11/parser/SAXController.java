package com.lab11.parser;

import com.lab11.constants.XML;
import com.lab11.model.Group;
import com.lab11.model.Student;
import com.lab11.model.Subject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXController extends DefaultHandler {
    private String xmlFileName;
    private String currentElement;
    private Group group;
    private Student student;
    private Subject subject;

    public Group getGroup() {
        return group;
    }

    public SAXController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public void parse()throws ParserConfigurationException, IOException, org.xml.sax.SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        saxParserFactory.setNamespaceAware(true);
        saxParserFactory.setValidating(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(xmlFileName, this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = localName;
        if (XML.GROUP.getValue().equals(currentElement)) {
            group = new Group();
            return;
        }
        if (XML.STUDENT.getValue().equals(currentElement)) {
            student = new Student();
            student.setFirstname(attributes.getValue(0));
            student.setLastname(attributes.getValue(1));
            student.setGroupnumber(attributes.getValue(2));
            return;
        }
        if (XML.SUBJECT.getValue().equals(currentElement)) {
            subject = new Subject();
            subject.setTitle(attributes.getValue(0));
            subject.setMark(Integer.parseInt(attributes.getValue(1)));
            student.getSubject().add(subject);
        }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementText = new String(ch, start, length).trim();
        if (elementText.isEmpty()) {
            return;
        }
        if (XML.AVERAGE.getValue().equals(currentElement)) {
            student.setAverage(Integer.parseInt(elementText));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (XML.STUDENT.getValue().equals(localName)) {
            group.getStudents().add(student);
        }
    }
}
