package component.messenger;

import component.Component;

public interface MessageReceiver extends Component {
    Messenger getMessenger();
    void subsribe(String message, MessageAction action);
    void executeAction(String message, String senderId, Object... params);
}
