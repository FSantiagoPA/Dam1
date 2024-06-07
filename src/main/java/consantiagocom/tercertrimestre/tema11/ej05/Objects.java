package consantiagocom.tercertrimestre.tema11.ej05;

public class Objects {
    public enum Stack{
        A(1),B(16),C(32),D(64);
        private final int value;

        Stack(int i) {
            value = i;
        }
        public int getValue(){return  value;}}

    private String objectName;

    private Stack stack;

    public String getObjectName() {
        return objectName;
    }

    public Stack getStack() {
        return stack;
    }

    public Objects(String objectName, Stack stack) {
        this.objectName = objectName;
        this.stack = stack;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        if(stack.getValue() ==0 || getObjectName().isEmpty()){
            return "Objects{"
                    ;
        }
        else if(stack.getValue()==1){
            return  objectName;
        }else
            return  objectName + '\'' + stack.value
                    ;
    }
}
