package cart.service;

import cart.domain.product.Product;
import cart.domain.product.ProductRepository;
import cart.service.dto.ProductSaveDto;
import cart.service.dto.ProductUpdateDto;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductSaveDto productSaveDto) {
        Product product = Product.createToSave(
                productSaveDto.getName(),
                productSaveDto.getPrice(),
                productSaveDto.getImageUrl()
        );
        this.productRepository.save(product);
    }

    public void update(ProductUpdateDto productUpdateDto) {
        Product product = Product.create(
                productUpdateDto.getId(),
                productUpdateDto.getName(),
                productUpdateDto.getPrice(),
                productUpdateDto.getImageUrl()
        );
        this.productRepository.update(product);
    }

    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long productId) {
        return this.productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 상품 ID로 조회했습니다." + System.lineSeparator() +
                        "입력한 ID: " + productId)
        );
    }
}
