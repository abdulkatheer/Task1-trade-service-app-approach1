package org.katheer.tradeserviceapp.service;

import org.katheer.tradeserviceapp.entity.Trade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {
   @Override
   public void createTrade(Trade trade){
      TradeService.trades.add(trade);
   }

   @Override
   public Trade getTradeById(Integer id) {
      List<Trade> trades = TradeService.trades.stream()
            .filter(trade -> trade.getTradeId() == id)
            .collect(Collectors.toList());
      return trades.size() == 0 ? null : trades.get(0);
   }

   @Override
   public Iterable<Trade> getTradeByBuyersPlace(String buyersPlace) {
      return TradeService.trades.stream()
            .filter(trade -> trade.getVenue().equals(buyersPlace))
            .collect(Collectors.toList());
   }

   @Override
   public Iterable<Trade> getAllTrades() {
      return TradeService.trades;
   }

   @Override
   public Iterable<String> getBuyersWhoseShareOnXShareIsGreaterThanYQuantity(String shareName, int leastQuantity) {
      Map<String, List<Trade>> trades = TradeService.trades.stream()
            .filter(trade -> trade.getShareName().equals(shareName))
            .collect(Collectors.groupingBy(Trade::getBuyerId));

      //aggregate tradeQuantity
      Map<String, Integer> aggregated = new HashMap<>();
      trades.forEach(((buyerId, tradeList) -> aggregated.put(buyerId,
            tradeList.stream()
            .mapToInt(Trade::getQuantity)
            .sum())));

      List<String> result = new ArrayList<>();
      aggregated.forEach((buyerId, totalQuantity) -> {
         if (totalQuantity > leastQuantity)
            result.add(buyerId);
      });

      return result;
   }

   @Override
   public Iterable<Trade> getTradesByDate(String dateString) {
       return null;
   }


}