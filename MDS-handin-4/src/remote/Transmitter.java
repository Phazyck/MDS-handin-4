package remote;

/**
 * An interface for an object which actively transmits messages to receivers.
 */
public interface Transmitter {
    /**
     * Transmit a message to a receiver.
     * @param message The message.
     */
    public void transmit(String message);
}
