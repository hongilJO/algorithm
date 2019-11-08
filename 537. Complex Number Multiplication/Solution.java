class Solution {
    
    public int[] splitWord(String word){
        
        String[] string_numbers=word.split("\\+");
        int[] numbers=new int[2];
        numbers[0]=Integer.parseInt(string_numbers[0]);             numbers[1]=Integer.parseInt(string_numbers[1].substring(0,string_numbers[1].length()-1));
        
        return numbers;
    }
    public String complexNumberMultiply(String a, String b) {
        int[] front=splitWord(a);
        int[] rear=splitWord(b);
        
        int natural=(front[0]*rear[0])+(front[1]*rear[1]*-1);
        int complex=front[0]*rear[1]+front[1]*rear[0];
        String result=natural+"+"+complex+"i";
        
        return result;
    }
}