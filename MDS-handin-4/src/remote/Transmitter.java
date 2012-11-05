package remote;

/**
 * An interface for an object which actively sends objects to corresponding
 * receivers.
 *
 * @param <O> The type of the objects which will be sent.
 */
public interface Transmitter<O> {

    /**
     * Transmit an object to a receiver.
     *
     * @param object The object.
     */
    public void transmit(O object);
}
