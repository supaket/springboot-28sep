package com.example.demo.greeting;

class UserRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int lotto;

    public int getLotto() {
        return lotto;
    }

    public void setLotto(int lotto) {
        this.lotto = lotto;
    }
}