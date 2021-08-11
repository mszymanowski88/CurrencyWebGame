package com.example.currencywebgame.controller;

import com.example.currencywebgame.api.AvailableCurrency;
import com.example.currencywebgame.api.Rate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class CurrencyGameService {

    RestTemplate restTemplate;
    private  AvailableCurrency[] myCurrency;



    public CurrencyGameService() {
        this.restTemplate = new RestTemplate();
        this.myCurrency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b",AvailableCurrency[].class);

    }

    public List<Rate> getAllRates()
    {

        return myCurrency[0].getRates();

    }

    public int getRandom(int array) {
        Random rnd = new Random();
       int randomCurrency =rnd.nextInt(array);
        return randomCurrency;
    }

    public Rate getRandomRate()
    {
        List<Rate> rates = getAllRates();
        int randomRate = getRandom(rates.size());

        return rates.get(randomRate);

//        return getAllRates().get(getRandom(getAllRates().size()));

    }

}


//   private Rate[] currency;
//   private AvailableCurrency currencyForGame;
//   private BigDecimal currencyGuess;
//
//
//   private RestTemplate restTemplate;
//   private Currency[] listOfCurrencies;
//
//
//
////    public CurrencyGameService() {
////
////        currencyForGame = getCurrencyForGame();
////
////        currencyGuess = BigDecimal.valueOf(currencyForGame.getRates().get(0).getMid());
////        System.out.println(currencyForGame);
////        System.out.println(currencyGuess);
////
////    }
//
////    public CurrencyGameService() {
////
////        getCurrencyForGame().getRates().get(0).getMid();
////
////    }
//
//    public CurrencyGameService() {
//
//        getCurrencyForGame().getMid();
//
//    }
//
//
////        currency[0] = getCurrencyForGame();
////
////        currencyGuess = BigDecimal.valueOf(currency[0].getRates().get(0).getMid());
////        System.out.println(currency[0]);
////        System.out.println(currencyGuess);
//
////
////    public BigDecimal getCurrencyGuess()
////    {
//
//
////        currencyForGame = getCurrencyForGame();
////
////        currencyGuess = BigDecimal.valueOf(currencyForGame.getRates().get(0).getMid());
////
////        return currencyGuess;
////
////    }
////
////    public BigDecimal getCurrencyGuess()
////    {
////        currency[0]  = getCurrencyForGame();
////
////        currencyGuess = BigDecimal.valueOf( currency[0] .getRates().get(0).getMid());
////
////        return currencyGuess;
////
////    }
//
//    public BigDecimal getCurrencyGuess()
//    {
//        currency[0]  = getCurrencyForGame();
//
//        currencyGuess = BigDecimal.valueOf( currency[0] .getMid());
//
//        return currencyGuess;
//
//    }
//
////    public double presentRandomCurrencyToUser()
////    {
////        Double currenyUserNeedToGeuss;
////
////        currenyUserNeedToGeuss =  getCurrencyForGame().getRates().get(0).getMid();
////
////        return currenyUserNeedToGeuss;
////
////
////    }
//
//    public double presentRandomCurrencyToUser()
//    {
//        Double currenyUserNeedToGeuss;
//
//       currenyUserNeedToGeuss =  getCurrencyForGame().getMid();
//
//       return currenyUserNeedToGeuss;
//
//
//    }
////
////    public  AvailableCurrency getCurrencyForGame()
////    {
////        AvailableCurrency currencyRandom;
////
////        RestTemplate restTemplate = new RestTemplate();
////        currencyRandom = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/b/"+randomCurrencyResult()+"/", AvailableCurrency.class);
////
////        return currencyRandom;
////
////    }
//
//    public  Rate getCurrencyForGame()
//    {
//        Rate currencyRandom;
//
//        RestTemplate restTemplate = new RestTemplate();
//        currencyRandom = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/b/"+randomCurrencyResult()+"/", Rate.class);
//
//        return currencyRandom;
//
//    }
//
//
//
////    public AvailableCurrency[] getListOfCurrencies() {
////
////        RestTemplate restTemplate = new RestTemplate();
////        currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", AvailableCurrency[].class);
////        return currency;
////    }
//
//    public Rate[] getListOfCurrencies() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", Rate[].class);
//
////        double mid = currency[0].getMid();
//        System.out.println("1"+currency[0].getAdditionalProperties());
////        System.out.println("2"+mid);
//
//        System.out.println("3"+currency[0].getAdditionalProperties().get("rates"));
//       for(Rate random : currency)
//       {
//           for(String key : random.getAdditionalProperties().keySet())
//           {
//               System.out.println("key " +key);
//           }
//       }
//        return currency;
//    }
//
//
//

////
////    public String randomCurrencyResult()
////    {
////
////       String currencyName = "";
////
////        AvailableCurrency[] random =  getListOfCurrencies();
////
////        for(AvailableCurrency select : random) {
////
////            currencyName = select.getRates().get(getRandom(select.getRates().size())).getCode();
////
////        }
////        return currencyName;
////
////    }
//
//    public String randomCurrencyResult()
//    {
//
//        String currencyName = "";
//
//      Rate[] random =  getListOfCurrencies();
//
//     currencyName =  random[0].getCode();
//
//
////        }
//        System.out.println("currnecy" + currencyName);
//        return currencyName;
//
//    }
//
//
//    @GetMapping("/start")
//    public String getRandomCurrency(Model model)
//
//    {
//
//        model.addAttribute("currency",getCurrencyForGame());
//        model.addAttribute("rateToGuess",getCurrencyForGame());
//        model.addAttribute("rateToGuess",presentRandomCurrencyToUser());
//
//
//        return "start";
//
//    }
//}
////
////
////    public String randomCurrencyResult()
////    {
////
////        String currencyName = "";
////
////        AvailableCurrency[] random =  getListOfCurrencies();
////
////        for(AvailableCurrency select : random) {
////
////            currencyName = select.getRates().get(getRandom(select.getRates().size())).getCode();
////
////        }
////        return currencyName;
////
////    }
////
////    private RestTemplate restTemplate;
////    private Currency[] currency;
////
////
////    public CurrencyGameService() {
////
////       this.restTemplate = new RestTemplate();
////       currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", Currency[].class);
////    }
//
////
////    public AvailableCurrency[] getRandomCurrencyRate() {
////
////        AvailableCurrency randomCurrency;
////
////        RestTemplate restTemplate = new RestTemplate();
////        currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b", AvailableCurrency[].class);
////
////
////
////        return currency;
////    }
//
////    public static int getRandom(int random) {
////        int rnd = new Random().nextInt(random);
////        System.out.println(random);
////        return rnd;
////    }
//
////    public List<Rate> getCurrencyRates()
////    {
////
////
////    }
//
//
//
////    @GetMapping("/start")
////    public String getRandomCurrencyRate()
////    {
////
////        RestTemplate restTemplate = new RestTemplate();
////        CurrencyRate[] currencyRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A",  CurrencyRate[].class);
////
////
////        for(CurrencyRate currnecy : currencyRate)
////        {
////
////            System.out.println(currnecy);
////            System.out.println(currnecy.getCode());
////            System.out.println(currnecy.getCode());
////
////        }
////
////        return "/start";
////    }
//
////    public CurrencyRate[] getRandomCurrencyRate()
////    {
////
////        RestTemplate restTemplate = new RestTemplate();
////        CurrencyRate[] currencyRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A",  CurrencyRate[].class);
//////        int rnd = new Random().nextInt(currencyRate.length);
//////
//////        System.out.println( currencyRate[1].getMid());
////
////        for(CurrencyRate currnecy : currencyRate)
////        {
////
////            System.out.println(currnecy);
////            System.out.println();
////
////
////        }
////        System.out.println(currencyRate);
////    return currencyRate;
////
////
////    }
//
//
//
////
////    public CurrencyRate2[] getRandomCurrencyCode() {
////
////        RestTemplate restTemplate = new RestTemplate();
////
////        CurrencyRate2[] currencyCode = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/b/", CurrencyRate2[].class);
////        System.out.println(currencyCode[0].getCode());
////
////        System.out.println(currencyCode);
//
////        String code1 = Arrays.stream(currencyCode).map(CurrencyRate::getCode).toString();
////        System.out.println("Code1" + code1.toString());
//////        currencyCode = Arrays.stream(currencyCode).map(CurrencyRate::getCode)
////        String[] currencyCodes = Arrays.stream(currencyCode).map(CurrencyRate::getCode).;
////        String[] currencyCodes = Array
//
////        List<String> currencyCodes = Arrays.stream(currencyCode).map(CurrencyRate2::getCode).collect(Collectors.toList());
////
////        List<String> currencyCodes1 = Arrays.stream(currencyCode).map(CurrencyRate2::getCode).collect(Collectors.toList());
////
////
////        System.out.println(currencyCodes);
////        System.out.println(currencyCodes1.toString());
////
//// for(CurrencyRate2 code: currencyCode)
//// {
////     List<String> currencyCodes = Arrays.stream(currencyCode).map(CurrencyRate::getCode).collect(Collectors.toList());
////     System.out.println("tu " + currencyCodes);
//
//
//
//// }
////
////
////        return currencyCode;
////
////
////    }
//
////    @GetMapping("/start")
////    public String getRandomCurrencyName(Model model)
////
////    {
////
////
////
////        return "start";
////
////    }
//
//
////        CurrencyRate currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/a/", CurrencyRate.class);
//
////public void codes()
////{
////    System.out.println("Codes outside method "+ codes);
////}
//
//
//
//
//
//
//
////    @GetMapping("/start")
////    public String getRandomCurrencyRate()
////    {
////
////        RestTemplate restTemplate = new RestTemplate();
////        CurrencyRate[] currencyRate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A",  CurrencyRate[].class);
////
////
////        for(CurrencyRate currnecy : currencyRate)
////        {
////
////            System.out.println(currnecy);
////            System.out.println(currnecy.getCode());
////            System.out.println(currnecy.getCode());
////
////        }
////
////        return "/start";
////    }
//
//
//
////    public  AvailableCurrency getRandomCurrnecy()
////    {
////
////    AvailableCurrency currency1 =  Arrays.stream(getListOfCurrencies()).forEach(randomCurrency ->
////
////            randomCurrency.getRates().get(getRandom(randomCurrency.getRates().size())).getCode())
////
////
////            ;
////
////      int currency2 =  Arrays.stream(getListOfCurrencies()).mapToInt(randomCurrency -> Integer.parseInt(randomCurrency.getRates().get(getRandom(randomCurrency.getRates().size())).getCode())).sum();
//////        .forEach(randomCurrency -> randomCurrency.getRates().get(getRandom(randomCurrency.getRates().size())).getCode());
////
////
////        ;
////
////
////for(AvailableCurrency showCurrency : currency)
////       {
//////           System.out.println(showCurrency);
//////           System.out.println("from loop" +showCurrency.getRates());
//////           System.out.println("from loop" +showCurrency.getNo());
//////           System.out.println("długosc" + showCurrency.getRates().get(4).getCode());
//////           System.out.println(getRandom(currency.length));
//////           System.out.println("from loop code " +showCurrency.getRates().get(getRandom(showCurrency.getRates().size())).getCode());
////
////
////       }
//////
//////       currency[0].getRates();
//////        System.out.println("rates; "+  currency[0]);
////