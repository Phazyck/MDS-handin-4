package remote.udp;

import java.io.*;
import java.net.*;
import remote.Receiver;

/**
 * A receiver which receives Strings through UDP.
 */
public class UdpStringReceiver implements Receiver<String> {

    private DatagramSocket socket;
    private byte[] buffer;

    /**
     * Constructs a UdpReceiver with port = 4445 and bufferLength = 256.
     *
     * @throws SocketException if the socket could not be opened, or the socket
     * could not bind to the specified local port.
     */
    public UdpStringReceiver() throws SocketException {
        this(4445, 256);
    }

    /**
     * Constructs a UdpReceiver.
     *
     * @param port The port on which the receiver should listen for messages.
     * @param bufferLength The length of the buffer.
     * @throws SocketException if the socket could not be opened, or the socket
     * could not bind to the specified local port.
     */
    public UdpStringReceiver(int port, int bufferLength) throws SocketException {
        socket = new DatagramSocket(port);
        buffer = new byte[bufferLength];
    }

    /**
     * Receive a string from a transmitter.
     *
     * @return The string.
     */
    @Override
    public String receive() {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return new String(packet.getData(), 0, packet.getLength());
    }
}