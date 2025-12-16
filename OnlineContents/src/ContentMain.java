import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContentMain {

    public static void main(String[] args) throws IOException {
        ArrayList<Content> contents = new ArrayList<>();

        contents.add(new Book("해리포터", 12000, "조앤롤링"));
        contents.add(new Movie("인셉션", 15000, 148));
        contents.add(new Music("Dynamite", 2000, "BTS"));

//        for(Content c : contents){
//            c.showInfo();
//        }
//
//        for(Content c : contents){
//            if(c instanceof Purchasable) {
//                ((Purchasable)c).buy();
//            }
//            if(c instanceof Rentable) {
//                ((Rentable)c).rent();
//                ((Rentable)c).extendRent();
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== 콘텐츠 목록 ===");

        for (Content c : contents){
            System.out.println("Title: " + c.getTitle() + " / Price: " + c.getPrice());
            c.printDetail();

        }

        System.out.println("=== 콘텐츠 추가 ===");
        System.out.println("1. Book");
        System.out.println("2. Movie");
        System.out.println("3. Music");
        System.out.println("0. 종료");
//        System.out.println("선택: " + ch);

        while(true) {
            try {
                int choose = Integer.parseInt(br.readLine());
                System.out.println("선택: " + choose);

                if (choose < 0 || choose > 3) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
                }
                if (choose == 1) {

                    System.out.println("제목: " + contents.get(0).getTitle());
                    System.out.println("가격: " + contents.get(0).getPrice());

                    Content c = contents.get(0);
                    if (c instanceof Book) {
                        Book book = (Book) c;
                        String author = book.author;
                        System.out.println("저자: " + author);
                    }
                }
                if (choose == 2) {

                    System.out.println("제목: " + contents.get(1).getTitle());
                    System.out.println("가격: " + contents.get(1).getPrice());

                    Content mo = contents.get(1);
                    if (mo instanceof Movie) {
                        Movie movie = (Movie) mo;
                        int runtime = movie.runningTime;
                        System.out.println("상영 시간(분): " + runtime);
                    }
                }
                if (choose == 3) {

                    System.out.println("제목: " + contents.get(2).getTitle());
                    System.out.println("가격: " + contents.get(2).getPrice());

                    Content mu = contents.get(2);
                    if (mu instanceof Music) {
                        Music music = (Music) mu;
                        String singer = music.singer;
                        System.out.println("아티스트: " + singer);
                    }
                }

                if (choose == 0) break;
//            System.out.println("선택: " + choose);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("=== 구매 / 대여 ===");
        System.out.println("1. Book");
        System.out.println("2. Movie");
        System.out.println("3. Music");
        System.out.println("0. 종료");


        while(true) {

            int choose = Integer.parseInt(br.readLine());
            System.out.println("선택: " + choose);

            if (choose == 0) break;

            Content selected = contents.get(choose - 1);

            System.out.println("제목 입력: " + selected.getTitle());
            System.out.println("1. 구매");
            System.out.println("2. 대여");
            System.out.println("3. 대여 기간 연장");

            int action = Integer.parseInt(br.readLine());
            System.out.println("선택: " + action);

            switch (action) {
                case 1: // 구매
                    if (selected instanceof Purchasable) {
                        ((Purchasable) selected).buy();
                    } else {
                        System.out.println("구매할 수 없는 콘텐츠입니다.");
                    }
                    break;

                case 2: // 대여
                    if (selected instanceof Rentable) {
                        ((Rentable) selected).rent();
                    } else {
                        System.out.println("대여할 수 없는 콘텐츠입니다.");
                    }
                    break;

                case 3: // 대여 기간 연장
                    if (selected instanceof Rentable) {
                        ((Rentable) selected).extendRent();
                    } else {
                        System.out.println("대여할 수 없는 콘텐츠입니다.");
                    }
                    break;

            }
        }



    }
        }