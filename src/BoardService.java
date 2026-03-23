import java.util.ArrayList;

public class BoardService {
    ArrayList<Board> boardList = new ArrayList<>();
    int nextId = 1;

    public void addBoard(String title, String content, String writer) {
        Board board = new Board(nextId, title, content, writer);
        boardList.add(board);
        nextId++;
    }

    public void showBoardList() {
        if (boardList.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }

        System.out.println("번호 | 제목 | 작성자 | 조회수 | 작성일");
        for (Board board : boardList) {
            System.out.println(
                    board.id + " | " +
                            board.title + " | " +
                            board.writer + " | " +
                            board.viewCount + " | " +
                            board.createdAt
            );
        }
    }

    public Board findBoardById(int id) {
        for (Board board : boardList) {
            if (board.id == id) {
                return board;
            }
        }
        return null;
    }

    public void deleteBoard(int id) {
        Board board = findBoardById(id);
        if (board != null) {
            boardList.remove(board);
            System.out.println("삭제 완료");
        } else {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }

    public void updateBoard(int id, String title, String content) {
        Board board = findBoardById(id);
        if (board != null) {
            board.title = title;
            board.content = content;
            System.out.println("수정 완료");
        } else {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }
}