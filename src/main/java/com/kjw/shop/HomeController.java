package com.kjw.shop;

import com.kjw.shop.common.auth.CheckRole;
import com.kjw.shop.member.model.Authority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@RestController
@RequestMapping(value = "/test")
public class HomeController {

    @GetMapping("/test")
    @CheckRole(auth = Authority.ADMIN)
    public String test() {
        return "hello";
    }
}
