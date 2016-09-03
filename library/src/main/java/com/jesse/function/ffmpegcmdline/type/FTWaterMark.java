package com.jesse.function.ffmpegcmdline.type;

/**
 * 视频加水印
 * Created by Jesse_Chin on 16/9/3.
 */
public class FTWaterMark extends BaseType{

    /**
     * 待处理视频地址
     */
    private String videoPath;

    /**
     * 水印文件地址
     */
    private String waterMark;

    /**
     * 输出视频地址
     */
    private String outPath;

    public FTWaterMark(String videoPath, String waterMark, String outPath) {
        this.videoPath = videoPath;
        this.waterMark = waterMark;
        this.outPath = outPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getWaterMark() {
        return waterMark;
    }

    public String getOutPath() {
        return outPath;
    }

}
