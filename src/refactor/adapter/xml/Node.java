package refactor.adapter.xml;

public interface Node {
    void add(Node childNode);

    void addAttribute(String attribute, String value);

    void addValue(String value);
}
