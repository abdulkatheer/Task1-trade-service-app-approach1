package org.katheer.tradeserviceapp.controller;

import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tradeservice")
public class RestTradeController implements TradeController {

   @Autowired
   private TradeService tradeService;

   @PostMapping(value = "/create")
   public void createTrade(@RequestBody Trade trade) {
      tradeService.createTrade(trade);
   }

   @GetMapping(value = "/get/bybuyersplace")
   public Iterable<Trade> getTradeByBuyersPlace(@RequestParam("buyers_place") String buyersPlace) {
      return tradeService.getTradeByBuyersPlace(buyersPlace);
   }

   @GetMapping(value = "/get/byid")
   public Trade getTradeById(@RequestParam("trade_id") Integer tradeId) {
      return tradeService.getTradeById(tradeId);
   }

   @GetMapping(value = "/get/all")
   public Iterable<Trade> getAllTrades() {
      return tradeService.getAllTrades();
   }

   @GetMapping(value = "/get/buyersbasedonquantity")
   public Iterable<String> getBuyersWhoseShareOnXShareIsGreaterThanYQuantity(@RequestParam("share_name") String shareName, @RequestParam("quantity") Integer quantity) {
      return tradeService.getBuyersWhoseShareOnXShareIsGreaterThanYQuantity(shareName, quantity);
   }
}
