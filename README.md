# Demo - Deck of Cards Game

Assignment: to code, in Java  a set of classes and a REST API that represent a deck of poker-style playing cards along with the services for a very basic game between multiple players holding cards. A deck is defined as follows:  Fifty-two playing cards in four suits: hearts, spades, clubs, and diamonds, with face values of Ace, 2-10, Jack, Queen, and King.

The game API is a very basic game in which one or more decks are added to create a ‘game deck’, commonly referred to as a shoe, along with a group of players getting cards from the game deck.

## Usage

operations and how to use it:

Create a game
```js
curl -X POST http://localhost:8080/demo/games/
```

Delete a game
```js
curl -X DELETE http://localhost:8080/demo/games/{gameid}
```

Create a deck
```js
curl -X POST http://localhost:8080/demo/games/{gameid}/deck
```
