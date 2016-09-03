#include <stdio.h>
#include "com_jesse_function_ffmpegcmdline_FFmpegKit.h"
#include "ffmpeg.h"
#include "logjam.h"

void custom_log(void *ptr, int level, const char* fmt, va_list vl){

    //To TXT file
    //FILE *fp=fopen("/storage/emulated/0/av_log.txt","a+");
    //if(fp){
    //    vfprintf(fp,fmt,vl);
    //    fflush(fp);
    //    fclose(fp);
    //}

    //To Logcat
    //LOGE(fmt, vl);
}


JNIEXPORT jint JNICALL Java_com_jesse_function_ffmpegcmdline_FFmpegKit_command
  (JNIEnv *env, jclass obj, jobjectArray commands){

    //FFmpeg av_log() callback
        av_log_set_callback(custom_log);
        int argc = (*env)->GetArrayLength(env, commands);
        char *argv[argc];

        LOGD("Kit argc %d\n", argc);
        int i;
        for (i = 0; i < argc; i++) {
            jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
            argv[i] = (char*) (*env)->GetStringUTFChars(env, js, 0);
            LOGD("Kit argv %s\n", argv[i]);
        }
        return run(argc, argv);
}