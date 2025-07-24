import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // gặp trùng
            }
            seen.add(num);
        }
        return false; // không trùng
    }

    public static boolean containsDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;    // gặp trùng
                }
            }
        }
        return false;   // không trùng
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(containsDuplicate(nums1)); // true
        System.out.println(containsDuplicate(nums2)); // false

        System.out.println(containsDuplicate2(nums1)); // true
        System.out.println(containsDuplicate2(nums2)); // false
    }
}
