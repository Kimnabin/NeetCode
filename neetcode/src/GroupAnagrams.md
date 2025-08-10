Ok, mình sẽ tóm tắt và đưa ra cách **tối ưu nhất** cho bài **Group Anagrams** bằng Java, kèm phân tích chi tiết.

---

## 🔹 Đề bài

Cho một mảng chuỗi `strs`, hãy nhóm các chuỗi là **anagram** của nhau lại.
**Anagram**: Hai từ là anagram nếu chúng chứa cùng ký tự với cùng số lần xuất hiện, nhưng có thể khác thứ tự.

**Ví dụ**:

```java
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [
  ["eat","tea","ate"],
  ["tan","nat"],
  ["bat"]
]
```

---

## 🧠 Ý tưởng giải

1. **Quan sát**:
   Nếu hai từ là anagram → khi sắp xếp ký tự trong từ đó, ta sẽ được chuỗi giống hệt nhau.
   Ví dụ: `"eat"` → `"aet"`, `"tea"` → `"aet"`.

2. **Cách làm**:

    * Duyệt từng chuỗi trong `strs`.
    * Chuyển thành mảng ký tự, sắp xếp, rồi chuyển lại thành `String` → đây là **key**.
    * Dùng `HashMap<String, List<String>>` để lưu:

        * **key**: chuỗi đã sắp xếp
        * **value**: danh sách các từ anagram tương ứng.

3. **Kết quả**: Lấy tất cả `value` trong map làm kết quả.

---

## ⏱️ Độ phức tạp

* Thời gian: **O(n × k log k)**

    * `n`: số chuỗi
    * `k`: độ dài trung bình mỗi chuỗi (do cần sắp xếp)
* Không gian: **O(n × k)** để lưu kết quả.

---

## 💻 Code Java

```java
import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // sắp xếp ký tự
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
```

---

## 📌 Output khi chạy:

```
[eat, tea, ate]
[tan, nat]
[bat]
```

---

Nếu bạn muốn **tối ưu hơn nữa** (O(n × k)) thay vì O(n × k log k), mình có thể viết bản **dùng mảng đếm ký tự (char count)** để tránh sắp xếp từng từ.
Bạn có muốn mình làm bản **tối ưu O(n × k)** đó không?
