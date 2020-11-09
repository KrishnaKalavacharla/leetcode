class ReverseSubStringsWithinParantheses{
    Stack<Character> stack=  new Stack();

    public String reverseParentheses(String s) {
        if(s==null || s.length()==0) return s;

        for(char c:s.toCharArray()){
            if(c!=')'){
                stack.push(c);
            }else{
                reverse();
            }
        }

        return buildResult();

    }

    private void reverse(){
        List<Character> list = new ArrayList();
        while(!stack.isEmpty() && stack.peek()!='('){
            list.add(stack.pop());
        }

        stack.pop();//removes the (

        //add back to stack

        while(!list.isEmpty()){
            stack.push(list.remove(0));
        }
    }

    private String buildResult(){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());

        }

        return sb.reverse().toString();
    }
}
