package com.faramarz.tictacdev.imageloading;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.overrideOf;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String URL = "http://www.brbrains.in/wp-content/uploads/2017/07/Job-Assured-After-Android-Training.png";
    ImageView imgSimple;
    Button btnLoadSimple, btnFeature1, btnFeature2, btnFeature3,
            btnFeature4, btnFeature5, btnFeature6, btnFeature7, btnFeature8,
            btnFeature9, btnFeature10, btnFeature11, btnFeature12, btnFeature13,
            btnFeature14, btnFeature15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
    }

    private void bind() {
        imgSimple = findViewById(R.id.imgSimple);
        btnLoadSimple = findViewById(R.id.btnLoadSimple);
        btnFeature1 = findViewById(R.id.btnFeature1);
        btnFeature2 = findViewById(R.id.btnFeature2);
        btnFeature3 = findViewById(R.id.btnFeature3);
        btnFeature4 = findViewById(R.id.btnFeature4);
        btnFeature5 = findViewById(R.id.btnFeature5);
        btnFeature6 = findViewById(R.id.btnFeature6);
        btnFeature7 = findViewById(R.id.btnFeature7);
        btnFeature8 = findViewById(R.id.btnFeature8);
        btnFeature9 = findViewById(R.id.btnFeature9);
        btnFeature10 = findViewById(R.id.btnFeature10);
        btnFeature11 = findViewById(R.id.btnFeature11);
        btnFeature12 = findViewById(R.id.btnFeature12);
        btnFeature13 = findViewById(R.id.btnFeature13);
        btnFeature14 = findViewById(R.id.btnFeature14);
        btnFeature15 = findViewById(R.id.btnFeature15);


        btnLoadSimple.setOnClickListener(this);
        btnFeature1.setOnClickListener(this);
        btnFeature2.setOnClickListener(this);
        btnFeature3.setOnClickListener(this);
        btnFeature4.setOnClickListener(this);
        btnFeature5.setOnClickListener(this);
        btnFeature6.setOnClickListener(this);
        btnFeature7.setOnClickListener(this);
        btnFeature8.setOnClickListener(this);
        btnFeature9.setOnClickListener(this);
        btnFeature10.setOnClickListener(this);
        btnFeature11.setOnClickListener(this);
        btnFeature12.setOnClickListener(this);
        btnFeature13.setOnClickListener(this);
        btnFeature14.setOnClickListener(this);
        btnFeature15.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btnLoadSimple:
                showSimpleImage();
                break;

            case R.id.btnFeature1:
                showResizedImage();
                break;

            case R.id.btnFeature2:
                showCroppedImage();
                break;

            case R.id.btnFeature3:
                showCircularImage();
                break;

            case R.id.btnFeature4:
                showBlurImage();
                break;

            case R.id.btnFeature5:
                multiTransform();
                break;

            case R.id.btnFeature6:
                colorTransform();
                break;

            case R.id.btnFeature7:
                sepiaFilter();
                break;

            case R.id.btnFeature8:
                contrastFilter();
                break;

            case R.id.btnFeature9:
                invertFilter();
                break;

            case R.id.btnFeature10:
                roundedCorners();
                break;

            case R.id.btnFeature11:
                swirl();
                break;

            case R.id.btnFeature12:
                toon();
                break;

            case R.id.btnFeature13:
                pixel();
                break;

            case R.id.btnFeature14:
                sketch();
                break;

            case R.id.btnFeature15:
                starMask();
                break;

            default:
                break;
        }

    }


    private void showSimpleImage() {
        Glide.with(this).load(URL)
                .into(imgSimple);
    }

    private void showResizedImage() {
        Glide.with(this)
                .load(URL)
                .override(20, 20)
                .into(imgSimple);
    }

    private void showCroppedImage() {
        Glide.with(this)
                .load(URL)
                .centerCrop()
                .into(imgSimple);
    }

    private void showCircularImage() {
        Glide.with(this)
                .load(URL)
                .apply(RequestOptions.circleCropTransform())
                .into(imgSimple);
    }

    private void showBlurImage() {
        Glide.with(this)
                .load(URL)
                .transform(new BlurTransformation())
                .into(imgSimple);
    }

    private void multiTransform() {
        Glide.with(this)
                .load(URL)
                .transform(new MultiTransformation<Bitmap>(new BlurTransformation(20), new CircleCrop()))
                .into(imgSimple);
    }


    private void colorTransform() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new ColorFilterTransformation(Color.argb(120, 255, 0, 0))))
                .into(imgSimple);
    }

    private void sepiaFilter() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new SepiaFilterTransformation()))
                .into(imgSimple);

    }

    private void contrastFilter() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new ContrastFilterTransformation()))
                .into(imgSimple);

    }

    private void invertFilter() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new InvertFilterTransformation()))
                .into(imgSimple);

    }

    private void roundedCorners() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new RoundedCornersTransformation(45, 0, RoundedCornersTransformation.CornerType.ALL)))
                .into(imgSimple);

    }

    private void swirl() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new SwirlFilterTransformation(0.5f, 1.0f, new PointF(0.5f, 0.5f))).dontAnimate())
                .into(imgSimple);
    }

    private void toon() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new ToonFilterTransformation()))
                .into(imgSimple);

    }

    private void pixel() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new PixelationFilterTransformation(14f)))
                .into(imgSimple);

    }

    private void sketch() {
        Glide.with(this)
                .load(URL)
                .apply(bitmapTransform(new SketchFilterTransformation()))
                .into(imgSimple);

    }

    private void starMask() {
        Glide.with(this)
                .load(URL)
                .apply(overrideOf(266, 252))
                .apply(bitmapTransform(new MultiTransformation<Bitmap>(new CenterCrop(), new MaskTransformation(R.drawable.star_mask))))
                .into(imgSimple);
    }

}
