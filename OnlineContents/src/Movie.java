public class Movie extends Content implements Purchasable, Rentable{
    int runningTime;

    public Movie(String title, int price, int runningTime){
        super(title, price);
        this.runningTime = runningTime;
    }

    @Override
    public void buy(){
        System.out.println("[Movie] " + title + " 구매 완료");
    }

    @Override
    public void rent(){
        System.out.println("[Movie] " + title + " 대여 완료");
    }

    @Override
    public void extendRent(){
        System.out.println("대여 기간 연장 완료");
    }

    @Override
    public void showInfo(){
        System.out.println("[Movie] Title: " + title + " /" + " Price: " + price + " /" + " Running Time:" + runningTime);
    }
}
