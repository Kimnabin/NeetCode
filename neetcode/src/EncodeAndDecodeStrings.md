
---

## 📌 Đề bài

Viết 2 hàm:

* `encode(List<String> strs)`: chuyển danh sách chuỗi thành 1 chuỗi duy nhất.
* `decode(String s)`: khôi phục lại danh sách chuỗi ban đầu từ chuỗi đã mã hóa.

**Yêu cầu**:

* Phải có cách để biết độ dài từng chuỗi ban đầu (tránh lỗi khi chuỗi chứa ký tự đặc biệt như `#`, `,`, hoặc khoảng trắng).
* Không được mất dữ liệu.

---

## 🧠 Ý tưởng giải

### Cách phổ biến: **Prefix Length Encoding**

1. Khi encode, với mỗi chuỗi:

    * Lấy **độ dài** của chuỗi.
    * Ghép: `"độ_dài#chuỗi"`.
2. Nối tất cả lại thành một chuỗi lớn.
3. Khi decode:

    * Đọc độ dài trước dấu `#`.
    * Cắt đúng số ký tự tiếp theo thành một chuỗi ban đầu.
    * Lặp lại cho đến hết.

---

## ⏱️ Độ phức tạp

* **Thời gian**: O(N) cho cả encode và decode (N = tổng số ký tự).
* **Không gian**: O(N).

---

## 💻 Code Java

```java
import java.util.*;

public class Codec {
    // Encode: list<String> -> String
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode: String -> list<String>
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Tìm dấu #
            int delimiter = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, delimiter));
            i = delimiter + 1; // bỏ qua '#'
            result.add(s.substring(i, i + length));
            i += length;
        }
        return result;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> input = Arrays.asList("hello", "world", "#test#", "java is fun");
        String encoded = codec.encode(input);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
```
