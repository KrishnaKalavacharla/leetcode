class ReversePolishNotation{

    Stack<Integer> stack = new Stack();

    public int evalRPN(String[] tokens) {

        Set<String>operatorSet =  prepOperatorSet();

        for(int i = 0; i<tokens.length; i++){
            String latest = tokens[i];
            if(operatorSet.contains(latest)){
                calculate(latest);
            }else{
                stack.push(Integer.parseInt(latest));
            }
        }

        return stack.size()==1?stack.pop():Integer.MIN_VALUE;

    }

    private Set<String> prepOperatorSet(){
        Set<String> operatorSet = new HashSet();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");

        return operatorSet;
    }

    private void calculate(String operator){
        int second = stack.pop();
        int first = stack.pop();

        switch(operator){
            case "+":
                stack.push(first+second);
                break;
            case "-":
                stack.push(first-second);
                break;
            case "*":
                stack.push(first*second);
                break;
            case "/":
                stack.push(first/second);
                break;
        }


    }
}
