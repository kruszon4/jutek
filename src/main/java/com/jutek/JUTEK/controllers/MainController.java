package com.jutek.JUTEK.controllers;

import com.jutek.JUTEK.model.*;
import com.jutek.JUTEK.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String mainPage() {
//        System.out.println(userService.getAllUser());
        return "index";
    }

    @GetMapping("/newBill")
    private String newBILL(Model model) {

        model.addAttribute("nu", new newUser());
        model.addAttribute("nn", userService.getAllUserData());

        return "newBill2";
    }

    @GetMapping("/newBillTable/{person}/{quantity}/{billValue}")
    private String newBillTable(@PathVariable(value = "person") String person,
                                @PathVariable(value = "quantity") int quantity,
                                @PathVariable(value = "billValue") String billValue,
                                Model model) {


        TransactionDTO transactionDTO = new TransactionDTO();
        for (int i = 0; i < quantity; i++) {
            transactionDTO.addBill(new Bill());
        }


        model.addAttribute("form", transactionDTO);
        model.addAttribute("nu", new newUser());
        model.addAttribute("nn", userService.getAllUserData());
        model.addAttribute("billOwner", userService.getUserById(Long.parseLong(person)));
        model.addAttribute("billValue", billValue);

        return "newBillTable";
    }

//    @GetMapping("/rate/{from}/{to}")
//    private String getExchangeRate(@PathVariable(value = "from") String fromCurrency,
//                                   @PathVariable(value = "to") String toCurrency, Model model) {
//
//        RealTimeValue exchangeRate = currencyListService.getExchangeRate(fromCurrency, toCurrency);
//        model.addAttribute("exchangeRate", exchangeRate);
//
//        return "realTimeRate";
//    }
//


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute TransactionDTO form, Model model, newUser newUser) {

        System.out.println(form);
        System.out.println(newUser);

        return "index";
    }

//   @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String someMethod(@RequestBody String postPayload) {
//        System.out.println(postPayload);
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println(modelAndView.toString());
//        return "index";
//    }


    @PostMapping("/userCreator")
    private String putWordToDb(@Valid User user, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        System.out.println(user.toString());
        userService.saveUser(user);
        return "index";
    }

//    @RequestMapping(value = "/userCreator", method = RequestMethod.POST)
//    public String somedMethod(@RequestBody String postPayload) {
//        System.out.println(postPayload);
//        return "newUser2";
//    }

    @GetMapping("/newUser")
    private String putUserToDb(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

//
//    @GetMapping("/billStatement")
//    private String getAllBills(Model model) {
//        model.addAttribute("bills", );
//        return "newUser";
//    }


    @GetMapping("/a")
    public String showForm(PersonForm personForm)

    {
        System.out.println(userService.getUserById((long) 100));
        return "index";
    }

    @PostMapping("/a")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "index";
    }


}
