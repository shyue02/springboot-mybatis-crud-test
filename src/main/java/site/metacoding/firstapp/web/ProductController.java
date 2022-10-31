package site.metacoding.firstapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import site.metacoding.firstapp.domain.Product;
import site.metacoding.firstapp.domain.ProductDao;
import site.metacoding.firstapp.service.ProductService;
import site.metacoding.firstapp.web.dto.CMRespDto;

@AllArgsConstructor
@Controller
public class ProductController {

	private final ProductDao productDao;
	private final ProductService productService;
	
	// 상품목록보기 - findAll
	@GetMapping({"/product", "/"})
	public String productList(Model model) {
		List<Product> getList = productDao.findAll();
		model.addAttribute("product", getList);
		return "product/list";
	}

	// 상품상세보기 - findById
	@GetMapping("/product/{productId}")
	public String productDetail(@PathVariable Integer productId, Model model) {
//		Product productPS = productDao.findById(productId);
//		model.addAttribute("product", productPS);
		model.addAttribute("detail", productDao.findById(productId));
		return "product/detail";
	}

	
	// 상품 등록 페이지로 이동
	@GetMapping("/product/add")
	public String insertForm() {
		return "product/insert";
	}
	
	@GetMapping("/api/product/productNameSameCheck")
	public @ResponseBody CMRespDto<Boolean> productNameSameCheck(String productName) {
		boolean isSame = productService.상품명중복확인(productName);
		System.out.println(productName);
		return new CMRespDto<>(1, "성공", isSame);
	}
	
	
	// 상품등록하기 - insert
	@PostMapping("/product/add")
	public String productInsert(Product product) {
		productDao.insert(product);
		return "redirect:/";
	}

	
	
	// 상품 수정 페이지로 이동
	@GetMapping("/product/{productId}/edit")
	public String updateForm(@PathVariable Integer productId, Product product, Model model) {
		model.addAttribute("edit", productDao.findById(productId));
		return "product/edit";
	}
	
	//상품수정하기 - update
	@PostMapping("/product/{productId}/edit")
	public String update(@PathVariable Integer productId, Product product) {
		//1.영속화
		Product productPS = productDao.findById(productId);
		//2.영속화 된 객체 변경
		productPS.update(product);
		//3.디비수행
		productDao.update(productPS);


		//productDao.update(product);	// 1~3. 코드 대신 이 한 줄로 써도 된다

		return "redirect:/";
	}
	
	
	
	//상품삭제하기 - deleteById
	@PostMapping("/product/{productId}/delete")
	public String delete(@PathVariable Integer productId) {
		productDao.deleteById(productId);
		return "redirect:/";
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
