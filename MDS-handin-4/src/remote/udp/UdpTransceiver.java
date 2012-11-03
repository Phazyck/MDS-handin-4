package remote.udp;

import java.net.*;
import remote.Transceiver;

public class UdpTransceiver implements Transceiver {

    /**
     * Try out the transceiver (and thus also the transmitter and receiver).
     */
    public static void main(String[] args) throws UnknownHostException, SocketException {        
        UdpTransceiver a = new UdpTransceiver(null, new UdpTransmitter("localhost", 4444));
        UdpTransceiver b = new UdpTransceiver(new UdpReceiver(4444, 256), null);
        String msgA = "Hello world!";
        System.out.println("A->B : " + msgA);
        a.transmit(msgA);                
        System.out.println("B<-A : " + b.receive());        
        String msgB = "Hello object!";
        System.out.println("B->A : " + msgB);
        b.transmit(msgB);
        System.out.println("A<-B : " + a.receive());
    }
    private UdpReceiver in;
    private UdpTransmitter out;

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
    public UdpTransceiver(UdpReceiver in, UdpTransmitter out) throws SocketException, UnknownHostException {
        this.in = in == null ? new UdpReceiver() : in;
        this.out = out == null ? new UdpTransmitter() : out;
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
    public UdpTransceiver(int in, int bufferLength, String host, int out) throws UnknownHostException, SocketException {
        this(new UdpReceiver(in, bufferLength), new UdpTransmitter(host, out));
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
