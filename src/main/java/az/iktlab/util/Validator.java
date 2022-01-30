package az.iktlab.util;

import az.iktlab.enums.Operation;

public class Validator {

    public static boolean isOperation(String operation){
        boolean bool = false;

        for (Operation input : Operation.values()){
            if (operation.trim().equalsIgnoreCase(input.name())) {
                bool = true;
                break;
            }
        }
        return !bool;
    }
}
