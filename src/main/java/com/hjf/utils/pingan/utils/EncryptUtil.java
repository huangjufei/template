package com.hjf.utils.pingan.utils;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 放入文件流,返回文件流的md5或sha-1的字符串
 *
 * 1.MD5(Message Digest algorithm 5，信息摘要算法)
 * 2.SHA(Secure Hash Algorithm，安全散列算法)
 *
 * SHA-1 VS MD5
 * 因为二者均由MD4导出，SHA-1和MD5彼此很相似。相应的，他们的强度和其他特性也是相似，但还有以下几点不同：
 * 1.对强行攻击的安全性：最显著和最重要的区别是SHA-1摘要比MD5摘要长32 位。使用强行技术，产生任何一个报文使其摘要等于给定报摘要的难度对MD5是2128数量级的操作，而对SHA-1则是2160数量级的操作。这样，SHA-1对强行攻击有更大的强度。
 * 2.对密码分析的安全性：由于MD5的设计，易受密码分析的攻击，SHA-1显得不易受这样的攻击。
 * 3.速度：在相同的硬件上，SHA-1的运行速度比MD5慢。
 */
public class EncryptUtil {

    private EncryptUtil() {
    }

    public static String getFileMD5(InputStream inputStream) {

        return getFile(inputStream, "MD5");
    }

    public static String getFileSha1(InputStream inputStream) {

        return getFile(inputStream, "SHA-1");
    }

    private static String getFile(InputStream inputStream, String code) {
        MessageDigest digest = null;
        InputStream in = null;
        byte[] buffer = new byte[8192];
        int len;

        try {
            digest = MessageDigest.getInstance(code);
            in = inputStream;

            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            Logger.error(EncryptUtil.class, e.getMessage(), e);
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                Logger.error(EncryptUtil.class, e.getMessage(), e);
            }
        }
    }
}
