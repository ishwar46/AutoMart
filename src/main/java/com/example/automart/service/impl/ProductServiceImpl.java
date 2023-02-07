package  com.example.automart.service.impl;

import  com.example.automart.entity.Product;
import  com.example.automart.repository.ProductRepository;
import  com.example.automart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(long id, Product newProduct) {
        Product found = productRepository.getOne(id);
        found.setName(newProduct.getName());
        found.setImageUrl(newProduct.getImageUrl());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }

    @Override
    public void delete(long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Product> findAllByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return productRepository.count();
    }
}
