package com.jesse.function.ffmpegcmdline;

/**
 * Created by wangyang on 15/7/30.
 */
public class NativeLibraryLoader {

    private static boolean mLibraryLoaded = false;

    public static void load() {
        if(mLibraryLoaded)
            return;
        mLibraryLoaded = true;
//        System.loadLibrary("gnustl_shared");
//        System.loadLibrary("x264.142"); //compiled to static library in the new version.

//        try {
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avformat-57");
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("swscale-4");
        System.loadLibrary("ffmpeginvoke");
//        } catch (Throwable t) {
//            Log.e(Common.LOG_TAG, "Load library for 'cge' failed! Please check your project config.", t);
//        }

    }

}
