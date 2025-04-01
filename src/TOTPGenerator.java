import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TOTPGenerator {

    private static final String TOTP_ALGORITHM = "HmacSHA1";
    private static final int TIME_STEP = 30; // 30秒的时间步长
    private static final int DIGITS = 6; // 6位验证码

    public static void main(String[] args) {
        String secret = "I3OVBKZQ3NCUXDYK";
        System.out.println("Generated TOTP code: " + generateTOTP(secret));
    }

    public static String generateTOTP(String secret) {
        try {
            // 解码Base32格式的密钥
            byte[] keyBytes = decodeBase32(secret);

            // 获取当前时间步数
            long timeStep = System.currentTimeMillis() / 1000 / TIME_STEP;

            // 将时间步数转换为字节数组
            byte[] timeBytes = ByteBuffer.allocate(8).putLong(timeStep).array();

            // 计算HMAC-SHA1哈希
            byte[] hmac = calculateHmacSha1(keyBytes, timeBytes);

            // 从HMAC结果中提取动态密码
            int offset = hmac[hmac.length - 1] & 0x0F;
            int binary = ((hmac[offset] & 0x7F) << 24) |
                    ((hmac[offset + 1] & 0xFF) << 16) |
                    ((hmac[offset + 2] & 0xFF) << 8) |
                    (hmac[offset + 3] & 0xFF);

            int otp = binary % (int) Math.pow(10, DIGITS);

            return String.format("%06d", otp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] calculateHmacSha1(byte[] key, byte[] data)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signKey = new SecretKeySpec(key, TOTP_ALGORITHM);
        Mac mac = Mac.getInstance(TOTP_ALGORITHM);
        mac.init(signKey);
        return mac.doFinal(data);
    }

    private static byte[] decodeBase32(String secret) {
        String base32 = secret.toUpperCase().replaceAll("[^A-Z2-7]", "");
        Base32 base32Decoder = new Base32();
        return base32Decoder.decode(base32);
    }

    // 简单的Base32解码实现
    private static class Base32 {
        private static final String BASE32_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
        private static final int[] BASE32_LOOKUP = new int[256];

        static {
            for (int i = 0; i < BASE32_LOOKUP.length; i++) {
                BASE32_LOOKUP[i] = -1;
            }
            for (int i = 0; i < BASE32_CHARS.length(); i++) {
                BASE32_LOOKUP[BASE32_CHARS.charAt(i)] = i;
            }
        }

        public byte[] decode(String encoded) {
            encoded = encoded.trim().replaceAll("=", "");
            if (encoded.isEmpty()) {
                return new byte[0];
            }

            int encodedLength = encoded.length();
            int outLength = encodedLength * 5 / 8;
            byte[] result = new byte[outLength];

            int buffer = 0;
            int next = 0;
            int bitsLeft = 0;

            for (char c : encoded.toCharArray()) {
                if (c > 255 || BASE32_LOOKUP[c] == -1) {
                    throw new IllegalArgumentException("Invalid Base32 character: " + c);
                }

                buffer <<= 5;
                buffer |= BASE32_LOOKUP[c] & 0x1F;
                bitsLeft += 5;
                if (bitsLeft >= 8) {
                    result[next++] = (byte) (buffer >> (bitsLeft - 8));
                    bitsLeft -= 8;
                }
            }

            return result;
        }
    }
}