HashMap là một **cấu trúc dữ liệu dạng ánh xạ (map)** dùng để lưu trữ các cặp **key – value**.
Bạn có thể hình dung nó giống như một “từ điển” — mỗi **key** là duy nhất và được ánh xạ đến một **value** tương ứng.

---

## 1. Đặc điểm của HashMap

* **Lưu trữ dưới dạng cặp**: `(key, value)`
* **Key là duy nhất** – nếu thêm key đã tồn tại, giá trị cũ sẽ bị ghi đè.
* **Tìm kiếm / chèn / xóa rất nhanh** – trung bình **O(1)** (nhờ cơ chế *hashing*).
* **Cho phép giá trị (value) trùng nhau**, nhưng **key thì không**.
* Không đảm bảo thứ tự các phần tử (khác với TreeMap).

---

## 2. Cách hoạt động

1. Khi bạn đưa vào một `key`, HashMap sẽ dùng **hàm băm (hash function)** để chuyển key thành một **hash code**.
2. Hash code này dùng để xác định **vị trí lưu trữ** trong mảng bên trong HashMap.
3. Khi cần tìm lại value, chỉ cần băm key lần nữa → tìm vị trí → lấy ra value.

---

## 3. Ví dụ minh họa (Java)

```java
import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Thêm phần tử
        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Orange", 2);

        // Lấy giá trị qua key
        System.out.println(map.get("Banana")); // 5

        // Ghi đè value nếu key đã tồn tại
        map.put("Apple", 10);

        // Duyệt qua HashMap
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
```

---
