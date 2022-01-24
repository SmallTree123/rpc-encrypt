package com.zhangjiashuai.rpcencrypt.entity;

/**
 * 客户端信息
 */
public class ClientInfo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 客户端唯一标识
     */
    private String clientId;
    /**
     * 客户端密钥
     * 用于对称加密
     */
    private String clientSecret;
    /**
     * 服务端私钥
     * 客户端模式下为null
     */
    private String privateKeyServer;
    /**
     * 服务端公钥
     */
    private String publicKeyServer;

    public ClientInfo(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public ClientInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getPrivateKeyServer() {
        return privateKeyServer;
    }

    public void setPrivateKeyServer(String privateKeyServer) {
        this.privateKeyServer = privateKeyServer;
    }

    public String getPublicKeyServer() {
        return publicKeyServer;
    }

    public void setPublicKeyServer(String publicKeyServer) {
        this.publicKeyServer = publicKeyServer;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
//                ", clientSecret='" + clientSecret + '\'' +
//                ", privateKeyServer='" + privateKeyServer + '\'' +
//                ", publicKeyServer='" + publicKeyServer + '\'' +
                '}';
    }
}
