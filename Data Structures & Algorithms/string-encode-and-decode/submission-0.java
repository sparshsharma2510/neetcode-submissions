class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> decodedStrs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int strLength = 0;
            while(i < n && isNumber(str.charAt(i))){
                strLength = strLength*10 + ((int)(str.charAt(i)-'0'));
                i++;    
            }
            int strCounter = i+1;
            StringBuilder sb = new StringBuilder();
            while(strLength > 0){
                sb.append(str.charAt(strCounter));
                strCounter++;
                strLength--;
            }
            i = strCounter-1;
            decodedStrs.add(sb.toString());
        }

        return decodedStrs;
    }

    private boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }
}
