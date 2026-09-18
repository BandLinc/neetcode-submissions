class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> stack = new Stack <> ();

        for (String operation:operations) {
            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                stack.push(stack.peek()*2);
            } else if (operation.equals("+")) {
                int last = stack.pop();
                int new_last = last + stack.peek();
                stack.push (last);
                stack.push (new_last);
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