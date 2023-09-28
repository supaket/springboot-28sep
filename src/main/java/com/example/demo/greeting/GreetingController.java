package com.example.demo.greeting;


import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    LotteryService lotteryService;

    public GreetingController(LotteryService service){
        this.lotteryService = service;
    }

    @GetMapping("/Greeting/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/Greeting")
    public String sayHiPost(@RequestBody UserRequest request){

        boolean isWin = lotteryService.checkLotto(request.getLotto());
        return "Hello"+ request.getName()  + " you guest" + request.getLotto() + " your win => " + isWin;
    }
}
