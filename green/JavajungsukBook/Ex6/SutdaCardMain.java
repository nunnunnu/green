public class SutdaCardMain {
  public static void main(String[] args) {
    // SutdaCard card1 = new SutdaCard(3, false);
    // SutdaCard card2 = new SutdaCard();

    // System.out.println(card1.info());
    // System.out.println(card2.info());

    SutdaDeck deck = new SutdaDeck();
    
    for(int i=0;i<deck.cards.size();i++){
      System.out.print(deck.cards.get(i)+", ");
    }
    System.out.println();
    System.out.println(deck.pick());
    System.out.println(deck.pick(3));
    
    deck.shuffle();
    for(int i=0;i<deck.cards.size();i++){
      System.out.print(deck.cards.get(i)+", ");
    }
  }
}
