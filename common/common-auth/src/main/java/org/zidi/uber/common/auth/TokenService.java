package org.zidi.uber.common.auth;

// common-auth 模块
public interface TokenService {

    /**
     * 根据 token 获取用户 ID
     */
    Long getUserIdByToken(String token);

    /**
     * 生成一个新的 token，并保存映射关系（如存入 Redis）
     */
    String generateToken(Long userId);

    void saveToken(String token, Long userId);

    /**
     * 删除 token 映射（登出）
     */
    void removeToken(String token);
}
