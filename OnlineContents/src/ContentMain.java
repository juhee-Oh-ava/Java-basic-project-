import java.util.ArrayList;

public class ContentMain {
    public static void main(String[] args) {
        ArrayList<Content> contents = new ArrayList<>();

        contents.add(new Book("해리포터", 12000, "J.K. Rowling"));
        contents.add(new Movie("인셉션", 15000, 148));
        contents.add(new Music("Dynamite", 2000, "BTS"));

        for(Content c : contents){
            c.showInfo();
        }

        for(Content c : contents){
            if(c instanceof Purchasable) {
                ((Purchasable)c).buy();
            }
            if(c instanceof Rentable) {
                ((Rentable)c).rent();
                ((Rentable)c).extendRent();
            }
        }



    }
}
