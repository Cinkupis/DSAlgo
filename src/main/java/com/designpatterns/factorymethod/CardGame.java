package com.designpatterns.factorymethod;

@SuppressWarnings("unused")
public class CardGame {
    public static CardGame createCardGame(GameType type) {
        if (type == GameType.POKER) {
            return new PokerGame();
        } else if (type == GameType.BLACKJACK) {
            return new BlackJackGame();
        }
        return null;
    }
}
