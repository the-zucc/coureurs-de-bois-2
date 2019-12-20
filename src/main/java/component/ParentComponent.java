package component;

public interface ParentComponent extends Component, Iterable{
    Component getChild(String id);
    void addChild(String id, Component child);
}
