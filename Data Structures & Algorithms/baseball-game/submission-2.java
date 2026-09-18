class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> stack = new Stack <> ();

        for (String operation:operations) {
            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                stack.push(stack.peek()*2);
            } else if (operation.equals("+")) {
                int last = stack.get(stack.size()-1);
                int second_last = stack.get(stack.size()-2);
                stack.push (last+second_last);
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        Iterator <Integer> value = stack.iterator ();
        int total = 0;
        while (value.hasNext()) {
            total = total+value.next();
        }
        return total;
    }
}