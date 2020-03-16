package com.Jobportal.demo.Common;

import com.axisbank.common.error.impl.CommonException;
import com.axisbank.common.error.impl.ExceptionCodes;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a HREF="mailto:deepak.jeena@freecharge.com">DeepakJeena</a>
 * @since 1.0
 */

public class AESCipherHelper {

    private static final String KEY_ALGORITHM_V1 = "AES";

    private static final String AES_HASH_ALGORITHM = "SHA-256";

    private final Cipher encryptCipher;
    private final Cipher decryptCipher;

    public AESCipherHelper(String secretKey) {
	try {
	    Key secretKeyV1 = buildKeyAES(secretKey, KEY_ALGORITHM_V1);
	    encryptCipher = Cipher.getInstance(secretKeyV1.getAlgorithm());
	    decryptCipher = Cipher.getInstance(secretKeyV1.getAlgorithm());
	    // Set the mode for encrypt and decrypt.
	    encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeyV1);
	    decryptCipher.init(Cipher.DECRYPT_MODE, secretKeyV1);
	} catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException
	        | InvalidKeyException e) {
	    throw new CommonException(ExceptionCodes.CHIPER_INIT_ERROR, e);
	}
    }

    private Key buildKeyAES(String password, String algorithm)
        throws NoSuchAlgorithmException, UnsupportedEncodingException {
	MessageDigest digester = MessageDigest.getInstance(AES_HASH_ALGORITHM);
	digester.reset();
	digester.update(password.getBytes(StandardCharsets.UTF_8));
	byte[] key = digester.digest();
	return new SecretKeySpec(key, 0, 16, algorithm);
    }

    public String decrypt(String token) {

	byte[] decodedToken = Base64.decodeBase64(token);
	byte[] decryptedToken = null;
	try {
	    decryptedToken = decryptCipher.doFinal(decodedToken);
	} catch (IllegalBlockSizeException | BadPaddingException e) {
	    throw new CommonException(ExceptionCodes.CHIPER_ENCRYPTION_ERROR, e);
	}
	return new String(decryptedToken);
    }

    public String encrypt(String uniqueId) {
	byte[] text = uniqueId.getBytes();
	byte[] textEncrypted;
	try {
	    textEncrypted = encryptCipher.doFinal(text);
	    byte[] token = Base64.encodeBase64URLSafe(textEncrypted);
	    return new String(token);
	} catch (IllegalBlockSizeException | BadPaddingException e) {
	    throw new CommonException(ExceptionCodes.CHIPER_ENCRYPTION_ERROR, e);
	}
    }
}
