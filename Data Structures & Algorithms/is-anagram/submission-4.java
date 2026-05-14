class Solution {
    public boolean isAnagram(String s, String t) {
        //We are going to use the anagram principles
        //We first check the recurrence of characters 
        //first check is on the length 
        if (s.length ()!=t.length ()) 
            return false;
        
        int [] count = new int [26]; //use this to store the frequency of characters

        for (int i=0; i<s.length (); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int num:count) {
            if (num!=0)
                return false;
        }
        return true;
    }
}
