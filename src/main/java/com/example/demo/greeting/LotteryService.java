package com.example.demo.greeting;

import com.example.demo.IRandom;
import org.springframework.stereotype.Service;


@Service
public class LotteryService {
    private IRandom random;

    public LotteryService(IRandom random) {
        this.random = random;
    }

    public boolean checkLotto(int guestLotto){
        int lotto = this.random.nextInt(10) ;  //0-9
        System.out.println("lottery =>"+ lotto);
        if( guestLotto == lotto){
            return true;
        }
        return false;
    }
}
