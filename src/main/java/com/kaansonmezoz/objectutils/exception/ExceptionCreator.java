package com.kaansonmezoz.objectutils.exception;

@FunctionalInterface
interface ExceptionCreator<Throwable, Class, ObjectCreatorException> {
    ObjectCreatorException create(Throwable cause, Class source);
}
