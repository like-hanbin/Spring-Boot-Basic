package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//    wa에서 /hello라고 들어오면 메서드 호출
    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //응답 body에 return 내용을 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

//    진짜임
    @GetMapping("hello-api")
//    responsebody - 객체를 반환하면 json 포맷으로 반환되는 것이 default임 (spring내에서)
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
//    static class 는 class 내에 만들 수 있음
    static class Hello {
//        java bean 규약, property 접근방식
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}
}
