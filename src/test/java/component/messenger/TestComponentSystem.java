package component.messenger;

import org.junit.jupiter.api.Test;
import util.IdFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestComponentSystem {
    @Test
    public void testUpdateChildren(){
        TestParentComponent tpc = new TestParentComponent(
                IdFactory.nextId(IdFactory.ID_PREFIX_TREE),
                null
        );
        int testChildrenCount = 5;
        for (int i = 0; i < testChildrenCount; i++) {
            String id = IdFactory.nextId(IdFactory.ID_PREFIX_TREE);
            tpc.addChild(id, new TestParentComponent(id, tpc));
        }
        tpc.update(0);
        int expectedCount = testChildrenCount+1;
        assertEquals(expectedCount,tpc.getTestCount(),"test_count should be ="+expectedCount);
        tpc.update(0);
        expectedCount = testChildrenCount*2+testChildrenCount+2;
        assertEquals(expectedCount,tpc.getTestCount(),"test_count should be ="+expectedCount);
    }
}
