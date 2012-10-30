package taskmanager.udp;



import java.util.concurrent.*;

public class UdpManagerServer implements Runnable {
    public static void main(String[] args) {
       ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new UdpManagerServer());
        exec.shutdown(); 
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
