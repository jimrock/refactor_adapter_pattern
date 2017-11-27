package refactor.adapter.xml;

import java.util.Stack;

public class XMLBuilder extends AbstractBuilder {

    public XMLBuilder(String rootName) {
		init(rootName);
	}

	public void addBelow(String child) {
        addBelow(new TagNode(child));
	}

	public void addBeside(String sibling) {
		addBeside(new TagNode(sibling));
	}

	protected void init(String rootName) {
		root = new TagNode(rootName);
		current = root;
		parent = root;
		history = new Stack();
		history.push(current);
	}

	public void startNewBuild(String rootName) {
		init(rootName);
	}

	public String toString() {
		return root.toString();
	}
}
