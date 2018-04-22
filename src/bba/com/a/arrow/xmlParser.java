package bba.com.a.arrow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import bba.com.a.model.Bb_IngredientDto;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;




public class xmlParser {
  
	 
  /*-------------------------------------------------------------
   * 파일안에있는 모든 ingredient가져오기
   *--------------------------------------------------------*/
  static public List<Bb_IngredientDto> xml_getIngredient(String ingredient_xml) {
    
    List<Bb_IngredientDto> ingredient_list = new ArrayList<>();
    
    try {
            
      File xmlFile = new File(ingredient_xml);
      DocumentBuilderFactory docu_factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docu_builder = docu_factory.newDocumentBuilder();
      Document xmldoc = docu_builder.parse(xmlFile);
      
      NodeList ingredient_nodelist = xmldoc.getElementsByTagName("ingredient");
      
      System.out.println("재료 노드 사이즈 : " + ingredient_nodelist.getLength());
      
      for (int i = 0; i < ingredient_nodelist.getLength(); i++) {
        
        Element ingredient = (Element)ingredient_nodelist.item(i);
        
        int seq = Integer.parseInt(getTagValue(ingredient, "seq"));
        String name = getTagValue(ingredient, "name");
        int types = Integer.parseInt(getTagValue(ingredient, "types"));   
        int price = Integer.parseInt(getTagValue(ingredient, "price"));   
        int cal = Integer.parseInt(getTagValue(ingredient, "cal"));
        int del =  Integer.parseInt(getTagValue(ingredient, "del"));
        String image_Src = getTagValue(ingredient, "img");
        
        ingredient_list.add(new Bb_IngredientDto(seq, name, types, price, cal, del, image_Src));
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
    return ingredient_list;
  }
 
	 
	/*-------------------------------------------------------------
	* 파일안에있는 ingredient재료리스트 뽑아오기 (번리스트,야채리스트...
	*--------------------------------------------------------*/
  static public Map<String, List<Bb_IngredientDto>> xml_getIngredient_classified(String ingredient_xml) {
    
    Map<String, List<Bb_IngredientDto>> ingredient_map = new HashMap<>();
    List<Bb_IngredientDto> bun_list = new ArrayList<>();
    List<Bb_IngredientDto> patty_list = new ArrayList<>();
    List<Bb_IngredientDto> vege_list = new ArrayList<>();
    List<Bb_IngredientDto> etc_list = new ArrayList<>();
    
    try {
            
      File xmlFile = new File(ingredient_xml);
      DocumentBuilderFactory docu_factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docu_builder = docu_factory.newDocumentBuilder();
      Document xmldoc = docu_builder.parse(xmlFile);
      
      NodeList ingredient_list = xmldoc.getElementsByTagName("ingredient");
      
      System.out.println("재료 노드 사이즈 : " + ingredient_list.getLength());
      
      for (int i = 0; i < ingredient_list.getLength(); i++) {
        
        Element ingredient = (Element)ingredient_list.item(i);
        
        int seq = Integer.parseInt(getTagValue(ingredient, "seq"));
        String name = getTagValue(ingredient, "name");
        int types = Integer.parseInt(getTagValue(ingredient, "types"));   
        int price = Integer.parseInt(getTagValue(ingredient, "price"));   
        int cal = Integer.parseInt(getTagValue(ingredient, "cal"));
        int del =  Integer.parseInt(getTagValue(ingredient, "del"));
        String image_Src = getTagValue(ingredient, "img");
        
        switch (types) {
        case 0: bun_list.add(new Bb_IngredientDto(seq, name, types, price, cal, del, image_Src)); break;
        case 1: patty_list.add(new Bb_IngredientDto(seq, name, types, price, cal, del, image_Src)); break;
        case 2: vege_list.add(new Bb_IngredientDto(seq, name, types, price, cal, del, image_Src)); break;
        case 3: etc_list.add(new Bb_IngredientDto(seq, name, types, price, cal, del, image_Src)); break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ingredient_map.put("bun_list", bun_list);
      ingredient_map.put("patty_list", patty_list);
      ingredient_map.put("vege_list", vege_list);
      ingredient_map.put("etc_list", etc_list);
    }
    return ingredient_map;
  }
  
  /*-------------------------------------------------------------
   * ingredient추가
   *--------------------------------------------------------*/
  static public void xml_addIngredient(String ingredient_xml, Bb_IngredientDto ingredient_dto) {
    
    try {     
      File xmlFile = new File(ingredient_xml);
      DocumentBuilderFactory docu_factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docu_builder = docu_factory.newDocumentBuilder();   
      Document xmldoc = docu_builder.parse(xmlFile);
      
      Node parent_node = xmldoc.getElementsByTagName("ingredientlist").item(0); 
      
      parent_node.appendChild(xmldoc.createTextNode("\n  "));
      Element ingredient = xmldoc.createElement("ingredient");
      parent_node.appendChild(ingredient);
      parent_node.appendChild(xmldoc.createTextNode("\n\n"));
      
      
      getIngredient(xmldoc, ingredient, ingredient_dto);
      
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(xmldoc);
      StreamResult result = new StreamResult(new File(ingredient_xml));
      transformer.transform(source, result);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
  /*-------------------------------------------------------------
   * ingredient업데이트
   *--------------------------------------------------------*/
  static public void xml_updIngredient(String ingredient_xml, Bb_IngredientDto ingredient_dto) {
    
    try {     
      File xmlFile = new File(ingredient_xml);
      DocumentBuilderFactory docu_factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docu_builder = docu_factory.newDocumentBuilder();   
      Document xmldoc = docu_builder.parse(xmlFile);
      
      NodeList ingredient_nodelist = xmldoc.getElementsByTagName("ingredient");      
      Element ingredient = null;
      
      for (int i = 0; i < ingredient_nodelist.getLength(); i++) {
        ingredient = (Element) ingredient_nodelist.item(i);
        Element seq_element = (Element) ingredient.getElementsByTagName("seq").item(0);
                
        int seq = Integer.parseInt(seq_element.getTextContent());
        
        if ( seq == ingredient_dto.getSeq() ) break;
      }
      
      repIngredient(xmldoc, ingredient, ingredient_dto);
      
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(xmldoc);
      StreamResult result = new StreamResult(new File(ingredient_xml));
      transformer.transform(source, result);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
  /*-------------------------------------------------------------
   * ingredient삭제하기
   *--------------------------------------------------------*/
  static public void xml_delIngredient(String ingredient_xml, Bb_IngredientDto ingredient_dto) {
    
    try {     
      File xmlFile = new File(ingredient_xml);
      DocumentBuilderFactory docu_factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docu_builder = docu_factory.newDocumentBuilder();   
      Document xmldoc = docu_builder.parse(xmlFile);
      
      NodeList ingredient_nodelist = xmldoc.getElementsByTagName("ingredient");      
      Element ingredient = null;
      
      for (int i = 0; i < ingredient_nodelist.getLength(); i++) {
        ingredient = (Element) ingredient_nodelist.item(i);
        Element seq_element = (Element) ingredient.getElementsByTagName("seq").item(0);
                
        int seq = Integer.parseInt(seq_element.getTextContent());
        
        if ( seq == ingredient_dto.getSeq() ) break;
      }
      
      repIngredient(xmldoc, ingredient, ingredient_dto);
      
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(xmldoc);
      StreamResult result = new StreamResult(new File(ingredient_xml));
      transformer.transform(source, result);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  static public String getTagValue(Element element, String tag) {  
    NodeList nodelist = element.getElementsByTagName(tag).item(0).getChildNodes();
    String value = nodelist.item(0).getNodeValue();
    return value;
  }
  
  
  

  static public Node getIngredient(Document xmldoc, Element ingredient, Bb_IngredientDto ingredient_dto) {  
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "seq", Integer.toString(ingredient_dto.getSeq())));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "name", ingredient_dto.getName()));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "types", Integer.toString(ingredient_dto.getTypes())));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "price", Integer.toString(ingredient_dto.getPrice())));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "cal", Integer.toString(ingredient_dto.getCal())));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "del", Integer.toString(ingredient_dto.getDel())));
    ingredient.appendChild(xmldoc.createTextNode("\n    "));
    ingredient.appendChild(getIngredientElement(xmldoc, "img", ingredient_dto.getImage_Src()));
    ingredient.appendChild(xmldoc.createTextNode("\n  "));
    return ingredient;
  }
  
  static public void repIngredient(Document xmldoc, Element ingredient, Bb_IngredientDto ingredient_dto) {
    repIngredientElement(ingredient, ingredient.getElementsByTagName("seq").item(0), getIngredientElement(xmldoc, "seq", Integer.toString(ingredient_dto.getSeq())));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("name").item(0), getIngredientElement(xmldoc, "name", ingredient_dto.getName()));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("types").item(0), getIngredientElement(xmldoc, "types", Integer.toString(ingredient_dto.getTypes())));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("price").item(0), getIngredientElement(xmldoc, "price", Integer.toString(ingredient_dto.getPrice())));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("cal").item(0), getIngredientElement(xmldoc, "cal", Integer.toString(ingredient_dto.getCal())));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("del").item(0), getIngredientElement(xmldoc, "del", Integer.toString(ingredient_dto.getDel())));
    repIngredientElement(ingredient, ingredient.getElementsByTagName("img").item(0), getIngredientElement(xmldoc, "img", ingredient_dto.getImage_Src()));
  }
  
  static public Node getIngredientElement(Document xmldoc, String name, String value) {  
    Element node = xmldoc.createElement(name);
    node.appendChild(xmldoc.createTextNode(value));
    return node;
  }
  
  static public void repIngredientElement(Element ingredient, Node element_old, Node element_new) {  
    ingredient.replaceChild(element_new, element_old);
  }

}