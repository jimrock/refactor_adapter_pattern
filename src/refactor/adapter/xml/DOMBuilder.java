package refactor.adapter.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Stack;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;

public class DOMBuilder extends AbstractBuilder {
	private Document doc;

    public DOMBuilder(String rootName) {
		init(rootName);
	}

	public void addBelow(String child) {
        addBelow(new ElementAdapter(doc.createElement(child),doc));
	}

    public void addBeside(String sibling) {
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
		Node siblingNode = new ElementAdapter(doc.createElement(sibling),doc);
		parent.add(siblingNode);
		current = siblingNode;
		history.pop();
		history.push(current);
	}

	public Document getDocument() {
		return doc;
	}

	protected void init(String rootName) {
		doc = new DocumentImpl();
		root = new ElementAdapter(doc.createElement(rootName), doc);
		doc.appendChild(((ElementAdapter)root).getElement());
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	public String toString() {
		OutputFormat format = new OutputFormat(doc);
		StringWriter stringOut = new StringWriter();
		XMLSerializer serial = new XMLSerializer(stringOut, format);
		try {
			serial.asDOMSerializer();
			serial.serialize(doc.getDocumentElement());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return ioe.getMessage();
		}
		return stringOut.toString();
	}
}
