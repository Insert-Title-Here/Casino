
public class Card {
  private String suit;
  private String name;

  public Card(String suit, String name) {
    this.suit = suit;
    this.name = name;
  }

  public String toString(){
    return name + " of " + suit;
    
  }

  public String getSuit() {
    return suit;
  }

  public String getName() {
    return name;
  }

  public int compareTo(Card other1){
    int otherName;
    int name1;
    //Card other1 = (Card) other;

    if(other1.getName().equals("Ace")){
      otherName = 1;
    }else if(other1.getName().equals("Jack")){
      otherName = 11;
    }else if(other1.getName().equals("Queen")){
      otherName = 12;
    }else if(other1.getName().equals("King")){
      otherName = 13;
    }else{
      otherName = Integer.parseInt(other1.getName());
    }

    if(name.equals("Ace")){
      name1 = 1;
    }else if(name.equals("Jack")){
      name1 = 11;
    }else if(name.equals("Queen")){
      name1 = 12;
    }else if(name.equals("King")){
      name1 = 13;
    }else{
      name1 = Integer.parseInt(name);
    }

    if(name1 > otherName){
      return 1;

    }else{
    	
      return -1;
    }
    
    
    
  }

  public int suitCompare(Card other1) {
	  //Card other1 = (Card) other
	  int suitArrange;
	  int otherArrange;
	  
	  if(suit.equalsIgnoreCase("Clubs")) {
		  suitArrange = 1;
	  }
	  
	  return 0;
  }
  
}
