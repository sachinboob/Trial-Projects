package com.trials.json;

import java.io.File;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class JsonPathDemo {

	public static void main(String[] args) throws Exception {

		String jsonStr = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}}}";

		String jsonPath = "$.data.data[0].total.amount";

//		System.out.println("Amount :- " + JsonPath.read(new File("FLEX-345678-1.json"), "$.data.data[0].total.amount"));

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("PO_NS.xml");

		// Create XPath

		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();

		// 1) Get book titles written after 2001
		XPathExpression expr = xpath.compile("/PurchaseOrder/currency/name/text()");
		Object result = expr.evaluate(doc, XPathConstants.STRING);
		System.out.println("Result :- " + result);

//        NodeList nodes = (NodeList) result;
//        for (int i = 0; i < nodes.getLength(); i++) {
//            System.out.println(nodes.item(i).getNodeValue());
//        }

//		List<Object> authors = JsonPath.read(jsonStr, "$.store.book[*].author");

//		JsonPath path = JsonPath.compile("$.store.book");
//		List<Object> books = path.read(jsonStr);

//		System.out.println(list.toString());

	}

}
