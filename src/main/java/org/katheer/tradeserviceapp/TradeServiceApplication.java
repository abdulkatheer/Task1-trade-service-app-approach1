package org.katheer.tradeserviceapp;

import org.katheer.tradeserviceapp.entity.Trade;
import org.katheer.tradeserviceapp.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TradeServiceApplication implements CommandLineRunner {
   @Autowired
   private TradeService tradeService;
   public static void main(String[] args) {
      SpringApplication.run(TradeServiceApplication.class, args);
   }

   @Override
   public void run(String... strings) throws Exception {
      tradeService.createTrade(
            Trade.builder()
            .tradeId(1)
            .buyerId("B-111")
            .buyerName("Abdul")
            .shareId("S-111")
            .shareName("Infosys")
            .quantity(100)
            .price(10000)
            .venue("Bangalore")
            .tradingDateTime(new Date())
            .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(2)
                  .buyerId("B-112")
                  .buyerName("Manasa")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(50)
                  .price(5000)
                  .venue("Chennai")
                  .tradingDateTime(new Date())
                  .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(3)
                  .buyerId("B-113")
                  .buyerName("Utpal")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(150)
                  .price(15000)
                  .venue("Mumbai")
                  .tradingDateTime(new Date())
                  .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(4)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-112")
                  .shareName("IBM")
                  .quantity(170)
                  .price(157000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(5)
                  .buyerId("B-114")
                  .buyerName("Mandar")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(170)
                  .price(168000)
                  .venue("Hyderabad")
                  .tradingDateTime(new Date())
                  .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(6)
                  .buyerId("B-115")
                  .buyerName("Rishi")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(200)
                  .price(1268000)
                  .venue("Delhi")
                  .tradingDateTime(new Date())
                  .build()
      );

      tradeService.createTrade(
            Trade.builder()
                  .tradeId(7)
                  .buyerId("B-111")
                  .buyerName("Abdul")
                  .shareId("S-111")
                  .shareName("Infosys")
                  .quantity(200)
                  .price(1268000)
                  .venue("Bangalore")
                  .tradingDateTime(new Date())
                  .build()
      );

      //testing our methods
      System.out.println(tradeService.getBuyersWhoseShareOnXShareIsGreaterThanYQuantity("Infosys", 100));
      System.out.println(tradeService.getBuyersWhoseShareOnXShareIsGreaterThanYQuantity("Infosys", 200));
      System.out.println(tradeService.getBuyersWhoseShareOnXShareIsGreaterThanYQuantity("Infosys", 250));
   }
}
