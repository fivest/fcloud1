/**
 * 
 */
package com.fcloud.util.crypto;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

/**
 *
 */
public class LicenseUtils {
	
	public void doRead() {
		try {
			URL license =  LicenseUtils.class.getClassLoader().getResource("/fcloud.license");
			String text = decodeLicense(license);
			Properties prop = new Properties();
			prop.load(new StringReader(text));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String endDateStr = prop.getProperty("end.date");
			Date endDate = format.parse(endDateStr);
			Calendar endCal = Calendar.getInstance();
			endCal.setTime(endDate);
			endCal.add(Calendar.DATE, 1);
			endDate = endCal.getTime();
			if (new Date().compareTo(endDate) > 0) {
				//System.exit(0);
				Runtime.getRuntime().halt(0);
			}
			
			String copyright = prop.getProperty("copyright");
			System.out.println(copyright);
		} catch (Exception e) {
			// ignore
			//System.exit(0);
			e.printStackTrace();
			Runtime.getRuntime().halt(0);
		}
	}
	
	public String decodeLicense(URL licenseUri) throws IOException {
		char[] pk = new char[] { 'M', 'I', 'I', 'C', 'd', 'w', 'I', 'B', 'A',
				'D', 'A', 'N', 'B', 'g', 'k', 'q', 'h', 'k', 'i', 'G', '9',
				'w', '0', 'B', 'A', 'Q', 'E', 'F', 'A', 'A', 'S', 'C', 'A',
				'm', 'E', 'w', 'g', 'g', 'J', 'd', 'A', 'g', 'E', 'A', 'A',
				'o', 'G', 'B', 'A', 'I', '+', 'K', 'J', 'e', 'Q', 'p', 'c',
				'q', 'a', 'y', 'E', 'y', 'j', 'Y', 'J', 'x', 'C', 'Q', 'f',
				'V', '6', 's', 'g', 'A', 'B', 'W', 'x', 'I', 'T', 'O', 'v',
				'g', 'F', 'r', 'P', 'b', 'N', 'u', 'P', '9', '5', 'o', 'Z',
				'J', 'E', 'A', 'r', 'N', 'Q', 'J', 't', '2', 's', '4', 'Z',
				'8', 'L', '6', 'b', 'f', 'A', 'h', '1', 'T', 'y', 'B', '5',
				'q', '/', 'P', '/', 'F', '3', '9', 'M', 'a', '5', 'Y', 'Q',
				'f', '9', 'z', '0', '+', 'L', 'b', 'U', 'd', 'x', 'N', '1',
				'M', '4', '/', 'b', '/', 'l', '5', 'U', 'a', 'r', 'b', 'n',
				'I', 'A', 'k', 'b', '/', 'b', '2', 'z', 'M', 'g', '4', 'J',
				'0', 'y', 'i', 'H', 'K', 'c', 'r', 'W', '6', 'q', 'y', '7',
				'J', 'i', 'v', '9', 'P', 'k', 'e', 'J', 'B', 'p', 'f', 'f',
				'P', 'R', 'f', 'b', 'K', 'j', '3', '4', 'Z', 'p', 'H', 'G',
				'4', 'j', 'm', 'A', 'h', 'N', 'T', 'o', '1', '7', 'a', 'p',
				'k', 'f', 'r', 'j', '0', '2', 'h', 'A', 'g', 'M', 'B', 'A',
				'A', 'E', 'C', 'g', 'Y', 'E', 'A', 'i', 'Y', 'Q', '9', '5',
				'w', 'h', '6', 'i', 'g', '+', 'C', '4', 'Z', 'e', 's', 'X',
				'W', 'd', 'A', 'Z', 'S', 'p', '4', 'e', '1', 'q', 'l', 'b',
				'e', 'M', 'w', 'D', '+', 'X', 'x', 'N', '+', '1', 'B', 'D',
				'V', 'A', 'Q', 'Q', 'Q', 'd', 'X', 'j', 'N', 'E', '+', 'Q',
				'1', '/', 'H', 's', 'P', 'o', 'B', 'x', '5', 'R', 'y', 'W',
				'U', 'T', 'O', 'g', 'N', 'O', 'P', 'I', 'X', 'D', 'I', 'X',
				'x', 'K', '5', 'M', 'A', 'a', 'F', 'E', 'J', 'q', 'C', '2',
				'K', 'X', 'M', 'T', 'G', 'n', 'z', '9', '8', 'U', 'L', 'q',
				'O', '3', 'Q', 'F', 'K', 'z', 'i', '8', 'K', 't', 's', 'Y',
				'L', 'j', 'p', 'l', 'd', 'y', 'x', 'u', 'k', 'q', 'g', 'g',
				'F', 'w', 'y', 'S', 'E', 'b', '/', '0', 's', 'I', 'n', '7',
				'B', '0', 'I', 't', 'L', 'U', 'x', '1', 'H', 'o', 'm', 'j',
				'C', '7', 'T', 'e', 'Y', 'v', 'l', 'G', 'L', 'W', '/', '0',
				'K', 'B', '0', 'r', 'x', 'Q', 'w', 'B', 'j', '0', 'C', 'Q',
				'Q', 'D', 'R', 'G', 'e', 'j', 'Z', '+', 'A', 'M', '0', 'm',
				'G', 'f', 'W', 'k', 't', '5', '6', 'V', 'a', 'u', 'W', 'W',
				'c', 'f', 'E', 'O', 'T', 'u', 'B', 'I', 'm', 'j', 'W', 'P',
				'b', 'S', 'I', 'Y', 'b', '8', '/', 'h', 'N', 'G', 'Z', 'r',
				'v', 'x', 'i', 's', 'a', 'R', 'A', 'T', 'D', 'y', 'd', 'K',
				'5', 'f', 'R', 'Y', 'c', 'j', 'H', 'P', 'V', 'I', 'm', 'h',
				'I', 'a', 'S', 'x', 'n', 'v', 'F', '7', 'D', 'H', 'l', 'O',
				'V', 'B', 'L', 'A', 'k', 'E', 'A', 'r', '7', 'v', 'Z', 'q',
				'k', '5', '7', 'q', 'j', 'a', 'O', '7', '7', '8', '8', 'F',
				'2', 'R', 't', '6', 'O', 'K', 'W', 'l', 'n', 'H', 'r', 'c',
				'O', 'z', 'l', 'X', 'n', 'q', 't', '8', 'P', 'N', 'w', '5',
				'K', 'Y', 't', 's', 'M', 'b', '+', 'R', 'x', 'A', 'C', 'q',
				'F', 'i', '4', 'l', 'T', 'O', '/', 'd', 'D', '2', 'a', 'H',
				'c', 'Y', 'y', 'e', 'k', 'O', 'I', 'I', 'm', 'r', 'v', 'C',
				'u', 'd', 'J', '4', '2', 'O', 'e', 'Q', 'w', 'J', 'B', 'A',
				'N', 'D', 'O', 'w', '9', 'V', 'u', 's', 'p', 'z', 'C', 'G',
				'O', 'e', 'Q', 's', 'L', 'S', 'P', 'e', 'p', 'L', 'g', 'w',
				'v', 'l', 'z', 'g', 'b', 'V', '5', 'z', 'C', 'E', 't', 'a',
				'2', 'v', 'J', '2', 'L', 'a', 'w', 'h', 'r', 'K', 'm', 'q',
				'I', 'h', 'S', 'B', 's', 'j', 'i', 'm', 'K', 'E', 'H', 'G',
				'E', 't', 'S', 'D', '7', 'L', 'O', 'z', 'I', 'u', 'E', 'S',
				'f', 'K', 'm', 'X', 'J', 'G', 'Q', 'R', 'V', '8', '3', 'd',
				'b', 'M', 'C', 'Q', 'C', 'n', 'x', 'c', 'g', 'A', '9', '/',
				'z', 'I', 'f', 'F', '3', 'q', 'N', 'c', 'D', 'A', '9', 'H',
				'i', 'a', 'J', 'f', 'l', 'u', 'm', 'E', 'Q', 'X', 'A', '5',
				'P', 'X', 'p', '3', 'f', '4', '2', 'f', 'G', 'l', '2', 'a',
				'E', '1', 'b', 'E', 'X', 'G', 'w', 'l', 'p', 'H', 'L', 'q',
				'z', 'K', 'h', 'S', 'T', '7', 'b', 'P', 'R', '+', 'C', 'I',
				'K', 'Y', 'h', '3', 'C', 'o', 'q', 'z', '6', 'c', 'Q', 'k',
				'Q', 'g', 'e', 'z', 'L', 'U', 'C', 'Q', 'E', 'O', 'n', 'Y',
				'y', '7', 'd', 'N', 'E', '9', 'o', 'B', 'c', 'l', 'E', 'S',
				'j', 'u', 'w', 'r', '/', '+', 'm', 'c', 'g', 'f', 'g', 'c',
				'O', 'K', 'O', 'X', 'r', 'C', 'v', 'e', '8', 'u', '2', 'B',
				'K', 'j', 'M', 'A', '1', 'u', '0', 'Z', 'R', 'w', 'G', 'Z',
				'A', '4', '+', 'Y', 'I', 'M', 'z', 'Q', 'C', 'k', 'j', 'r',
				's', 'V', 'Y', '+', 'H', 'y', '0', 'd', 'o', 'A', 'D', 'a',
				'L', '0', 'C', '8', '1', 'Q', 'w', 'P', 'n', 'A', '=' };

		return RSAUtils.decryptByPrivateKey(new String(pk),
				IOUtils.toString(licenseUri));
	}
	
}
