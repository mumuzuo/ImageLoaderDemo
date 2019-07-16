package com.zuo.demo.imageloaderdemo.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图片数据获取帮助类
 *
 * @author zuo
 * @date 2019/7/16 10:30
 */
public class ImageDataGetHelper {

    public static List<String> getImageList() {
        String[] imgList = {
                "http://img5.imgtn.bdimg.com/it/u=2458914123,541076108&fm=26&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=2471845590,913308006&fm=26&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=2197066702,135802552&fm=26&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=220675088,679310291&fm=26&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=1662414753,1562172514&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=3862462025,4084711461&fm=26&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=1711525431,3886632954&fm=26&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=1858637126,3178795213&fm=26&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=585542670,572354621&fm=26&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=2543992394,2802996820&fm=26&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=1260664168,3503280632&fm=26&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=2612480236,1035164052&fm=26&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=3807329516,426761603&fm=26&gp=0.jpg"
        };

        List<String> list = new ArrayList<String>();
        Collections.addAll(list, imgList);
        return list;
    }
}
