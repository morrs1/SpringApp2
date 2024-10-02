package springApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String sayHello(
            @RequestParam("a") String a,
            @RequestParam("b") String b,
            @RequestParam("action") String action,
            Model model
    ) {
        Integer intA = Integer.parseInt(a);
        Integer intB = Integer.parseInt(b);

        Integer result = switch (action) {
            case "add" -> intA + intB;
            case "sub" -> intA - intB;
            case "mul" -> intA * intB;
            case "div" -> intA / intB;
            default -> 0;
        };
        model.addAttribute("result", result);
        return "hello_world";
    }
}
