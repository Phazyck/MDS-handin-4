package remote;

/**
 * An interface for an object which actively receives messages from transmitters.
 */
public interface Receiver {
    /**
     * Receive a message from a transmitter.
     * @return The message.
     */
    public String receive();    
}