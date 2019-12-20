package component;

public interface Component {
    String getId();
    ParentComponent getParent();
    void update(float nanoSeconds);
}
