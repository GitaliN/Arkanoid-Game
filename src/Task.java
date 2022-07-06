/**
 * @param <T> the type parameter
 * @author Gitali Naim
 */
public interface Task<T> {

    /**
     * Run type parameter.
     *
     * @return run the type parameter
     */
    T run();
}