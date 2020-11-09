class DecodeString{

    Stack<Character> stack = new Stack();
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!=']'){
                stack.push(c);
            }else{
                decode();
            }
        }

        return buildString();
    }

    private void decode(){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peek()!='['){
            sb.append(stack.pop());
        }

        stack.pop();// remove the [

        String s = sb.toString();

        int multiplier = getMultiplier();

        for(int i = 0; i<multiplier-1; i++){
            sb.append(s);
        }

        s = sb.toString();

        for(int i= s.length()-1; i>=0;i--){
            stack.push(s.charAt(i));
        }

    }

    private int getMultiplier(){
        int base = 1;
        int result = 0;
        while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
            int charValue = Character.getNumericValue(stack.pop());
            result += base*charValue;
            base *= 10;
        }


        return result==0?1:result;
    }

    private String buildString(){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }


}
