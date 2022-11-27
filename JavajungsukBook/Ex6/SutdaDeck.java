import java.util.ArrayList;
import java.util.List;

public class SutdaDeck{
  final int CARD_NUM = 20;
  // SutdaCard[] cards = new SutdaCard[CARD_NUM];

  List<SutdaCard> cards = new ArrayList<SutdaCard>();

  public SutdaDeck(){
  
    // int num;
    // boolean isKwang;
    // for(int i=0;i<10;i++){
    //   isKwang = i==0 || i==2 || i==7;
    //   cards[i] = new SutdaCard(i+1, isKwang);
    //   cards[i+10] = new SutdaCard(i+1, false);
    // }
    
    // for(int i=0;i<CARD_NUM;i++){
    //   num = i+1;
    //   isKwang = false;
    //   if(i>=10) num=i-9;
    //   else if(i==0 || i==2 ||i==7) isKwang=true;
    //   cards[i] = new SutdaCard(num, isKwang);
    // }

    // for(int i=0;i<CARD_NUM;i++){
    //   num = i%10+1;
    //   isKwang = (i==1 || i==3 || i==8);
    //   cards[i] = new SutdaCard(num, isKwang);
    // }

    for(int i=0;i<CARD_NUM;i++){
      int num = i%10+1;
      boolean isKwang = (i==1 || i==3 || i==8);
      cards.add(new SutdaCard(num, isKwang));
    }

    
  }
  SutdaCard pick(int index){
    return cards.get(index);
  }
  SutdaCard pick(){
    int r = (int)(Math.random()*CARD_NUM);
    
    return cards.get(r);
  }
  void shuffle(){
    List<SutdaCard> temp = new ArrayList<SutdaCard>();
    while(cards.size()!=0){
        int r = (int)(Math.random()*cards.size());
        temp.add(cards.remove(r)); //temp에 저장 후 cards에서 삭제
    }
    cards = temp;
    // boolean[] sel = new boolean[CARD_NUM]; //이전에 뽑은적있는카드면 true로 바뀜. 
    // SutdaCard[] temp = new SutdaCard[CARD_NUM];
    // int i=0;
    // while(i<CARD_NUM){
    //   int r = (int)(Math.random()*CARD_NUM);
    //   if(sel[r]==true) continue; //뽑은적있는카드면 continue
    //   temp[i] = cards[r];
    //   sel[r] = true;
    //   i++;
    // }
    // for(int j=0;j<CARD_NUM;j++){
    //   cards[j] =  temp[j];
    // }
    
    
  }

}