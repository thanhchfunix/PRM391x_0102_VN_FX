package funix.prm.prm391x_shopmovies_thanhchfx01399;

// class movie of recycle view
public class Movie {
    String title;
    String image;
    String price;

    public Movie(String title, String image, String price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
