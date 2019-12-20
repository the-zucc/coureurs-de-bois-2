package component.messenger;

public interface MessageAction {
    public abstract void run(String senderId, Object ... args);
}
