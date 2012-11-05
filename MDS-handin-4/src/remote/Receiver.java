package remote;

/**
 * An interface for an object which actively receives objects from
 * corresponding transmitters.
 *
 * @param <I> The type of the objects which will be received.
 */
public interface Receiver<I> {

    /**
     * Receive an object from a transmitter.
     *
     * @return The object.
     */
    public I receive();
}