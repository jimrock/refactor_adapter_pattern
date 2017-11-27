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
		if (current == root)
			throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
		Node siblingNode = new TagNode(sibling);
		parent.add(siblingNode);
		current = siblingNode;
		history.pop();
		history.push(current);
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
