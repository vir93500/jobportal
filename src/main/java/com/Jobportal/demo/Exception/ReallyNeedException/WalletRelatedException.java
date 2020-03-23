/*
package com.Jobportal.demo.Exception;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString(callSuper = true)
public class WalletRelatedException extends GenericException {

    {
        this.setExceptionCause(this.getClass());
    }

    public WalletRelatedException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public WalletRelatedException(String errCode, String errMsg, Throwable cause) {
        super(errCode, errMsg, cause);
    }

    public WalletRelatedException(ExceptionCodes userNotFound) {
        super(userNotFound.errCode(),userNotFound.errMsg());
    }
}
*/
