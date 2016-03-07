package math.design.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES {


	// 解密数据
	public static String decrypt(String message) throws Exception {

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(sKey.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(sKey.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte,"UTF-8");
	}

	// 加密数据
	public static String encrypt(String message) throws Exception {
		StringBuffer hexString = new StringBuffer();
		
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(sKey.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(sKey.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

//		byte bytes[] = cipher.doFinal(message.toLowerCase().getBytes("UTF-8"));
		byte bytes[] = cipher.doFinal(message.getBytes("UTF-8"));
		for (int i = 0; i < bytes.length; i++) {
			String plainText = Integer.toHexString(0xff & bytes[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}

		return hexString.toString().toUpperCase();
	}

	public static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		return digest;
	}

	// 加密密钥
	private static String sKey = "tlLJ1q2w";

	public static void main(String[] args) throws Exception {
		String jiami = "刘剑lasdfhalsdkjflaskjdflasdlfskdyus;qohjfdapuihmczxhjm;aslrtfj";

		System.out.println("加密数据:" + jiami);
		String a = DES.encrypt(jiami);
		System.out.println("加密后的数据:" + a);
		//                      5951A3070C2BE6F68EF0E290B91A7A7B80DE1CF0B1D5C432CED3BF47906424AB
		String b = DES.decrypt(a);
		System.out.println("解密后的数据:" + b);

	}

}
