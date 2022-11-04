public class MyTv {
  boolean isPowerOn;
  int channel;
  int volume;

  final int MAX_VOLUME=100;
  final int MIN_VOLUME=0;
  final int MAX_CHANNEL=100;
  final int MIN_CHANNEL=1;

  void turnOnOff(){
    isPowerOn=!isPowerOn;
  }
  void VolumeUp(){
    if(volume<MAX_VOLUME){
      volume++;
    }
  }
  void VolumeDown(){
    if(volume>MIN_VOLUME){
      volume--;
    }
  }
  void ChannelUp(){
    if(channel==MAX_CHANNEL){
      channel=MIN_CHANNEL;
    }else{
      channel++;
    }
  }
  void ChannelDown(){
    if(channel==MIN_CHANNEL){
      channel=MAX_CHANNEL;
    }else{
      channel--;
    }
  }
  void showStatus(){
    System.out.println("CH:"+channel+", VOL:"+volume);
    
  }

  public static void main(String[] args) {
    MyTv t = new MyTv();
    
    t.channel=100;
    t.volume=0;
    t.showStatus();

    t.ChannelDown();
    t.VolumeDown();
    t.showStatus();
    
    t.volume=100;
    t.ChannelUp();
    t.VolumeUp();
    t.showStatus();
    t.ChannelUp();
    t.VolumeUp();
    t.showStatus();
    t.turnOnOff();
    System.out.println("power:"+t.isPowerOn);
    t.turnOnOff();
    System.out.println("power:"+t.isPowerOn);
    t.channel=1;
    t.volume=0;
    t.showStatus();
    t.ChannelDown();
    t.VolumeDown();
    t.showStatus();

  }
}
