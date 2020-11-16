package threadcommunication;

public class MySignal {

    protected boolean signal = false;

    public synchronized boolean getSignal(){
        return this.signal;
    }

    public synchronized void setSignal(boolean signal){
        this.signal = signal;
    }

}
