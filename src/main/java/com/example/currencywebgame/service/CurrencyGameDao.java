package com.example.currencywebgame.service;

import com.example.currencywebgame.api.Rate;

import java.util.List;

public interface CurrencyGameDao {

    List<Rate> getAllRates();

    int getRandom(int array);

    Rate getRandomRate();

    double hintLow(double rate);

    double hintHigh(double rate);


}
