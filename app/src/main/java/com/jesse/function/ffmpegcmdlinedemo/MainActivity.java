package com.jesse.function.ffmpegcmdlinedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.jesse.function.ffmpegcmdline.FFmpegConst;
import com.jesse.function.ffmpegcmdline.FFmpegService;
import com.jesse.function.ffmpegcmdline.type.FTWaterMark;


public class MainActivity extends AppCompatActivity {

    private FFmpegBroadCase fFmpegBroadCase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        fFmpegBroadCase = new FFmpegBroadCase();
        filter.addAction("ff");
        registerReceiver(fFmpegBroadCase, filter);

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(fFmpegBroadCase);
        super.onDestroy();
    }

    //    public void run(View view){
//        String base = Environment.getExternalStorageDirectory().getPath();
//        Log.e("PATH", base);
//        String[] commands = new String[9];
//        commands[0] = "ffmpeg";
//        commands[1] = "-i";
//        commands[2] = base + "/input.mp4";
//        commands[3] = "-i";
//        commands[4] = base + "/input.mp3";
//        commands[5] = "-strict";
//        commands[6] = "-2";
//        commands[7] = "-y";
//        commands[8] = base + "/merge.mp4";
//        FFmpegKit.execute(commands, new FFmpegKit.KitInterface() {
//            @Override
//            public void onStart() {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行开始执行了...",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onProgress(int progress) {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行执行进度..."+progress,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onEnd(int result) {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行执行完成..."+result,Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    public void run(View view){
        String base = "/storage/emulated/0/libCGE";
        Log.e("PATH", base);

//    String[] commands = {
//            "ffmpeg",
//            "-i",
//            base + "/demo.mp4",
//            base + "/aaa/example.%d.jpg"
//    };

//    String[] commands = {
//        "ffmpeg",
//        "-i",
//        base + "/input.mp3",
//        "-i",
//        base + "/aaa/example.%d.jpg",
//        base + "/darkdoor.mp4"
//    };

//    String[] commands = {
//            "ffmpeg",
//            "-i",
//            base + "/rec_1472619569010.mp4",
//            "-ss",
//            "00:00:00.000",
//            "-pix_fmt",
//            "rgb24",
//            "-r",
//            "10",
//            "-s",
//            "320x240",
//            "-t",
//            "00:00:10.000",
//            base + "/rec_1472619569010_2.gif"
//    };



        //ffmpeg -i input.avi -vf "movie=logo.png [logo]; [in][logo] overlay=10:10 [out]" output.avi

        //视频加水印
        String[] commands = {
                "ffmpeg",
                "-i",
                base + "/rec_1472619569010.mp4",
                "-vf",
                "movie=" + base + "/scancode.png [logo]; [in][logo] overlay=0:0 [out]",
                base + "/rec_1472619569010_2.mp4"
        };


        //视频和音频的合成
//    String[] commands = new String[9];
//    commands[0] = "ffmpeg";
//    commands[1] = "-i";
//    commands[2] = base + "/rec_1472619569010.mp4";
//    commands[3] = "-i";
//    commands[4] = base + "/haha.mp3";
//    commands[5] = "-strict";
//    commands[6] = "-2";
//    commands[7] = "-y";
//    commands[8] = base + "/rec_1472619569010_1.mp4";


//        FFmpegKit fFmpegKit = new FFmpegKit();
//        fFmpegKit.execute(commands);



        Intent intent = new Intent(MainActivity.this, FFmpegService.class);
        Bundle bundle = new Bundle();
        bundle.putInt(FFmpegConst.TYPE_KEY, FFmpegConst.TYPE_WATERMARK);
        bundle.putSerializable(FFmpegConst.TYPE_BEAN_KEY, new FTWaterMark(base + "/rec_1472619569010.mp4",
                base + "/scancode.png", base + "/rec_1472619569010_2.mp4"));
        intent.putExtras(bundle);
        startService(intent);


//        FFmpegKit.execute(commands, new FFmpegKit.KitInterface() {
//            @Override
//            public void onStart() {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行开始执行了...",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onProgress(int progress) {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行执行进度..."+progress,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onEnd(int result) {
//                Toast.makeText(MainActivity.this,"FFmpeg 命令行执行完成..."+result,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    class FFmpegBroadCase extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("haha", "成功了");
        }
    }
}
