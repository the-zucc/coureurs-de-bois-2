package component;

public interface ParentComponent extends Component{
    Component getChild(String id);
    void addChild(String id, Component child);
}
