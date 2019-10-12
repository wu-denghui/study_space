/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *
 *      http://www.deppon.com
 *
 */
package com.goodhealth.comm.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * 生成验证码工具
 *
 */
public class VerifyCodeUtils {

/*    public static void main(String[] args) throws IOException {
        System.out.println(generateVerifyCode(4));
        File dir = new File("F:\\Temp");
        String verifyCode = generateVerifyCode(FOUR);
        File file = new File(dir, verifyCode + ".jpg");
        System.out.println(outputVerifyImage(TWO_HUNDRED, EIGHTY, file, FOUR));
    }*/

	//使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符  
    public static final String VERIFY_CODES = "abcdefghjklmnpqrstuvwxyz23456789ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    // 随机工具类 random
    private static Random random = new Random();
    //5
    public static final int FIVE = 5;
    //200
    public static final int TWO_HUNDRED = 200;
    //250
    public static final int TWO_HUNDRED_FIFTY = 250;
    //4
    public static final int FOUR = 4;
    //100
    public static final int ONE_HUNDRED = 100;
    //160
    public static final int ONE_HUNDRED_SIXTY = 160;
    //6
    public static final int SIX = 6;
    //12
    public static final int TWELVE = 12;
    //10
    public static final int TEN = 10;
    //20
    public static final int TWENTY = 20;
    //40
    public static final int FORTY = 40;
    //0.05F
    public static final float ZERO_FIVE = 0.05f;
    //255
    public static final int TWO_HUNDRED_FIVE = 255;
    //8
    public static final int EIGHT = 8;
    //3
    public static final int THREE = 3;
    //7
    public static final int SEVEN = 7;
    //80
    public static final int EIGHTY = 80;
    //50
    public static final int FIFTY  = 50;
    public static final double NUM_6D = 6.2831853071795862D;

    /**
     * OUT 生成随机验证码文件,并返回验证码值
     * @param w
     * @param h
     * @param outputFile
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException{
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, outputFile, verifyCode);
        return verifyCode;
    }
    /**
     *  OUT 使用系统默认字符源生成验证码
     * @param verifySize    验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize){
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }
    /**
     * out 输出随机验证码图片流,并返回验证码值
     * @param w
     * @param h
     * @param os
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException{
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, os, verifyCode);
        return verifyCode;
    }

    /**
     *  inner 使用指定源生成验证码
     * @param verifySize    验证码长度
     * @param sources   验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources){
        if(sources == null || sources.length() == 0){
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }

    /** 
     * inner 生成指定验证码图像文件
     * @param w 
     * @param h 
     * @param outputFile 
     * @param code 
     * @throws IOException 
     */  
    public static void outputImage(int w, int h, File outputFile, String code) throws IOException{  
        if(outputFile == null){  
            return;  
        }  
        File dir = outputFile.getParentFile();  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        try{  
            outputFile.createNewFile();  
            FileOutputStream fos = new FileOutputStream(outputFile);  
            outputImage(w, h, fos, code);  
            fos.close();  
        } catch(IOException e){  
            throw e;  
        }  
    }  
      
    /** 
     * inner 输出指定验证码图片流
     * @param w 
     * @param h 
     * @param os 
     * @param code 
     * @throws IOException 
     */  
    public static void outputImage(int w, int h, OutputStream os, String code) throws IOException{  
        int verifySize = code.length();  
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
        Random rand = new Random();  
        Graphics2D g2 = image.createGraphics();  
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
        Color[] colors = new Color[FIVE];  
        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN,  
                Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,  
                Color.PINK, Color.YELLOW };  
        float[] fractions = new float[colors.length];  
        for(int i = 0; i < colors.length; i++){  
            colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];  
            fractions[i] = rand.nextFloat();  
        }  
        Arrays.sort(fractions);  
          
        g2.setColor(Color.GRAY);// 设置边框色  
        g2.fillRect(0, 0, w, h);  
          
        Color c = getRandColor(TWO_HUNDRED, TWO_HUNDRED_FIFTY);  
        g2.setColor(c);// 设置背景色  
        g2.fillRect(0, 2, w, h-FOUR);  
          
        //绘制干扰线  
        Random random = new Random();  
        g2.setColor(getRandColor(ONE_HUNDRED_SIXTY, TWO_HUNDRED));// 设置线条的颜色  
        for (int i = 0; i < TWENTY; i++) {  
            int x = random.nextInt(w - 1);  
            int y = random.nextInt(h - 1);  
            int xl = random.nextInt(SIX) + 1;  
            int yl = random.nextInt(TWELVE) + 1;  
            g2.drawLine(x, y, x + xl + FORTY, y + yl + TWENTY);  
        }  
          
        // 添加噪点  
        double yawpRate = ZERO_FIVE;// 噪声率  
        int area = (int)(yawpRate * w * h);  
        for (int i = 0; i < area; i++) {  
            int x = random.nextInt(w);  
            int y = random.nextInt(h);  
            int rgb = getRandomIntColor();  
            image.setRGB(x, y, rgb);  
        }  
          
        shear(g2, w, h, c);// 使图片扭曲  
  
        g2.setColor(getRandColor(ONE_HUNDRED, ONE_HUNDRED_SIXTY));  
        int fontSize = h-FOUR;  
        Font font = new Font("宋体", Font.ITALIC, fontSize);  
        g2.setFont(font);  
        char[] chars = code.toCharArray();  
        for(int i = 0; i < verifySize; i++){  
            AffineTransform affine = new AffineTransform();  
            affine.setToRotation(Math.PI / FOUR * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);  
            g2.setTransform(affine);  
            g2.drawChars(chars, i, 1, ((w-TEN) / verifySize) * i + FIVE, h/2 + fontSize/2 - TEN);  
        }  
        
        g2.dispose();
        ImageIO.write(image, "jpg", os);  
    }

    /**
     *  inner 颜色随机
     * @param fc
     * @param bc
     * @return
     */
    private static Color getRandColor(int fc, int bc) {  
        if (fc > TWO_HUNDRED_FIVE){
            fc = TWO_HUNDRED_FIVE;
        }
        if (bc > TWO_HUNDRED_FIVE){
            bc = TWO_HUNDRED_FIVE;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);  
        int b = fc + random.nextInt(bc - fc);  
        return new Color(r, g, b);  
    }  
      
    private static int getRandomIntColor() {  
        int[] rgb = getRandomRgb();  
        int color = 0;  
        for (int c : rgb) {  
            color = color << EIGHT;  
            color = color | c;  
        }  
        return color;  
    }  
      
    private static int[] getRandomRgb() {  
        int[] rgb = new int[THREE];  
        for (int i = 0; i < THREE; i++) {  
            rgb[i] = random.nextInt(TWO_HUNDRED_FIVE);  
        }  
        return rgb;  
    }  
  
    private static void shear(Graphics g, int w1, int h1, Color color) {  
        shearX(g, w1, h1, color);  
        shearY(g, w1, h1, color);  
    }  
      
    private static void shearX(Graphics g, int w1, int h1, Color color) {  
        int period = random.nextInt(2);
        boolean borderGap = true;
        int frames = 1;  
        int phase = random.nextInt(2);  
        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)  
                    * Math.sin((double) i / (double) period  
                            + (NUM_6D * (double) phase)  
                            / (double) frames);  
            g.copyArea(0, i, w1, 1, (int) d, 0);  
            if (borderGap) {  
                g.setColor(color);  
                g.drawLine((int) d, i, 0, i);  
                g.drawLine((int) d + w1, i, w1, i);  
            }  
        }  
    }
  
    private static void shearY(Graphics g, int w1, int h1, Color color) {  
        int period = random.nextInt(FORTY) + TEN; // 50;
        boolean borderGap = true;
        int frames = TWENTY;  
        int phase = SEVEN;  
        for (int i = 0; i < w1; i++) {  
            double d = (double) (period >> 1)  
                    * Math.sin((double) i / (double) period  
                            + (NUM_6D * (double) phase)  
                            / (double) frames);  
            g.copyArea(i, 0, 1, h1, 0, (int) d);  
            if (borderGap) {  
                g.setColor(color);  
                g.drawLine(i, (int) d, i, 0);  
                g.drawLine(i, (int) d + h1, i, h1);  
            }  
  
        }  
  
    }  
   /* public static void main(String[] args) throws IOException{  
        File dir = new File("F:/verifies");  
        int w = TWO_HUNDRED, h = EIGHTY;  
        for(int i = 0; i < FIFTY; i++){  
            String verifyCode = generateVerifyCode(FOUR);  
            File file = new File(dir, verifyCode + ".jpg");  
            outputImage(w, h, file, verifyCode);  
        }  
    } */
	
}
