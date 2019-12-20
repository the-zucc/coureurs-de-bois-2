package component.messenger;

import component.ParentComponent;
import util.IdFactory;

import java.util.HashMap;
import java.util.Map;

public class TestMessageReceiver implements MessageReceiver {
    private Messenger messenger;
    private Map<String, MessageAction> messageActions;

    public static final String STRING_TEST_MESSAGE_RECEIVER = "test-message";
    private boolean BOOLEAN_HAS_TEST_BEEN_RUN = false;
    public boolean hasTestBeenRun(){return BOOLEAN_HAS_TEST_BEEN_RUN;}
    //properties
    private final String id;
    private ParentComponent parent;

    public TestMessageReceiver(ParentComponent parent, Messenger messenger){
        this.id = IdFactory.nextId(IdFactory.ID_PREFIX_TREE);
        this.messageActions = new HashMap<>();
        this.parent = parent;
        this.messenger = messenger;
        this.onMessage(STRING_TEST_MESSAGE_RECEIVER, (params) -> {
            this.BOOLEAN_HAS_TEST_BEEN_RUN = true;
        });
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
    public void executeAction(String message, String senderId, Object... args){
        this.messageActions.get(message).run(args);
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

    }
}
