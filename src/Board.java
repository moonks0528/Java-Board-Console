import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Board {
    int id;
    String title;
    String content;
    String writer;
    int viewCount;
    String createdAt;

    public Board(int id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.viewCount = 0;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.createdAt = LocalDateTime.now().format(formatter);
    }
}