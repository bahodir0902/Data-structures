import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.Arrays;

class Roman {
    public int romanToInt(String str) {
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        int result = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            int current = roman.get(String.valueOf(str.charAt(i)));
            int next = roman.get(String.valueOf(str.charAt(i + 1)));

            // If the current Roman numeral is less than the next one, subtract its value
            if (current < next) {
                result -= current;
            } else {
                // Otherwise, add its value
                result += current;
            }
        }

        // Add the value of the last Roman numeral
        result += roman.get(String.valueOf(str.charAt(str.length() - 1)));
        return result;
    }
}

class longestPrefix{
    public String findlongestPrefix(String[] arr){
        if(arr.length == 0){
            return "";
        }
        String base = arr[0];
        for (int i = 0; i < base.length(); ++i) {
            for (int j = 1; j < arr.length; ++j) {
                if(i >= arr[j].length() || base.charAt(i) != arr[j].charAt(i)){
                    return base.substring(0, i);
                }
            }
        }
        return base;

    }
}


class validParenttheses {
    public boolean isValid(String s) {
       HashMap<Character, Character> brackets = new HashMap<>();
       brackets.put('(', ')');
       brackets.put('[', ']');
       brackets.put('{', '}');

       Stack<Character> stack = new Stack<>();

       for (int i = 0; i < s.length(); i++) {
            Character current_char = s.charAt(i);
            if(brackets.containsKey(current_char)){
                stack.push(current_char);
            }else if(stack.isEmpty() || brackets.get(stack.pop()) != current_char){
                return false;
            }
       }
       return stack.isEmpty();

    }
}

class firstOccurenceInStr{
    public int strStr(String haystack, String needle){
        if (haystack.length() == 0){
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            if ((haystack.substring(i, i + needle.length())).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}

class Search{
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            }
        }
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }

        return nums.length;
    }
}

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;

        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        while (i >= 0 && s.charAt(i) != ' '){
            ++len;
            --i;
        }

        return len;
    }
}

class LargeInteger {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; --i) {
            if(digits[i] < 9){
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[len + 1];
        result[0] = 1;

        return result;
        
    }
    
    // public int[] plusOne(int[] digits) {
    //     String nums = "";
    //     int len = digits.length;
    //     int i = 0;

    //     while(i < len){
    //         if(digits[i] != ','){
    //             nums += digits[i];
    //             i++;
    //             continue;
    //         }else{
    //             ++i;
    //         }
    //     }
    //     int int_num = Integer.parseInt(nums);
    //     int result_int = int_num + 1;
    //     String result_str = Integer.toString(result_int);
    //     ArrayList<Character> results_digits = new ArrayList<>();
    //     for(int j = 0; j < nums.length(); ++j){
    //         results_digits.add(result_str.charAt(j));
    //     }

    //     int n = results_digits.size();
    //     int[] result_arr = new int[n];

    //     for(int j = 0; j < n; ++j){
    //         result_arr[j] = Character.getNumericValue(results_digits.get(j));
    //     }
    //     System.out.println();
    //     return result_arr;
    // }
}

class Binary{
    public int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(arr[middle] == target){
                result = middle;
            }else if(arr[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }

        return result;
    }

    public int LastOccurence(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(arr[middle] == target){
                result = middle;
                left = middle + 1;
            }else if(arr[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }

        return result;
    }

    public int FirstOccurence(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(arr[middle] == target){
                result = middle;
                left = middle - 1;
            }else if(arr[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }

        return result;
    }

    public int NumOfOccurences(int[] arr, int target){
        int first = this.FirstOccurence(arr, target);
        int last = this.LastOccurence(arr, target);

        if(first == -1 || last == 0){
            return 0;
        }

        int result = last - first;
        return result;
    }
}

class Sort{
    public int[] selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int small = arr[i];
            int location = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < small){
                    small = arr[j];
                    location = j;
                }
            }
            if(location != i){
                int temp = arr[i];
                arr[i] = small;
                arr[location] = temp;
            }
        }
        return arr;
    }

    public int findKthSmallestElement(int[] arr, int target){
        int n = arr.length;
        for (int i = 0; i < target; i++) {
            int small = arr[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < small){
                    small = arr[j];
                    index = j;
                }
            }
            if(index != i){
                int temp = arr[i];
                arr[i] = small;
                arr[index] = temp;
            }

        }
        //System.out.println(Arrays.toString(arr));
        return arr[target - 1];
    }

    public int[] bubbleSort(int[]arr){
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
}



public class Main {
    public static void main(String[] args) {
        Binary bin = new Binary();
        Random random = new Random();
        // int[] arr = new int[10000000];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = i;
        // }
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));


        int[] arr = {7, 10, 4, 3, 20, 15};

        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.selectionSort(arr)));
        System.out.println(Arrays.toString(sort.bubbleSort(arr)));
        System.out.println(sort.findKthSmallestElement(arr, 3));
        // System.out.println("\n");
        // System.out.println(bin.binarySearch(arr, 5));
        //System.out.println(bin.NumOfOccurences(arr, 5));
        


        // int[] digits = {1,2,3};
        // LargeInteger lg = new LargeInteger();
        // System.out.println(Arrays.toString(lg.plusOne(digits)));
        // Roman roman = new Roman();
        // System.out.println(roman.romanToInt("IV"));  // Outputs: 4

        // longestPrefix pr = new longestPrefix();
        // String[] arr = {"flower", "flow", "flight"};
        // System.out.println(pr.findlongestPrefix(arr));

        // validParenttheses vp = new validParenttheses();
        // String str = "()";
        // System.out.println(vp.isValid(str));

        // firstOccurenceInStr f = new firstOccurenceInStr();
        // System.out.println(f.strStr("sadbutsad", "sad"));
        // System.out.println(f.strStr("leetcode", "leeto"));


        // Search search = new Search();
        // int[] nums = { 1, 3, 5, 7, 9, 10 };
        // System.out.println(search.searchInsert(nums, 18));

        // LengthOfLastWord le = new LengthOfLastWord();
        // System.out.println(le.lengthOfLastWord("luffy is still joyboy"));
        
        
    }

}
