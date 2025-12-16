public class Book extends Content implements Purchasable, Rentable {
    String author;
    private boolean rented;

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

        if (rented == false){
            rented = true;
            System.out.println("[Book] " + title + " 대여 완료");
        } else{
            System.out.println("이미 대여 중입니다.");
        }
    }

    @Override
    public void extendRent(){
        if (rented == false){
            System.out.println("대여 중인 상품이 아닙니다.");
        } else {
            System.out.println("대여 기간 연장 완료");
        }
    }

    @Override
    public void showInfo(){
        System.out.println("[Book] Title: " + title + " /" + " Price: " + price + " /" + " Author: " + author);
    }

    @Override
    public void printDetail() {
        System.out.println("Author: " + author);
    }



}
