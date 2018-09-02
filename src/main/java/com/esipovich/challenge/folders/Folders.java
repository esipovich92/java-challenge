package com.esipovich.challenge.folders;

import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Artem Esipovich 15.06.2018
 *
 * Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure
 * and returns all folder names that start with startingLetter. The XML format is given in the example below.
 *
 * For example, for the letter 'u' and an XML file:
 * <?xml version="1.0" encoding="UTF-8"?>
 * <folder name="c">
 *     <folder name="program files">
 *         <folder name="uninstall information" />
 *     </folder>
 *     <folder name="users" />
 * </folder>
 *
 * the function should return a collection with items "uninstall information" and "users" (in any order).
 */

public class Folders {

    private static List<String> folderNames(String xml, char startingLetter) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<String> folderNames = new ArrayList<>();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        NodeList nodeList = builder.parse(inputStream).getElementsByTagName("folder");
        for (int i = 0; i < nodeList.getLength(); i++) {
            String folderName = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
            if (folderName.startsWith(String.valueOf(startingLetter))) {
                folderNames.add(folderName);
            }
        }
        return folderNames;
    }

    public static void main(String[] args) throws Exception{
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}
