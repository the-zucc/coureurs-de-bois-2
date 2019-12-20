package component.messenger;

import component.ParentComponent;
import component.messenger.MessageReceiver;
import component.messenger.Messenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.plugin2.message.Message;
import util.IdFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestMessenger {
    private static Messenger messenger;
    private static TestMessageReceiver m1;
    private static TestMessageReceiver m2;
    @BeforeAll
    static void setup() {
        messenger = new Messenger();
        m1 =  new TestMessageReceiver(null, messenger);
        m2 = new TestMessageReceiver(null, messenger);
    }
    @Test
    void testMessenger(){

        //simulate send message from m1 to m2
        messenger.sendMessage(TestMessageReceiver.STRING_TEST_MESSAGE_RECEIVER, m1.getId(), m2.getId());
        assertEquals(true, ((TestMessageReceiver) m2).hasTestBeenRun(),
                "BOOLEAN_HAS_TEST_BEEN_RUN should be true for messageReceiver "+m2);
        assertEquals(false, ((TestMessageReceiver) m1).hasTestBeenRun(),
                "BOOLEAN_HAS_TEST_BEEN_RUN should be false for messageReceiver "+m1);

        //simulate send message from m2 to m1
        messenger.sendMessage(TestMessageReceiver.STRING_TEST_MESSAGE_RECEIVER, m2.getId(), m1.getId());
        assertEquals(true, ((TestMessageReceiver) m1).hasTestBeenRun(),
                "BOOLEAN_HAS_TEST_BEEN_RUN should be true for messageReceiver "+m1);
    }
    @Test
    void testMessengerMessageHasNoSubscribers(){
        String message = "fdgjgsfndl";
        try{
            messenger.sendMessage(message, m1.getId(), m2.getId());
            fail("messenger.sendMessage("
                    .concat(message).concat(", ")
                    .concat(m1.getId()).concat(", ")
                    .concat(m2.getId()).concat(")")
                    .concat(" should throw "+IllegalArgumentException.class.getName()));
        }catch(IllegalArgumentException e){

        }catch(Exception e){
            fail("messenger.sendMessage("
                    .concat(message).concat(", ")
                    .concat(m1.getId()).concat(", ")
                    .concat(m2.getId()).concat(")")
                    .concat(" should throw "+IllegalArgumentException.class.getName()));
        }
    }
}
