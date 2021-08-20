package com.example.currencywebgame.service;

import com.example.currencywebgame.api.AvailableCurrency;
import com.example.currencywebgame.api.Rate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class CurrencyGameService implements CurrencyGameDao {

    private final AvailableCurrency[] myCurrency;


    public CurrencyGameService() {
        RestTemplate restTemplate = new RestTemplate();
        this.myCurrency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", AvailableCurrency[].class);

    }

    @Override
    public List<Rate> getAllRates() {

        return myCurrency[0].getRates();

    }

    @Override
    public int getRandom(int array) {
        Random rnd = new Random();

        return rnd.nextInt(array);
    }

    @Override
    public Rate getRandomRate() {
        List<Rate> rates = getAllRates();
        int randomRate = getRandom(rates.size());
        return rates.get(randomRate);

    }

    @Override
    public double hintLow(double rate) {

        BigDecimal low = new BigDecimal("0.9");
        BigDecimal rateValue = BigDecimal.valueOf(rate);
        BigDecimal lowHint = rateValue.multiply(low);


        return lowHint.doubleValue();
    }

    @Override
    public double hintHigh(double rate) {

        BigDecimal high = new BigDecimal("1.1");
        BigDecimal rateValue = BigDecimal.valueOf(rate);
        BigDecimal highHint = rateValue.multiply(high);

        return highHint.doubleValue();
    }
}


