package az.iktlab.exceptions;

public class OperationNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return "Operation not found, Please try again!\n*************************************************";
    }

}
