package org.katheer.tradeserviceapp.service;

import org.katheer.tradeserviceapp.entity.Trade;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Validated
public interface TradeService {
   List<Trade> trades = new ArrayList<>();

   /**
    * Returns trade_id after creation of trade.
    * @param trade Specifies Trade that needs to be created in database.
    * @return trade_id
    * @throws ConstraintViolationException when Trade is not valid w.r.t the Entity constraints.
    */
   void createTrade(@Valid Trade trade) throws ConstraintViolationException;

   /**
    * Returns matching Trades.
    * @param buyersPlace Specifies the place of trade. Should not be null.
    * @return an Iterable<Trade>
    */
   Iterable<Trade> getTradeByBuyersPlace(String buyersPlace);

   /**
    * Returns matching Trade.
    * @param id Specifies the id of the Trade that needs to retrieved.
    * @return Trade
    */
   Trade getTradeById(Integer id);

   /**
    * Returns matching Trades.
    * @return an Iterable<Trade>
    */
   Iterable<Trade> getAllTrades();

   Iterable<String> getBuyersWhoseShareOnXShareIsGreaterThanYQuantity(String shareName, int leastQuantity);

   Iterable<Trade> getTradesByDate(String dateString);
}
