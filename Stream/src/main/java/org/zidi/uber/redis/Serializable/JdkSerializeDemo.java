package org.zidi.uber.redis.Serializable;

import java.io.*;

public class JdkSerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User(1L, "zidi");

        // 👉 序列化：对象变成 byte[]
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(user);
        byte[] bytes = byteOut.toByteArray();

        System.out.println("JDK 序列化结果（看不懂）：");
        System.out.println(new String(bytes));  // 输出乱码

        // 👉 反序列化：byte[] 还原成对象
        ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(byteIn);
        User newUser = (User) in.readObject();

        System.out.println("反序列化后对象：" + newUser);
    }
}
