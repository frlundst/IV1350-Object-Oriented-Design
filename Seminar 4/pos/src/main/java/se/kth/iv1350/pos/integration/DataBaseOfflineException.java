package se.kth.iv1350.pos.integration;
/**
 * DataBaseOfflineException is an exception for when the database is offline.
 */
public class DataBaseOfflineException extends Exception{
    /**
     * This method creates an instance of DataBaseOfflineException
     * @param message is used for storing the exception message that is logged.
     */
    public DataBaseOfflineException(String message){
        super(message);
    }
}
