package com.jesse.function.ffmpegcmdline;

import com.jesse.function.ffmpegcmdline.type.FTComposeMP3;
import com.jesse.function.ffmpegcmdline.type.FTWaterMark;

/**
 * Created by hubin on 16/5/17.
 */
public class FFmpegKit {


    static{
        NativeLibraryLoader.load();
    }

    /**
     * 给视频加水印
     * @return
     */
    public int watermark(FTWaterMark waterMark){
        String[] commands = {
                "ffmpeg",
                "-i",
                waterMark.getVideoPath(),
                "-vf",
                "movie=" + waterMark.getWaterMark() + " [logo]; [in][logo] overlay=0:0 [out]",
                waterMark.getOutPath()
        };
        return command(commands);
    }

    /**
     * 音视频合成
     * @return
     */
    public int composeMP3(FTComposeMP3 composeMP3){
        String[] commands = {
                "ffmpeg",
                "-i",
                composeMP3.getVideoPath(),
                "-i",
                composeMP3.getMp3(),
                "-strict",
                "-2",
                "-y",
                composeMP3.getOutPath()
        };
        return command(commands);
    }


    private native static int command(String[] commands);
}

