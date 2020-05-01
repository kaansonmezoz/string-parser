package com.kaansonmezoz.objectutils.exception;

public class DefaultException extends ObjectCreatorException {
    private static final String MESSAGE_TEMPLATE = "Failed to create object of %s. %s";

    DefaultException(Throwable cause, Class source) {
        super(cause, source);
    }

    @Override
    protected String getMessageTemplate() {
        return MESSAGE_TEMPLATE;
    }

    @Override
    protected Object[] getMessageArgs() {
        return new Object[]{
                super.source.getCanonicalName(),
                super.getCause().getMessage()
        };
    }
}
