package concurrent;

import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.*;
import serialization.Cal;
import static serialization.util.Serializer.*;

public class AutoSave implements Runnable {

    private final Cal cal;
    private final int saveInterval;
    private final String path;

    public AutoSave(Cal cal, String path, int secondInterval) {
        this.cal = cal;
        this.saveInterval = secondInterval;
        this.path = path;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(saveInterval);
                FileOutputStream out;
                try {
                    out = new FileOutputStream(path, false);
                } catch (IOException ex) {
                    System.out.println(ex);
                    continue;
                }
                out.flush();
                out.write(serialize(cal).getBytes());
                out.close();
            } catch (InterruptedException | JAXBException | IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
