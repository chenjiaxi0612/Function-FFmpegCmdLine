package com.jesse.function.ffmpegcmdline.type;

/**
 * 视频加水印
 * Created by Jesse_Chin on 16/9/3.
 */
public class FTComposeMP3 extends BaseType{

    /**
     * 待处理视频地址
     */
    private String videoPath;

    /**
     * mp3文件地址
     */
    private String mp3;

    /**
     * 输出视频地址
     */
    private String outPath;

    public FTComposeMP3(String videoPath, String mp3, String outPath) {
        this.videoPath = videoPath;
        this.mp3 = mp3;
        this.outPath = outPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getMp3() {
        return mp3;
    }

    public String getOutPath() {
        return outPath;
    }

}
