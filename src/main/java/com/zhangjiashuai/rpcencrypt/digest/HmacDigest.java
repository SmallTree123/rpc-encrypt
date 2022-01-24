package com.zhangjiashuai.rpcencrypt.digest;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.zhangjiashuai.rpcencrypt.entity.ClientInfo;

/**
 * hmac摘要
 */
public class HmacDigest implements Digest {

    private static final HmacAlgorithm HMAC_ALGORITHM = HmacAlgorithm.HmacSHA256;

    @Override
    public String digestPayload(String payload, ClientInfo clientInfo) {
        String salt = clientInfo.getPublicKeyServer() + clientInfo.getClientSecret();
        HMac hmac = DigestUtil.hmac(HMAC_ALGORITHM, StrUtil.bytes(salt));
        return hmac.digestHex(payload);
    }

    @Override
    public String getAlgorithm() {
        return HMAC_ALGORITHM.getValue();
    }
}