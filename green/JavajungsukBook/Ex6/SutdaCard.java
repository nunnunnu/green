public class SutdaCard {
  int num;
  boolean iskwang;

  public SutdaCard(){
    this(1,true);
  } 
  public SutdaCard(int num, boolean isKwang){
    this.num = num;
    this.iskwang = isKwang;
  } 
  String info(){
    return num+(iskwang?"K":"");
  }
  @Override
  public String toString(){
    return num+(iskwang?"K":"");
  }
}

