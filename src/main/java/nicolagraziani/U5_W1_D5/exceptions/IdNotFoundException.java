package nicolagraziani.U5_W1_D5.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(long id) {
        super("L'elemento con id: " + id + " non è stato trovato");
    }
}
