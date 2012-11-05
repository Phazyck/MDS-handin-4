package remote.udp;

import java.net.*;
import remote.Transceiver;

/**
 * A transceiver which sends/receives Strings through UDP.
 */
public class UdpStringTransceiver implements Transceiver<String,String> {

    /**
     * Try out the transceiver (and thus also the transmitter and receiver).
     */
    public static void main(String[] args) throws UnknownHostException, SocketException {        
        UdpStringTransceiver a = new UdpStringTransceiver(null, new UdpStringTransmitter("localhost", 4444));
        UdpStringTransceiver b = new UdpStringTransceiver(new UdpStringReceiver(4444, 256), null);
        String msgA = "Hello world!";
        System.out.println("A->B : " + msgA);
        a.transmit(msgA);                
        System.out.println("B<-A : " + b.receive());        
        String msgB = "Hello object!";
        System.out.println("B->A : " + msgB);
        b.transmit(msgB);
        System.out.println("A<-B : " + a.receive());
    }
    private UdpStringReceiver in;
    private UdpStringTransmitter out;

    /**
     * Constructs a UdpTransceiver by putting together a UdpReceiver and a
     * UdpTransmitter.
     * 
     * NOTE: Using null in both parameters will result in a transceiver that communicates with itself.
     *
     * @param in The receiver part. Use null to use the default UdpReceiver.
     * @param out The transmitter part. Use null to use the default
     * UdpTransmitter.
     * @throws UnknownHostException
     * @throws SocketException
     */
    public UdpStringTransceiver(UdpStringReceiver in, UdpStringTransmitter out) throws SocketException, UnknownHostException {
        this.in = in == null ? new UdpStringReceiver() : in;
        this.out = out == null ? new UdpStringTransmitter() : out;
    }

    /**
     * Constructs a UdpTransceiver.
     *
     * @param in The port on which the receiver should listen for messages.
     * @param bufferLength The length of the buffer.
     * @param host The name of the host.
     * @param out The target port for transmission.
     * @throws UnknownHostException
     * @throws SocketException
     */
    public UdpStringTransceiver(int in, int bufferLength, String host, int out) throws UnknownHostException, SocketException {
        this(new UdpStringReceiver(in, bufferLength), new UdpStringTransmitter(host, out));
    }

    @Override
    public void transmit(String message) {
        out.transmit(message);
    }

    @Override
    public String receive() {
        return in.receive();
    }
}
