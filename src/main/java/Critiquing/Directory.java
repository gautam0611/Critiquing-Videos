package Critiquing;

/**
 * An interface used to perform operations on various directories such as folders and files
 *
 * @param <T> a directory type which will be either a folder or file
 */
public interface Directory<T> {

    /**
     * A method used to create a specific directory type in a certain location.
     *
     * @param type The type of the directory type that we want to create
     * @param path The path of where we will be creating that type
     */
    public void create(T type, String path);

    
}
