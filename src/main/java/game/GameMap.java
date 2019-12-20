package game;

import component.Component;
import component.messenger.MessageAction;
import component.messenger.MessageReceiver;
import component.ParentComponent;
import component.messenger.Messenger;
import util.IdFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameMap implements MessageReceiver, ParentComponent {
    private Map<String, Component> children = new HashMap<>();
    private String id;
    private Messenger messenger;
    Map<String, MessageAction> messageActions = new HashMap<>();
    private ParentComponent parent;

    public GameMap(ParentComponent parent, Messenger messenger){
        this.parent = parent;
        this.messenger = messenger;
        this.id = IdFactory.nextId(IdFactory.ID_PREFIX_MAP);
    }

    @Override
    public Component getChild(String id) {
        if(children.containsKey(id)){
            return children.get(id);
        }else{
            throw new IllegalArgumentException("no child with id "+id);
        }
    }

    @Override
    public void addChild(String id, Component child) {
        if(children.containsKey(id)){
            throw new IllegalArgumentException("duplicate child: id='"+getId()+"childId='"+id+"'");
        }
        children.put(id,child);
    }

    @Override
    public Messenger getMessenger() {
        return this.messenger;
    }

    @Override
    public void onMessage(String message, MessageAction action) {
        this.messageActions.put(message, action);
        this.getMessenger().subscribe(message, this);
    }

    @Override
    public void executeAction(String message, String senderId, Object... params) {
        this.messageActions.get(message).run(senderId, params);
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
        Iterator i = this.iterator();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
