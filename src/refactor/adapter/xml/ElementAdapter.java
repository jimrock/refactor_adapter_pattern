package refactor.adapter.xml;

import org.w3c.dom.Element;

public class ElementAdapter {

    public ElementAdapter(Element element) {
        this.element = element;
    }

    Element element;

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
