package component.messenger;
import util.IdFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Messenger {
    private Map<String,Map<String, MessageReceiver>> messageReceivers;
    public Messenger(){
        this.messageReceivers = new HashMap<>();
    }

    /**
     * To send a message to one specific entity with a known ID.
     * @param message message to send
     * @param senderId the ID of the sender
     * @param targetId the target entity's ID.
     * @param params the params to send with the message
     */
    public void sendMessage(String message, String senderId, String targetId, Object... params){
        if(messageReceivers.containsKey(message)){
            Map<String, MessageReceiver> subscribers = messageReceivers.get(message);
            if(subscribers.containsKey(targetId)){
                subscribers.get(targetId).executeAction(message, senderId, params);
            }
        }else{
            throw new IllegalArgumentException("message "+message+" has no subscribers.");
        }
    }

    /**
     * To send a message to multiple entities which match an ID
     * @param message the message to send
     * @param senderId the ID of the sender
     * @param targetIds a regex matching the target entities' IDs
     * @param params the params to send with the message
     */
    public void sendMessage(String message, String senderId, Pattern targetIds, Object... params){
        if(messageReceivers.containsKey(message)){
            Map<String, MessageReceiver> subscribers = messageReceivers.get(message);
            subscribers.entrySet()
                    .stream()
                    .filter(entry -> targetIds.matcher(entry.getKey()).matches())
                    .forEach(entry -> entry.getValue().executeAction(message, senderId, params));
        }
    }
    public void subscribe(String message, MessageReceiver subscriber) {
        if(messageReceivers.containsKey(message)){
            messageReceivers.get(message).put(subscriber.getId(), subscriber);
        }else{
            HashMap currentMessageSubscribers = new HashMap<>();
            currentMessageSubscribers.put(subscriber.getId(), subscriber);
            messageReceivers.put(message,  currentMessageSubscribers);
        }
    }
}
