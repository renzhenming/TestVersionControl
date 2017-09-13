package com.example.renzhenming.testapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseCoverActivity_TexturView extends AppCompatActivity implements Runnable, View.OnTouchListener {

    private static final String TAG = "ChooseCoverActivity";
    //private static final String VIDEO_PATH = "http://7xl1ve.com5.z0.glb.qiniucdn.com/2017/09/08/20/12/8c11dfbf1334412b8da077e5048ffe4c.mp4";
    private String VIDEO_PATH ;
    private TextureView mVideoView;
    private LinearLayout mImageGroup;
    private Button mPlay;
    private ArrayList<Bitmap> mPathList = new ArrayList<>();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String path = (String) msg.obj;
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 200;
            imageView.setImageBitmap(bitmap);
            mImageGroup.addView(imageView,params);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cover2);
        VIDEO_PATH = "http://7xl1ve.com5.z0.glb.qiniucdn.com/2017/09/08/20/12/8c11dfbf1334412b8da077e5048ffe4c.mp4";
        initView();
    }

    private void initView() {
        mVideoView = (TextureView) findViewById(R.id.choose_video);
        mImageGroup = (LinearLayout) findViewById(R.id.choose_image_group);
        mPlay = (Button) findViewById(R.id.choose_click);
        mVideoView.buildLayer();
    }

    @Override
    public void run() {
        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
        metadataRetriever.setDataSource(VIDEO_PATH,new HashMap<String, String>());
        for(int i = 0; i< 15;i++) {
            int timeUs = i * 1000 * 1000;
            Bitmap bitmap = metadataRetriever.
                    getFrameAtTime(timeUs, MediaMetadataRetriever.OPTION_CLOSEST);
            mPathList.add(bitmap);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (Bitmap bitmap : mPathList) {
                    ImageView imageView = new ImageView(getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.width = 200;
                    imageView.setImageBitmap(bitmap);
                    mImageGroup.addView(imageView,params);
                }

            }
        });
            /*File file = new File(Environment.getExternalStorageDirectory() + "/bitmap/");
            if (!file.exists()){
                file.mkdirs();
            }

            String path = Environment.getExternalStorageDirectory() + "/bitmap/" + System.currentTimeMillis() + ".png";

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(path);
                bitmap.compress(Bitmap.CompressFormat.PNG, 10, fileOutputStream);
                Message message = new Message();
                message.obj = path;
                mHandler.sendMessage(message);
            } catch (Exception e) {
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
            bitmap.recycle();*/
//        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
