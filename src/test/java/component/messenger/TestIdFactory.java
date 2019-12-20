package component.messenger;

import org.junit.jupiter.api.Test;
import util.IdFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestIdFactory {
    @Test
    public void testHasPrefix(){
        String existantId = IdFactory.ID_PREFIX_TREE;
        String nonExistantId = "fhhhjsaywshjbhjcj";
        List<String> prefixes = Arrays.asList(IdFactory.ID_PREFIXES);
        if(!prefixes.contains(existantId)){
            fail(IdFactory.class.getName().concat(".ID_PREFIXES should contain prefix ").concat(existantId));
        }
        if(prefixes.contains(nonExistantId)){
            fail(IdFactory.class.getName().concat(".ID_PREFIXES should not contain prefix ").concat(existantId));
        }
        if(!IdFactory.hasIdPrefix(existantId)){
            fail(IdFactory.class.getName().concat(".hasIdPrefix should return true for prefix ").concat(existantId));
        }
        if(IdFactory.hasIdPrefix(nonExistantId)){
            fail(IdFactory.class.getName().concat(".hasIdPrefix should return false for prefix ").concat(existantId));
        }
    }
    @Test
    public void testNextIdWithNonexistentPrefix(){

        String prefix = "aa";
        try{
            if(IdFactory.hasIdPrefix(prefix)){
                fail(prefix+" exists in "+IdFactory.class.getName()+".ID_PREFIXES");
            }
            IdFactory.nextId(prefix);
        }catch(IllegalArgumentException e){

        }catch(Exception e){
            fail("unhandled exception caught - prefix: ".concat(prefix), e);
        }
    }
    @Test
    public void testNextIdWithExistentPrefix(){
        String prefix = IdFactory.ID_PREFIX_TREE;
        try{
            if(!IdFactory.hasIdPrefix(prefix)){
                fail(prefix+" does not exist in "+IdFactory.class.getName()+".ID_PREFIXES");
            }
            IdFactory.nextId(prefix);
        }catch(IllegalArgumentException e){
            fail(e.getMessage().concat("\nprefix: ").concat(prefix));
        }catch(Exception e){
            fail("unhandled exception caught:", e);
        }
    }
}
