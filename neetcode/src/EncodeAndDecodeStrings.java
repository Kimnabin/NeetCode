import java.util.*;

public class EncodeAndDecodeStrings {
    // Encode: list<String> -> String
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length().append('#')).append(s);
        }
        return sb.toString();
    }


    // Decode: String -> list<String>
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf('#', i);
            if (j == -1) break; // Không tìm thấy dấu '#', kết thúc quá trình giải mã

            int length = Integer.parseInt(s.substring(i, j)); // Lấy độ dài của chuỗi
            i = j + 1; // Di chuyển chỉ số i đến vị trí sau dấu '#'

            String str = s.substring(i, i + length); // Lấy chuỗi theo độ dài đã cho
            result.add(str); // Thêm chuỗi vào danh sách kết quả

            i += length; // Di chuyển chỉ số i đến cuối chuỗi hiện tại
        }
        return result; // Trả về danh sách các chuỗi đã giải mã
    }
}

public static void main(String[] args) {
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();

        List<String> originalList = Arrays.asList("hello", "world", "this", "is", "a", "test");
        String encodedString = codec.encode(originalList);
        System.out.println("Encoded: " + encodedString);

        List<String> decodedList = codec.decode(encodedString);
        System.out.println("Decoded: " + decodedList);
    }
}