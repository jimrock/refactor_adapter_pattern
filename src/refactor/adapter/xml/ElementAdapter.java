package refactor.adapter.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementAdapter implements Node{

    public ElementAdapter(Element element, Document document) {
        this.element = element;
        this.document = document;
    }

    Element element;

    Document document;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public void add(Node childNode) {
        this.getElement().appendChild(((ElementAdapter)childNode).getElement());
    }

    @Override
    public void addAttribute(String attribute, String value) {
        this.getElement().setAttribute(attribute, value);
    }

    @Override
    public void addValue(String value) {
        this.getElement().appendChild(this.getDocument().createTextNode(value));
    }
}
