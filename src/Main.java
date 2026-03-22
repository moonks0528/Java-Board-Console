import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardService service = new BoardService();

        while (true) {
            System.out.println("\n===== 게시판 =====");
            System.out.println("1. 글 작성");
            System.out.println("2. 글 목록");
            System.out.println("3. 글 조회");
            System.out.println("4. 글 수정");
            System.out.println("5. 글 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");

            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                System.out.print("제목: ");
                String title = sc.nextLine();

                System.out.print("내용: ");
                String content = sc.nextLine();

                System.out.print("작성자: ");
                String writer = sc.nextLine();

                service.addBoard(title, content, writer);
                System.out.println("게시글 작성 완료");

            } else if (menu == 2) {
                service.showBoardList();

            } else if (menu == 3) {
                System.out.print("조회할 글 번호: ");
                int id = Integer.parseInt(sc.nextLine());

                Board board = service.findBoardById(id);
                if (board != null) {
                    System.out.println("번호: " + board.id);
                    System.out.println("제목: " + board.title);
                    System.out.println("내용: " + board.content);
                    System.out.println("작성자: " + board.writer);
                } else {
                    System.out.println("해당 게시글이 없습니다.");
                }

            } else if (menu == 4) {
                System.out.print("수정할 글 번호: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("새 제목: ");
                String title = sc.nextLine();

                System.out.print("새 내용: ");
                String content = sc.nextLine();

                service.updateBoard(id, title, content);

            } else if (menu == 5) {
                System.out.print("삭제할 글 번호: ");
                int id = Integer.parseInt(sc.nextLine());

                service.deleteBoard(id);

            } else if (menu == 0) {
                System.out.println("프로그램 종료");
                break;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}