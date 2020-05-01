package com.kaansonmezoz.objectutils.exception;

public class AccessModifierException extends ObjectCreatorException {
    private static final String MESSAGE_TEMPLATE = "Exceeding the access rights in %s. %s";

    protected AccessModifierException(Throwable cause, Class source) {
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
