package se.kth.iv1350.pos.integration;
/**
 * ItemIdentifierNotValidException is an 
 * exception for when an item identifier is not found.
 */
public class ItemIdentifierNotValidException extends Exception{
    /**
     * This method creates an instance of ItemIdentifierNotValidException.
     * @param message is used for storing the exception message that is logged.
     */
    public ItemIdentifierNotValidException(String message) {
	super(message);
    }
}
