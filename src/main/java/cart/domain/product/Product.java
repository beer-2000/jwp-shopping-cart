package cart.domain.product;

public class Product {

    private final Long id;
    private final ProductName name;
    private final ProductPrice price;
    private final ProductImageUrl imageUrl;

    private Product(Long id, ProductName name, ProductPrice price, ProductImageUrl imageUrl) {
        this.id = id;
        this.name = new ProductName(name);
        this.price = new ProductPrice(price);
        this.imageUrl = new ProductImageUrl(imageUrl);
    }

    public static Product create(Long id, String name, long price, String imageUrl) {
        return new Product(
                id,
                new ProductName(name),
                new ProductPrice(price),
                new ProductImageUrl(imageUrl));
    }

    public static Product createToSave(String name, long price, String imageUrl) {
        return create(null, name, price, imageUrl);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name.getName();
    }

    public long getPrice() {
        return price.getAmount();
    }

    public String getImageUrl() {
        return imageUrl.getUrl();
    }
}
