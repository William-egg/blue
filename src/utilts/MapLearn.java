package utilts;

import java.util.HashMap;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            System.out.println(e);
        }
    }
}
