package com.estudo.publication.lang;

public class FallbackException extends RuntimeException {

    public FallbackException() {
        super();
    }

    public FallbackException(String message) {
        super(message);
    }

    public FallbackException(String message, Throwable cause) {
        super(message, cause);
    }

    public FallbackException(Throwable cause) {
        super("Estamos com indisponibilidade no momento, por favor, tente novamente mais tarde.", cause);
    }

    protected FallbackException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
