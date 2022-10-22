class Tv { 
    int channel;
    int volume;

    Tv(){
        this(1,1);
    }
    Tv(int channel, int volume){
        this.channel=channel;
        this.volume=volume;
    }

    void ChannelUp(){
        channel++;
    }
    void ChannelDown(){
        channel--;
    }
    void VolumeUp(){
        volume++;
    }
    void VolumeDown(){
        volume--;
    }
}
class SmartTv extends Tv{
    boolean connection;
    SmartTv(){
        this(1,1,false);
    }
    SmartTv(int channel,int volume, boolean connection){
        super(channel, volume);
        this.connection=connection;
    }
    void ConnectionOnOff(){
        connection = !connection;
        System.out.println("인터넷 연결 여부 : " + connection);
    }
}

public class Method{
    
    static void Method1(){
        System.out.println("Study");
    }

    public static void main(String[] args) {
        Method1();
        Tv t = new Tv();
        System.out.println(t.channel);
        System.out.println(t.volume);
        Tv t2 = new Tv(5,10);
        System.out.println(t2.channel);
        System.out.println(t2.volume);
        
        t.ChannelUp();
        t.VolumeUp();
        System.out.println(t.channel);
        System.out.println(t.volume);
        t.ChannelDown();
        t.VolumeDown();
        System.out.println(t.channel);
        System.out.println(t.volume);
        
        t=t2;
        System.out.println(t.channel);
        System.out.println(t.volume);

        SmartTv st = new SmartTv(10,15,true);
        System.out.println(st.channel);
        System.out.println(st.volume);
        System.out.println(st.connection);
        
        SmartTv st2 = new SmartTv();
        System.out.println(st2.channel);
        System.out.println(st2.volume);
        System.out.println(st2.connection);
        
        st.ChannelUp();
        st.VolumeUp();
        st.ConnectionOnOff();
        System.out.println(st.channel);
        System.out.println(st.volume);
        System.out.println(st.connection);

        st.ConnectionOnOff();
        System.out.println(st.connection);

        //혼자 예습한다고 멋대로 짜본 코드임
    }
}