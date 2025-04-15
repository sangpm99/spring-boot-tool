package tool.project.hellper;

public class formatter {
    public static String toSlug(String input) {
        if (input == null) {
            return "";
        }

        // 1. Chuyển thành chữ thường
        String slug = input.toLowerCase();

        // 2. Loại bỏ ký tự không phải chữ cái, số, hoặc khoảng trắng
        slug = slug.replaceAll("[^a-z0-9\\s]", "");

        // 3. Thay thế khoảng trắng (một hoặc nhiều) bằng dấu gạch ngang
        slug = slug.replaceAll("\\s+", "-");

        // 4. Xoá dấu gạch ngang ở đầu hoặc cuối (nếu có)
        slug = slug.replaceAll("^-+|-+$", "");

        return slug;
    }
}
