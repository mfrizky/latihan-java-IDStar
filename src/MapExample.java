import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String,Integer> ageOfFriends = new HashMap<>(Map.of("Mualim",27,"Andi",27,"Budi",23));
        for (Map.Entry<String,Integer> value: ageOfFriends.entrySet()){
            String name = value.getKey();
            int age = value.getValue();
            System.out.printf("name: %s, value: %d%n",name,age);
        }
    }
}
