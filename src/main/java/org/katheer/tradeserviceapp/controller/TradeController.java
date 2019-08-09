package org.katheer.tradeserviceapp.controller;

import org.katheer.tradeserviceapp.entity.Trade;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface TradeController {
   /**
    * Returns Trade Iterable whose places are matching, if none's place is matching returns a empty Iterable
    * @param place Specifies the place of the trade to be searched in database. Should not be null.
    * @return an Iterable<Trade>
    */
   Iterable<Trade> getTradeByBuyersPlace(@NotNull String place);

   /**
    * Returns Trade if it is available in the database, else returns null
    * @param id Specifies the ID of the Trade to be retrieved. Should not be null.
    * @return a Trade
    */
   Trade getTradeById(@NotNull Integer id);

   /**
    * Returns Auto-generated ID from database after insertion if Trade is valid, else returns zero
    * @param trade Specifies the trade to be created in the database. Should be valid w.r.t. the Entity definition.
    * @return an int
    */
   void createTrade(@Valid Trade trade);

   /**
    * Returns Trade Iterable which contains all the trades available in database, if nothing available returns empty Iterable
    * @return an Iterable<Trade>
    */
   Iterable<Trade> getAllTrades();
}
