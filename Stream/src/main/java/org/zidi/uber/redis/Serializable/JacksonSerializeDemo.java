package org.zidi.uber.redis.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User(1L, "zidi");

        ObjectMapper mapper = new ObjectMapper();

        // 👉 序列化成 JSON 字符串
        String json = mapper.writeValueAsString(user);
        System.out.println("Jackson 序列化结果（可读）：");
        System.out.println(json);

        // 👉 反序列化：JSON ➜ Java 对象
        User user2 = mapper.readValue(json, User.class);
        System.out.println("反序列化后对象：" + user2.getName());
    }
}
