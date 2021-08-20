package com.example.currencywebgame.controller;

import com.example.currencywebgame.api.Rate;
import com.example.currencywebgame.service.CurrencyGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
public class CurrencyController {

    private final CurrencyGameService currencyGameService;

    private final Rate rate;
    private final BigDecimal rateToGuess;
    private String result;
    private int counter = 0;


    @Autowired
    public CurrencyController(CurrencyGameService currencyGameService) {
        this.currencyGameService = currencyGameService;
        rate = currencyGameService.getRandomRate();
        rateToGuess = BigDecimal.valueOf(rate.getMid()).setScale(4, RoundingMode.HALF_UP);

    }

    @GetMapping("/start")

    public String getRandomCurrency(Model model) {
        model.addAttribute("rate", rate.getCode());
        model.addAttribute("rateCode", rate.getMid());
        model.addAttribute("userInput", new Rate());
        model.addAttribute("result", result);
        model.addAttribute("counter", counter);

        return "start";

    }


    @PostMapping("/start")
    public String userGuess(@ModelAttribute Rate rate) {

        BigDecimal input = BigDecimal.valueOf(rate.getMid()).setScale(4, RoundingMode.HALF_UP);


        if (input.compareTo(rateToGuess) > 0) {

            result = "too much, try one more time";
            counter++;


        }
        if (input.equals(rateToGuess)) {

            result = "Congratulations! You won!";
        }

        if (input.compareTo(rateToGuess) < 0) {

            result = "too less, try one more time";
            counter++;
        }

        return "redirect:/start";

    }

    @GetMapping("/error")
    public String incorrectUserInput(Model model) {

        return "error";
    }

    @GetMapping("/hint")
    public String hint(Model model) {

        model.addAttribute("low", currencyGameService.hintLow(rate.getMid()));
        model.addAttribute("high", currencyGameService.hintHigh(rate.getMid()));

        return "hint";
    }
}
