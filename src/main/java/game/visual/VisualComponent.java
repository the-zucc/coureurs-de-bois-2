package game.visual;

import component.Component;
import component.ParentComponent;
import component.messenger.MessageAction;
import component.messenger.MessageReceiver;
import component.messenger.Messenger;
import javafx.scene.Group;
import javafx.scene.Parent;

import java.util.HashMap;
import java.util.Map;

public abstract class VisualComponent implements Component, MessageReceiver {

    private String id;
    private ParentComponent parent;
    private Messenger messenger;
    private Map<String, MessageAction> messageActions = new HashMap<>();
    private Group visual;

    public VisualComponent(String id, ParentComponent parent, Messenger messenger){
        this.id = id;
        this.parent = parent;
        this.messenger = messenger;
        this.visual = buildVisual();
    }

    protected abstract Group buildVisual();

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public ParentComponent getParent() {
        return this.parent;
    }


    @Override
    public Messenger getMessenger() {
        return this.messenger;
    }

    @Override
    public void onMessage(String message, MessageAction action) {
        if(this.messageActions.containsKey(message)){
            throw new IllegalArgumentException("duplicate message listener: "+message);
        }
        messageActions.put(message, action);
    }

    @Override
    public void executeAction(String message, String senderId, Object... params) {
        if(!this.messageActions.containsKey(message)){
            throw new IllegalArgumentException("unknown message: "+message);
        }
        messageActions.get(message).run(senderId, params);
    }
}
