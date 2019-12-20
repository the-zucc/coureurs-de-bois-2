package util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class IdFactory {
    public final static String ID_PREFIX_TREE = "tree";
    public final static String ID_PREFIX_HUMAN = "human";
    public final static String[] ID_PREFIXES = {ID_PREFIX_HUMAN, ID_PREFIX_TREE};
    public static final String ID_PREFIX_MAP = "map";
    private final static Map<String, Pattern> prefixPatterns = initPrefixPatterns();

    private static Map<String, Pattern> initPrefixPatterns() {
        HashMap<String, Pattern> returnVal = new HashMap();
        for (String prefix :
                ID_PREFIXES) {
            returnVal.put(prefix,Pattern.compile(prefix));
        }
        return returnVal;
    }

    public static boolean hasIdPrefix(String prefix) {
        return prefixPatterns.containsKey(prefix);
    }

    public Pattern getIdPrefixPattern(String prefix){
        if(prefixPatterns.containsKey(prefix)){
            return prefixPatterns.get(prefix);
        }
        return null;
    }
    private static int currId = 0;
    public static String nextId(String prefix){
        if(prefixPatterns.containsKey(prefix)){
            return prefix+"_"+currId++;
        }
        throw new IllegalArgumentException("ID prefix "+prefix+" does not exist");
    }
}
