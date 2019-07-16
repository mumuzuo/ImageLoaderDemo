package com.zuo.demo.imageloaderdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.z.imageloader.ImageLoader;
import com.zuo.demo.imageloaderdemo.adapter.ImageAdapter;
import com.zuo.demo.imageloaderdemo.data.ImageDataGetHelper;
import com.zuo.demo.imageloaderdemo.databinding.ActivityImageListBinding;

public class ImageListActivity extends AppCompatActivity {

    private ActivityImageListBinding binding;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_list);
        imageLoader = new ImageLoader();
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        ImageAdapter adapter = new ImageAdapter(this, ImageDataGetHelper.getImageList(), imageLoader);
        binding.rvImage.setAdapter(adapter);
        binding.rvImage.setLayoutManager(new LinearLayoutManager(this));
        binding.rvImage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

}
