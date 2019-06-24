package Poker.model;

import Poker.deck.Card;
import Poker.service.Game;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/poker")
public class Controller {

    private Game game;

    Controller(Game game){
        this.game = new Game();
    }

    @PostMapping(value = "/InitializeGame")
    public void StartGame() {
        game.startGame();
    }

    @PostMapping(value = "/StartATurn")
    public List<Card> StartATurn() {
        game.resetDeck();
        return game.getCardsInHand();
    }

    @PostMapping(value = "/DiscardCard")
    public List<Card> DiscardTheCard(@PathVariable("cardNumber") @NotNull @Length(min = 1) int cardNumber){
        return game.discardTheCardFromHand(cardNumber);
    }

    @PostMapping(value = "/EndTurn")
    public int EndTurn() {
        game.drawFullHand();
        return game.evaluateProfitFromTurn();
    }
}