package br.org.fiergs.grp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Item id=" + id + " não encontrado no cadastro.");
    }


}