package test;

public class test {
	 public static void main(String[] args)    
	    {  
		    int k = lengthOfLongestSubstring("bziuwnklhqzrxnb");
	        System.out.println(k);   
	        return;
	    }  
	 public static int lengthOfLongestSubstring(String s) {
	        if(s.length() == 1)
	            return 1;
//	        if(s.length() == 0)
//	        	return 0;
	        int mid = (s.length() - 1) / 2;
	        //return mid;
	        String s1 = s.substring(0, mid + 1);
//	        if(mid + 1 > s.length() - 1){
//	        	int k = 0;
//	        	k = 2;
//	        }
	           
	        String s2 = s.substring(mid + 1);
	        int left_length = lengthOfLongestSubstring(s1);
	        int right_length = lengthOfLongestSubstring(s2);
	        int cross_length = findLongestCrossMid(s);
	        
	        int longestLength = left_length > right_length ?  left_length : right_length;
	        longestLength = longestLength > cross_length ?  longestLength : cross_length;
	        
	        return longestLength;
	    }
	    
	    public static int findLongestCrossMid(String s){
	    	if(s == "bziuwnklhqzrxnb"){
	    		int k = 0;
	    		k =2;
	    	}
	    	if(s.length() == 1)
	    		return 1;
	        String leftStr = "";
	        String rightStr = "";
	        int mid = (s.length() - 1) / 2;
	        for(int i = mid; i >= 0; i--){
	            //leftStr = s.substr(i, mid);
	            String temp = s.charAt(i) + "";
	            if(leftStr.indexOf(temp) == -1)
	                leftStr = s.substring(i, mid + 1);
	            else
	            	break;
	        }
	        
	        for(int i = mid + 1; i < s.length(); i++){
	            String temp = s.charAt(i) + "";
	            if(rightStr.indexOf(temp) == -1)
	                rightStr = s.substring(mid+1, i + 1);
	            else
	            	break;
	        }
	        int left_length = 0, right_length = 0;
	        for(int i = leftStr.length()-1; i >= 0; i--){
	            String temp = leftStr.charAt(i) + "";
	            if(rightStr.indexOf(temp) != -1){
	            	break;
	            }
	            left_length = leftStr.length() - i;
	        }
	        for(int i = 0; i < rightStr.length(); i++){
	            String temp = rightStr.charAt(i) + "";
	            if(leftStr.indexOf(temp) != -1){
	            	break;
	            }
	            right_length = i + 1;
	        }
	        int result = left_length+rightStr.length() > right_length + leftStr.length() ? left_length+rightStr.length() : right_length + leftStr.length();
	        return result;
	    }
}
