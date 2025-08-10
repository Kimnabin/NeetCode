import java.util.*;

class Sulution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // Bảng băm để lưu nhóm anagram

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // Sắp xếp các ký tự trong chuỗi
            String key = new String(chars); // Tạo khóa từ chuỗi đã sắp xếp

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // Thêm chuỗi vào danh sách tương ứng với khóa
        }

        return new ArrayList<>(map.values()); // Trả về danh sách các nhóm anagram
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group); // In ra từng nhóm anagram
        }
    }
}