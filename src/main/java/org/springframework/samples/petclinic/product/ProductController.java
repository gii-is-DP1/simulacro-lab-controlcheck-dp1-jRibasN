package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private static final String VIEWS_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";

    private final ProductService productService;

    @Autowired
	public ProductController(ProductService ProductService) {
		this.productService = ProductService;
	}

    @InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

    @GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product p = new Product();
		model.put("product", p);
		return VIEWS_PRODUCT_CREATE_FORM;
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product p, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PRODUCT_CREATE_FORM;
		}
		else {
			//creating owner, user, and authority
			this.productService.saveUser(p);
			return "redirect:/";
		}
	}
}
