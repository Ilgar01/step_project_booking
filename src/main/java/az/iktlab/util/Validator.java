package az.iktlab.util;

import az.iktlab.enums.Operation;

import java.util.function.BiPredicate;

public class Validator {

    public static BiPredicate<String,Operation> haveOperation = (inputOperation, operation) ->
            inputOperation.trim().equalsIgnoreCase(operation.name()) ||
            inputOperation.trim().equalsIgnoreCase(operation.getShortName());

    public static boolean isOperation(String operation){
        boolean bool = false;

        for (Operation input : Operation.values()){
            if (operation.trim().equalsIgnoreCase(input.name()) ||
                    operation.trim().equalsIgnoreCase(input.getShortName()) ) {
                bool = true;
                break;
            }
        }
        return !bool;
    }
}
