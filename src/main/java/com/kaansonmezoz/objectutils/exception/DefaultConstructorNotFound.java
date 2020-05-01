package com.kaansonmezoz.objectutils.exception;

public class DefaultConstructorNotFound extends ObjectCreatorException {
    private static final String MESSAGE_TEMPLATE = "Could not find no-args constructor in class %s";

    DefaultConstructorNotFound(Throwable cause, Class clazz) {
        super(cause, clazz);
    }

    @Override
    protected String getMessageTemplate() {
        return MESSAGE_TEMPLATE;
    }

    @Override
    protected Object[] getMessageArgs() {
        return new Object[]{super.source.getCanonicalName()};
    }
}
