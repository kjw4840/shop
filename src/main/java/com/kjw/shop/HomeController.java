package com.kjw.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinwook.kim
 * @since 2022/01/29
 */
@RestController
@RequestMapping(value = "/admin")
public class HomeController {

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
