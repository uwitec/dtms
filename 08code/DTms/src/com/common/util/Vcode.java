package com.common.util;

import java.util.Random;

public class Vcode {
	/**
	 * �����֤�������
	 * 7165|/images/num/7.gif-/images/num/1.gif-/images/num/6.gif-/images/num/5.gif
	 * 
	 * @return
	 */
	// 生成验证码
	public String randomString() {
		String ssource = "0123456789";
		Random random = new Random();
		String sRand = "";
		String sRandImage = "";
		for (int i = 0; i < 4; i++) {
			int pos = random.nextInt(ssource.length() - 1);
			String rand = ssource.substring(pos, pos + 1);
			String randImages = "<img src='/images/num/" + rand + ".gif' />";
			/*
			 * if(sRandImage!=null&&sRandImage.length()>0){ randImages = "-" +
			 * randImages; }
			 */
			sRandImage += randImages;
			sRand += rand;
		}
		return sRand + "-" + sRandImage;
	}
}
