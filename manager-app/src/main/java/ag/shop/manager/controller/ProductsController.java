package ag.shop.manager.controller;

import ag.shop.manager.controller.payload.NewProductPayload;
import ag.shop.manager.entity.Product;
import ag.shop.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("list")
    public String getProductList(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        Product product = this.productService.createProduct(payload.title(), payload.description());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }
}