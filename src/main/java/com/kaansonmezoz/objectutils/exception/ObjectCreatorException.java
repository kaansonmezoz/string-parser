package com.kaansonmezoz.objectutils.exception;


public abstract class ObjectCreatorException extends RuntimeException {
    protected final Class source;

    protected ObjectCreatorException(Throwable cause, Class source){
        super(cause);
        this.source = source;
    }

    @Override
    // Message content will be changed subclass to subclass
    // Constructor in common will be invoked in ExceptionMapper
    // So, if message template and message args were passed to the constructor
    // it would be impossible invoke that constructor
    public String getMessage() {
        return String.format(getMessageTemplate(), getMessageArgs());
    }

    abstract protected String getMessageTemplate();
    abstract protected Object[] getMessageArgs();
}