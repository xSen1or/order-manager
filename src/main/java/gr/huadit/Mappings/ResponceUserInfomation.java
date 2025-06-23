package gr.huadit.Mappings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponceUserInfomation {
    @GetMapping("getUser")
    public String getUser(){
        return "test";
    }
}