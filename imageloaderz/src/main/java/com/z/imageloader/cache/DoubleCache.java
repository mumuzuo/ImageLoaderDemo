package com.z.imageloader.cache;

import android.graphics.Bitmap;

import com.z.imageloader.ImageCache;

/**
 * 图片双缓存类
 * 缓存时，在内存和本地都缓存一份
 * 获取时，先从内存中找，内存中没有再从本地找
 *
 * @author zuo
 * @date 2019/7/17 15:16
 */
public class DoubleCache implements ImageCache {
    private MemoryCache memoryCache = new MemoryCache();
    private DiskCache diskCache = new DiskCache();

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

}
