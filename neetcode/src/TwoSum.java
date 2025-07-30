/**✅ Yêu cầu bài toán:
Input: nums là mảng các số nguyên, target là một số nguyên.

Yêu cầu: Tìm hai chỉ số i và j sao cho nums[i] + nums[j] == target và i != j.

Trả về [i, j] sao cho i < j.

 🧠 Ý tưởng tối ưu nhất (Dùng Hash Map - Bảng băm):
 Ta sẽ duyệt qua mảng một lần và lưu các phần tử đã thấy vào trong bảng băm, với:

 Key: giá trị của phần tử

 Value: chỉ số của phần tử

 Tại mỗi phần tử nums[i], ta tính cần_tìm = target - nums[i] và kiểm tra xem cần_tìm đã từng xuất hiện chưa (trong map):

 Nếu có, ta đã tìm được cặp thỏa mãn, trả về [map[cần_tìm], i] (đảm bảo map[cần_tìm] < i)

 Nếu không, thêm nums[i]: i vào map.
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();    // Bảng băm để lưu giá trị và chỉ số
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // số cần tìm để cộng với nums[i] ra target
            if (map.containsKey(complement)) {
                int j = map.get(complement);    // Lấy chỉ số của phần tử complement từ bảng băm
                return new int[] {
                        Math.min(i, j), Math.max(i, j)  // dam bảo i < j
                };
            }
            map.put(nums[i], i); // Lưu giá trị và chỉ số vào bảng băm
        }
        throw new IllegalArgumentException("No two sum solution found"); // Nếu không tìm thấy, ném ngoại lệ
    }
}
public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] result = TwoSum.twoSum(nums, target);
    System.out.println("Indices: [" + result[0] + ", " + result[1] + "]"); // Output: Indices: [0, 1]
}