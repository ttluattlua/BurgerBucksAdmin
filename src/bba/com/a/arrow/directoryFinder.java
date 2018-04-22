package bba.com.a.arrow;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class directoryFinder {
  
  //static public final String directory = "D:/Burgerbucks-Customer/WebContent/XML/";
  static public final String directory = "D:/Programming/BurgerBucks/Burgerbucks-Customer/WebContent/XML/";
  
  static public String directoryFind() {
    
    File directory = new File(".");
    String current_directory = null;
    
    try {
      current_directory = directory.getCanonicalPath() + "/WebContent/XML/";
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return current_directory;
  }

}
