package com.zhangjiashuai.rpcencrypt.sign;

import com.zhangjiashuai.rpcencrypt.cipher.Cipher;
import com.zhangjiashuai.rpcencrypt.common.Algorithm;
import com.zhangjiashuai.rpcencrypt.digest.Digest;
import com.zhangjiashuai.rpcencrypt.entity.ClientInfo;
import com.zhangjiashuai.rpcencrypt.entity.StatefulRequestPayload;

import java.security.KeyPair;

/**
 * 签名接口
 * 非对称加密少量数据，拼接报文摘要
 */
public interface Signature extends Algorithm {

    String SIGN_SEPARATOR = ".";

    default String getStr2Sign(StatefulRequestPayload requestPayload) {
        ClientInfo clientInfo = requestPayload.getClientInfo();
        return clientInfo.getClientId() + clientInfo.getClientSecret();
    }

    boolean serverValidate(StatefulRequestPayload requestPayload) throws SignatureMismatchException;

    String clientSign(StatefulRequestPayload requestPayload);

    /**
     * 生成随机密钥对
     * @return
     */
    KeyPair generateKeyPair();

    void setDigest(Digest digest);

    void setCipher(Cipher cipher);

    Digest getDigest();

    Cipher getCipher();
}
