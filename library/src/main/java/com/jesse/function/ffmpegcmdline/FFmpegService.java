package com.jesse.function.ffmpegcmdline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.jesse.function.ffmpegcmdline.type.FTComposeMP3;
import com.jesse.function.ffmpegcmdline.type.FTWaterMark;

public class FFmpegService extends Service {
    public FFmpegService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        FFmpegKit fFmpegKit = new FFmpegKit();
        int type = intent.getIntExtra(FFmpegConst.TYPE_KEY, -1);

        switch (type){
            case FFmpegConst.TYPE_WATERMARK:
                FTWaterMark waterMark = (FTWaterMark) intent.getSerializableExtra(FFmpegConst.TYPE_BEAN_KEY);
                fFmpegKit.watermark(waterMark);
                break;
            case FFmpegConst.TYPE_COMPOSE_MP3:
                FTComposeMP3 composeMP3 = (FTComposeMP3) intent.getSerializableExtra(FFmpegConst.TYPE_BEAN_KEY);
                fFmpegKit.composeMP3(composeMP3);
                break;
            default:
                break;
        }

        Intent broadIntent = new Intent(FFmpegConst.FINISH_BROADCAST);
        sendBroadcast(broadIntent);

        stopSelf();
        android.os.Process.killProcess(android.os.Process.myPid());

        return super.onStartCommand(intent, flags, startId);
    }
}
