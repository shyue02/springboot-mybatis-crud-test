package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;

@AllArgsConstructor
@Controller

public class ProductController {
	
	private final ProductDao productDao;

	// 상품목록보기 - findAll
	@GetMapping("/product")
	public String productList(Model model) {
		List<Product> getList = productDao.findAll();
		model.addAttribute("product", getList);
		return "product/list"; 
	}
	
	// 상품상세보기 - findById
	@GetMapping("/product/{productId}")
		public String productDetail(@PathVariable Integer productId, Model model) {
		Product productPS = productDao.findById(productId);
		model.addAttribute("product", productPS);
		return "product/detail";
	}
	
	
// ========== 포스트맨 테스트 완료 -> 참고해서 만들어보자! ==================

//    // 상품목록보기 - findAll	
//    @GetMapping("/product")
//    public List<Product> ProductList(){
//    	return productDao.findAll();
//    }
//    
    
//    //상품 상세보기 - findById
//    @GetMapping("/product/{productId}")
//    public Product detail(@PathVariable Integer productId) {
//    	return productDao.findById(productId);
//    }
//    
//    //상품 등록 - insert
//    @PostMapping("/product/add")
//    public void insert(Product product) {
//    	productDao.insert(product);
//    }
//    
//   
//    //상품 삭제하기 - deleteById
//    @PostMapping("/product/{productId}/delete")
//    public void delete(@PathVariable Integer productId) {
//    	productDao.deleteById(productId);
//    }
//    
//    //상품 수정하기 - update
//    @PostMapping("/product/{productId}/edit")
//    public void update(Product product) {
//    	productDao.update(product);
//    }

   
}
