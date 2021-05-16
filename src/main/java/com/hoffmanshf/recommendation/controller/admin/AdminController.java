package com.hoffmanshf.recommendation.controller.admin;

import javax.servlet.http.HttpServletRequest;

import com.hoffmanshf.recommendation.common.AdminPermission;
import com.hoffmanshf.recommendation.common.BusinessException;
import com.hoffmanshf.recommendation.common.enums.BusinessError;
import com.hoffmanshf.recommendation.service.CategoryService;
import com.hoffmanshf.recommendation.service.SellerService;
import com.hoffmanshf.recommendation.service.ShopService;
import com.hoffmanshf.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/admin/admin")
@RequestMapping("/admin/admin")
public class AdminController {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String encryptPassword;

    private final HttpServletRequest httpServletRequest;

    private final UserService userService;

    private final CategoryService categoryService;

    private final ShopService shopService;

    private SellerService sellerService;

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    public AdminController(HttpServletRequest httpServletRequest, UserService userService, CategoryService categoryService, ShopService shopService, SellerService sellerService) {
        this.httpServletRequest = httpServletRequest;
        this.userService = userService;
        this.categoryService = categoryService;
        this.shopService = shopService;
        this.sellerService = sellerService;
    }

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");

        modelAndView.addObject("userCount",userService.countAllUser());
        modelAndView.addObject("shopCount",shopService.countAllShop());
        modelAndView.addObject("categoryCount",categoryService.countAllCategory());
        modelAndView.addObject("sellerCount",sellerService.countAllSeller());
        modelAndView.addObject("CONTROLLER_NAME","admin");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }


    @RequestMapping("/loginpage")
    public ModelAndView loginpage() {
        return new ModelAndView("/admin/admin/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password) throws BusinessException {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR, "Invalid username and password");
        }
        if (email.equals(this.email) && password.equals(this.encryptPassword)) {
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR, "Invalid username and password");
        }

    }
}

