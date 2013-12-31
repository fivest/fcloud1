/**
 * 
 */
package com.fcloud.util.crypto;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 */
public class RSAUtils {
	
	private static String encodeBase64(byte[] keyBytes) {
		return new Base64().encodeToString(keyBytes);
	}
	
	private static byte[] decodeBase64(String key) {
		return new Base64().decode(key.getBytes(Charsets.UTF_8));
	}

	public static RSAKeyPair generateKeyPair() {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			return new RSAKeyPair(keyPair);
		} catch (Exception e) {
			throw new RSAException("PublicKey encrypt:", e);
		}
	}
	
	public static String getKeyString(Key key) {
		byte[] keyBytes = key.getEncoded();
		return encodeBase64(keyBytes);
	}
	
	public static PublicKey decodePublicKey(String key) {
		try {
			byte[] keyBytes = decodeBase64(key);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			throw new RSAException("PublicKey decodePublicKey:", e);
		}
	}
	
	public static PrivateKey decodePrivateKey(String key) {
		try {
			byte[] keyBytes = decodeBase64(key);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			throw new RSAException("PrivateKey decodePrivateKey:", e);
		}
	}
	
	public static String encryptByPublicKey(String publicKey, String data) {
		return encodeBase64(encrypt(decodePublicKey(publicKey), data.getBytes(Charsets.UTF_8)));
	}
	
	public static byte[] encrypt(PublicKey publicKey, byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RSAException("PublicKey encrypt:", e);
		}
	}
	
	public static String decryptByPrivateKey(String privateKey, String base64Data) {
		return new String(decrypt(decodePrivateKey(privateKey), decodeBase64(base64Data)));
	}
	
	public static byte[] decrypt(PrivateKey privateKey, byte[] data){
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RSAException("PrivateKey decrypt:", e);
		}
	}
	
	public static void writeToFile(RSAKeyPair keyPair, File fold) throws IOException {
		File publicFile = new File(fold, "PublicKey.keystore");
		File privateFile = new File(fold, "PrivateKey.keystore");
		FileUtils.write(publicFile, keyPair.getPublicKeyString());
		FileUtils.write(privateFile, keyPair.getPrivateKeyString());
	}
	
	@SuppressWarnings("serial")
	public static class RSAException extends RuntimeException {

		public RSAException(String message, Throwable cause) {
			super(message, cause);
		}
		
	}
	
	public static class RSAKeyPair {
		
		private final KeyPair keyPair;

		public RSAKeyPair(KeyPair keyPair) {
			super();
			this.keyPair = keyPair;
		}
		
		public RSAPublicKey getPublicKey() {
			return (RSAPublicKey) this.keyPair.getPublic();
		}
		
		public RSAPrivateKey getPrivateKey() {
			return (RSAPrivateKey) this.keyPair.getPrivate();
		}
		
		public String getPublicKeyString() {
			return getKeyString(getPublicKey());
		}
		
		public String getPrivateKeyString() {
			return getKeyString(getPrivateKey());
		}
	}
	
	/// 生成许可文件
	private static void GenrateKeyPairToFile(File fold) throws IOException {
		RSAKeyPair keyPair = generateKeyPair();
//		String publicKey = keyPair.getPublicKeyString();
//		String privateKey = keyPair.getPrivateKeyString();
		writeToFile(keyPair, fold);
	}
	
	private static void EncryptFileByPublicKey(File fold, File src, File target) throws IOException {
		String publicKey = FileUtils.readFileToString(new File(fold, "PublicKey.keystore"), "UTF-8");
		String content = FileUtils.readFileToString(src, "UTF-8");
		String encryptConent = encryptByPublicKey(publicKey, content);
		FileUtils.write(target, encryptConent, "UTF-8");
	}
	
	public static void main(String[] args) throws IOException {
		
		//GenrateKeyPairToFile(new File("~/ruben")); // 生成许可目录
		
		// 加密指定文件
		EncryptFileByPublicKey(new File("~/ruben"), 
				new File("/Users/ruben/ruben/keplerspace/wechat/src/test/resources/fcloud.license.properties"), 
				new File("/Users/ruben/ruben/keplerspace/wechat/src/main/resources/fcloud.license"));
	}
}
