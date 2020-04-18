package chickengame;

import java.util.HashMap;
import java.util.Iterator;

public class chickenMain 
{
    public static void main(String [] arguments)
    {
        HashMap <String, Integer> warriorAttackSet = new HashMap<String, Integer>();
        warriorAttackSet.put("Heavy Sword Attack", 7);
        warriorAttackSet.put("Light Sword Attack", 4);
        warriorAttackSet.put("Infuriating KFC Slash", 11);
        warriorAttackSet.put("Pecking Order Slash", 6);
        
        System.out.println(warriorAttackSet);


        


        Iterator<String> itr = warriorAttackSet.keySet().iterator();
        while (itr.hasNext())
        {
            String key = itr.next();
            Integer damage = warriorAttackSet.get(key);
            
            System.out.println("Move Name: " + key + " | Damage is: " + damage);
        }

    }

}