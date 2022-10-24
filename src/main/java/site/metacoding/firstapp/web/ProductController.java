package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@AllArgsConstructor
@RestController
public class ProductController {
	
	private final ProductDao productDao;

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
    
    // 상품목록보기 - findAll
    @GetMapping("/product")
    public List<Product> getProductLDist(){
    	return productDao.findAll();
    }
    
    //상품 상세보기 - findById
    @GetMapping("/product/{productId}")
    public Product detail(@PathVariable Integer productId) {
    	return productDao.findById(productId);
    }
    
    //상품 등록 - insert
    @PostMapping("/product/add")
    public void insert(Product product) {
    	productDao.insert(product);
    }
    
   
    //상품 삭제하기 - deleteById
    @PostMapping("/product/{productId}/delete")
    public void delete(@PathVariable Integer productId) {
    	productDao.deleteById(productId);
    }
    
    //상품 수정하기 - update
    @PostMapping("/product/{productId}/edit")
    public void update(Product product) {
    	productDao.update(product);
    }

   
}
