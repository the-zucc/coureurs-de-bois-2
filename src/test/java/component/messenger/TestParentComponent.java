package component.messenger;

import component.Component;
import component.ParentComponent;
import org.junit.jupiter.api.Test;
import util.IdFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParentComponent implements ParentComponent {
    private Map<String, Component> children = new HashMap<>();
    private String id;
    private ParentComponent parent;

    private int test_count = 0;
    public void increaseTestCount(){
        children.keySet().forEach(child -> {
            test_count++;
        });
    }
    public TestParentComponent(String id, ParentComponent parent){
        this.id = id;
        this.parent = parent;
    }

    @Override
    public Component getChild(String id) {
        if(!children.containsKey(id)){
            throw new IllegalArgumentException("unknown child id="+id);
        }
        return children.get(id);
    }

    @Override
    public void addChild(String id, Component child) {
        if(this.children.containsKey(id)){
            throw new IllegalArgumentException("duplicate child id="+id);
        }
        this.children.put(id, child);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public ParentComponent getParent() {
        return this.parent;
    }

    @Override
    public void update(float nanoSeconds) {
        test_count++;
        children.keySet().forEach(key -> {
            Component child = children.get(key);
            child.update(nanoSeconds);
            this.test_count+=((TestParentComponent)child).getTestCount();
        });
    }


    public int getTestCount() {
        return this.test_count;
    }
}
