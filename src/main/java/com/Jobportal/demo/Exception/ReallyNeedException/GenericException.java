/*
package com.Jobportal.demo.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@NoArgsConstructor
public abstract class GenericException extends RuntimeException {

    */
/**
     *
     *//*

    private static final long serialVersionUID = 9090267457260926978L;

    private String errCode;
    private String errMsg;
    private boolean retryable = false;

    @Setter
    private Class<? extends com.Jobportal.demo.Exception.GenericException> exceptionCause;

    {
        this.setExceptionCause(this.getClass());
    }

    */
/**
     * Constructs a new runtime exception with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by a call to
     * {@link #initCause}.
     *
     * @param error   code, The error code is saved for later retrieval by the
     *                {@link #getErrCode()}
     * @param message the detail message. The detail message is saved for later
     *                retrieval by the {@link #getErrMsg()()} method.
     *//*

    public GenericException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    */
/**
     * Constructs a new runtime exception with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by a call to
     * {@link #initCause}.
     *
     * @param error   code, The error code is saved for later retrieval by the
     *                {@link #getErrCode()}
     * @param message the detail message. The detail message is saved for later
     *                retrieval by the {@link #getErrMsg()()} method.
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method). (A {@code null} value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     *//*


    public GenericException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
        this.errMsg = message;
    }

}
*/
