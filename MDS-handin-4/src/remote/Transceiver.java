package remote;

/**
 * An interface for an object which actively receives and sends objects from and
 * to corresponding transceivers, transmitters and receivers.
 *
 * @param <I> The type of the objects which will be received.
 * @param <O> The type of the objects which will be sent.
 */
public interface Transceiver<I, O> extends Receiver<I>, Transmitter<O> {
}