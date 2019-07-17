package com.z.imageloader.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;

import com.z.imageloader.ImageCache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 图片持久化缓存类
 *
 * @author zuo
 * @date 2019/7/17 15:16
 */
public class DiskCache implements ImageCache {
    private String cacheDir = "/imageloaderz";
    private final File cacheFileDir;

    public DiskCache() {
        cacheFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), cacheDir);
        if (!cacheFileDir.exists()) {
            cacheFileDir.mkdirs();
        }
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        File file = new File(cacheFileDir.getAbsolutePath() + "/" + getPicName(url) + ".png");
        //已存在的不需要缓存
        if (file.exists()) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheFileDir.getAbsolutePath() + "/" + getPicName(url) + ".png");
    }

    private String getPicName(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(url.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
