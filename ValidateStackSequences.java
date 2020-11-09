class ValidateStackSequences{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 && popped.length == 0) return true;

        if(pushed.length != popped.length) return false;

        int pop = 0;
        for(int push: pushed){
            if(!stack.isEmpty() && popped[pop] == stack.peek()){
                stack.pop();
                pop++;
            }
            stack.push(push);

        }

        while(!stack.isEmpty()){
            if(popped[pop] ! = stack.pop()) return false;
            pop++;
        }

        return true;



    }
}
