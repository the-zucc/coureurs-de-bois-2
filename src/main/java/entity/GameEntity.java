package entity;

import component.Component;

import java.util.List;

public interface GameEntity{
    public String getId();
    void addComponent(Component component);
    Component removeComponent(String componentId);
    Component getcomponent(String componentId);
    List<Component> getComponents();
}
