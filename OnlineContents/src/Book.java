public class Book extends Content implements Purchasable, Rentable {
    String author;

    public Book(String title, int price, String author){
        super(title, price);
        this.author = author;
    }

    @Override
    public void buy(){
        System.out.println("[Book] " + title + " 구매 완료" );
    }

    @Override
    public void rent(){
        System.out.println("[Book] " + title + " 대여 완료");
    }

    @Override
    public void extendRent(){
        System.out.println("대여 기간 연장 완료");
    }

    @Override
    public void showInfo(){
        System.out.println("[Book] Title: " + title + " /" + " Price: " + price + " /" + " Author: " + author);
    }
}
