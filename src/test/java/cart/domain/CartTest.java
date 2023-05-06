package cart.domain;

import static org.assertj.core.api.Assertions.assertThat;

import cart.domain.product.Product;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CartTest {

    @DisplayName("상품을 1개 추가하면 장바구니의 상품 개수가 1개가 된다.")
    @Test
    void shouldProductsInCartHasSizeOfOneWhenAddProduct() {
        Product product = Product.create(1L, "자전거", 240000, "image.url");
        Cart cart = Cart.createEmpty(1L);
        cart.add(product);
        assertThat(cart.getProducts()).hasSize(1);
    }

    @DisplayName("상품 2개 리스트로 장바구니를 생성하면 상품 개수가 2개가 된다.")
    @Test
    void shouldProductsInCartHasSizeOfTwoWhenCreateCartWithProductListHasSizeOfTwo() {
        List<Product> products = List.of(
                Product.create(1L, "자전거", 240000, "image.url"),
                Product.create(2L, "물병", 10000, "image2.url")
        );
        Cart cart = Cart.createWithProducts(1L, products);
        assertThat(cart.getProducts()).hasSize(2);
    }
}
