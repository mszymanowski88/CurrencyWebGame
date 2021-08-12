package com.example.currencywebgame.controller;

import com.example.currencywebgame.api.Rate;
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

CurrencyGameService currencyGameService;

private Rate rate;
private BigDecimal rateToGuess;
private String result;


    @Autowired
    public CurrencyController(CurrencyGameService currencyGameService) {
        this.currencyGameService = currencyGameService;
        rate = currencyGameService.getRandomRate();
        rateToGuess = BigDecimal.valueOf(rate.getMid()).setScale(4,RoundingMode.HALF_UP);
        System.out.println(rate.getMid());
        System.out.println(rateToGuess);
    }

    @GetMapping("/start")

    public String getRandomCurrency(Model model)

    {
        model.addAttribute("rate",rate.getCode());
        model.addAttribute("rateCode",rate.getMid());
        model.addAttribute("userInput", new Rate());

        return "start";

    }

//    public double rateGuess(Double input)
//    {
//        Double rateToGuess = this.rate.getMid().doubleValue();
//        System.out.println("rate to guess " + rateToGuess );
//        System.out.println("input  " + input );
//        if(input.compareTo(rateToGuess)>0)
//        {
//
//            System.out.println("za dużo");
//
//        }
//        if (input.compareTo(rateToGuess) == 0)
//        {
//
//            System.out.println("wygrales");
//        }
//        else
//        {
//            System.out.println("za mało");
//        }
//
//        return input;
//    }

    @PostMapping("/start")
    public String userGuess(@ModelAttribute Rate rate)
    {
//        Double input = rate;
//        model.addAttribute("code",rate);
//        Double rateToGuess = this.rate.getMid();
//
////        model.addAttribute("userGuess",rateGuess(guess));
//
////       double rateToGuess = this.rate.getMid().doubleValue();
////        System.out.println(valueToGuess);
        BigDecimal input = BigDecimal.valueOf(rate.getMid()).setScale(4, RoundingMode.HALF_UP);
//        rateToGuess = BigDecimal.valueOf(rate.getMid()).setScale(4,RoundingMode.HALF_UP);


        System.out.println("input" + input);
        System.out.println("rate to guess" + rateToGuess);



        if(input.compareTo(rateToGuess)>0)
        {

            System.out.println("post za dużo");


        }
        if (input.equals(rateToGuess))
        {

            System.out.println(" post wygrales");
        }
        else
        {
            System.out.println("post za mało");
        }

        return "redirect:/start";

    }

//    @PostMapping
//    public String userGuess(@ModelAttribute Rate rate)
//    {
//
//        rate = this.rate;
//        BigDecimal input = BigDecimal.valueOf(rate.getMid()).setScale(2, RoundingMode.HALF_UP);
//
//        System.out.println(input);
//
//        if(input.compareTo(rateToGuess)>0)
//        {
//
//            System.out.println("za dużo");
//
//        }
//        if (input.compareTo(rateToGuess) == 0)
//        {
//
//            System.out.println("wygrales");
//        }
//        else
//        {
//            System.out.println("za mało");
//        }
//
//        return "redirect:/start";
//
//    }
}
