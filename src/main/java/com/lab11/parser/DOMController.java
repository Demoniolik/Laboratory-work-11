package com.lab11.parser;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.lab11.constants.XML;
import com.lab11.model.Group;
import com.lab11.model.Student;
import com.lab11.model.Subject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.io.File;

public class DOMController {
    public static void saveToXML(Group group, String outputXmlFile)
            throws ParserConfigurationException, TransformerException {
        saveToXML(getDocument(group), outputXmlFile);
    }

    public static void saveToXML(Document document, String outputXmlFile)
            throws TransformerException {
        StreamResult streamResult = new StreamResult(new File(outputXmlFile));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "group.dtd");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), streamResult);
    }

    public static Document getDocument(Group group) throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element groupElement = document.createElement(XML.GROUP.getValue());
        document.appendChild(groupElement);

        for (Student student : group.getStudents()) {
            // Creating dish element
            Element studentElement = document.createElement(XML.STUDENT.getValue());
            studentElement.setAttribute(XML.STUDENT_FIRST_NAME.getValue(), student.getFirstname());
            studentElement.setAttribute(XML.STUDENT_LAST_NAME.getValue(), student.getLastname());
            studentElement.setAttribute(XML.GROUP_NUMBER.getValue(), student.getGroupnumber());
            groupElement.appendChild(studentElement);

            createSubjectElements(document, student, studentElement);

            Element averageElement = document.createElement(XML.AVERAGE.getValue());
            averageElement.setTextContent(student.getAverage() + "");
            studentElement.appendChild(averageElement);

        }
        return document;
    }

    private static void createSubjectElements(Document document, Student student, Element studentElement) {
        for (Subject subject : student.getSubject()) {
            Element subjectElement = document.createElement(XML.SUBJECT.getValue());
            subjectElement.setAttribute(XML.SUBJECT_TITLE.getValue(), subject.getTitle());
            subjectElement.setAttribute(XML.SUBJECT_MARK.getValue(), subject.getMark() + "");
            studentElement.appendChild(subjectElement);
        }
    }


}
