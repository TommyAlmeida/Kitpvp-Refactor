package eu.union.dev.ability;

import eu.union.dev.ability.impl.PyroAbility;
import eu.union.dev.kit.Ability;

import java.util.HashMap;
import java.util.Map;

public class AbilityManager {

    private static Map<String, Ability> abilityMap;

    static {
        abilityMap = new HashMap<>();

        BaseAbility pyroAbility = new PyroAbility();
        abilityMap.put(pyroAbility.getName(), pyroAbility);
    }

    public Ability getAbility(String name){
        return abilityMap.get(name);
    }
}
