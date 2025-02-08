import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;


class validParenttheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (brackets.containsKey(current)){
                stack.push(current);
            }else{
                if (stack.isEmpty() || brackets.get(stack.pop()) != current) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}

class SquareRoot{
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        if(x == 0 || x == 1 || x < 0){
            return x;
        }
        while(left <= right){
            int middle = left + (right - left) / 2;
            long square = (long) middle * middle;
            if(square < x){
                left = middle + 1;
            }else if(square > x){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return right;
    }
}

class MergeTwoArrays {
    public void Leetmerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                --i;
            }else{
                nums1[k] = nums2[j];
                --j;
            }
            --k;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            --j;
            --k;
        }
    }

    public int[] merge(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 1; j < arr1.length; j++) {
                if(arr1[j] < arr1[j - 1]){
                    int temp = arr1[j];
                    arr1[j] = arr1[j - 1];
                    arr1[j - 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if(arr2[j] < arr2[j - 1]){
                    int temp = arr2[j];
                    arr2[j] = arr2[j - 1];
                    arr2[j - 1] = temp;
                }
            }
        }
        
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, k = 0;

        int[] merged = new int[n + m];

        while(i < m && j < n){
            if(arr1[i] <= arr2[j]){
                merged[k++] = arr1[i++];
            }else{
                merged[k++] = arr2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = arr1[i++];
        }

        while (j < n) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }
}

class SingleNumber{
    public int singleNumber(int[] nums) {
        /*HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])){
                seen.put(nums[i], seen.get(nums[i]) + 1);
            }else{
                seen.put(nums[i], 1);
            }
        }
        for (int i : nums) {
            if(seen.get(i) == 1){
                return i;
            }
        }
        
        return -1;*/

        /*
         int xor = 0;
         for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
         }
        return xor;
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i = i +2) {
            if(nums[i] == nums[i + 1]){
                continue;
            }else{
                if(nums[i+1] == nums[i + 2]){
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];

    }
}

class Majority {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }else{
                freq.put(nums[i], 1);
            }
        }
        System.out.println(freq);
        int maxValueInMap = 0;
        for(int i : freq.values()){
            if(maxValueInMap < i){
                maxValueInMap = i;
            }
        }
        
        for(int i : freq.keySet()){
            if(freq.get(i) == maxValueInMap){
                return i;
            }
        }

        return -1;
    }
}

class ColumnToNumber {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        // for (int i = len; i > 0; --i) {
        //     int to_power = map.get(columnTitle.charAt(len-i));
        //     result += to_power * (Math.pow(26, i - 1));
        // }
        int result1 = 0;
        for (int i = 0; i < len; i++) {
            int to_power = columnTitle.charAt(i) - 'A' + 1;
            result1 = result1 * 26 + to_power;
        }
        return result1;
        
    }
}

class ColumnTitle{
    public String toColumnTitle(int num){
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.put(4, 'D');
        map.put(5, 'E');
        map.put(6, 'F');
        map.put(7, 'G');
        map.put(8, 'H');
        map.put(9, 'I');
        map.put(10, 'J');
        map.put(11, 'K');
        map.put(12, 'L');
        map.put(13, 'M');
        map.put(14, 'N');
        map.put(15, 'O');
        map.put(16, 'P');
        map.put(17, 'Q');
        map.put(18, 'R');
        map.put(19, 'S');
        map.put(20, 'T');
        map.put(21, 'U');
        map.put(22, 'V');
        map.put(23, 'W');
        map.put(24, 'X');
        map.put(25, 'Y');
        map.put(26, 'Z');

        String result = "";
        Stack<Integer> stack = new Stack<>();
        while(num > 0){
            if(num % 26 == 0){
                stack.push(26);
                num -= 1;
            }else{
                stack.push(num % 26);
            }
            num /= 26;
        }

        System.out.println(stack.toString());
        while(!stack.empty()){
            Character ch = map.get(stack.pop());
            result += ch;
        }
        
        return result;
    }
}



class MergeTwoLinkedLists {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = null;
        ListNode current = null;

        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        if(list1 == null && list2 == null){
            return null;
        }

        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        current = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }


        if(list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        
        return head;  
    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Duplicates {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode result = new ListNode();
        ListNode current = head;
        while(current != null){
            if(map.containsKey(current.val)){
                map.put(current.val, map.get(current.val) + 1);
                result.next = current;
            }else{
                map.put(current.val, 1);
            }
            current = current.next;
        }
        System.out.println(map);
        
        return result;

    }
}

public class Leetcode {
    public static void main(String[] args) {

        Duplicates sol = new Duplicates();
        ListNode lst1 = new ListNode(1);
        lst1.next = new ListNode(1);
        lst1.next.next = new ListNode(2);
        ListNode result = sol.deleteDuplicates(lst1);

        while(result != null){
            System.out.print(result.val);
            if(result.next != null){
                System.out.print("->");
            }
            result = result.next;
        }
        

        /*MergeTwoLinkedLists ml = new MergeTwoLinkedLists();
        ListNode lst1 = new ListNode(1);
        lst1.next = new ListNode(2);
        lst1.next.next = new ListNode(4);
        ListNode lst2 = new ListNode(1);
        lst2.next = new ListNode(3);
        lst2.next.next = new ListNode(4);

        ListNode merged = ml.mergeTwoLists(lst1, lst2);
        while(merged != null){
            System.out.print(merged.val);
            if(merged.next != null){
                System.out.print("->");
            }
            merged = merged.next;
        }*/

        // validParenttheses vp = new validParenttheses();
        // String str = "()";
        // System.out.println(vp.isValid(str));

        // SquareRoot sqrt = new SquareRoot();
        // System.out.println(sqrt.mySqrt(69));

        /*MergeTwoArrays mg = new MergeTwoArrays();
        int[] arr1 = {4,4,1,532,10,53,12,5,7};
        int[] arr2 = {2,7,8,5,6};*/
        //mg.Leetmerge(arr1, 3, arr2, 3);
        // for(int i : arr1){
        //     System.out.print(i + " ");
        // }
        // System.out.println(Arrays.toString(mg.merge(arr1, arr2)));
        
        // SingleNumber sn = new SingleNumber();
        // int[]nums = {1,1,2,2,4,3,3};

        // System.out.println(sn.singleNumber(nums));

        // Majority mj = new Majority();
        // int[] nums = {2,2,1,1,1,2,2};
        // System.out.println(mj.majorityElement(nums));


         /*ColumnToNumber cn = new ColumnToNumber();
        System.out.println(cn.titleToNumber("AZ"));
        
        ColumnTitle cl = new ColumnTitle();
        System.out.println(cl.toColumnTitle(52));*/
    }

}
