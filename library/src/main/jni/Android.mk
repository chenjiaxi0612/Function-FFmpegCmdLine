LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := avcodec
LOCAL_SRC_FILES := libavcodec-57.so
include $(PREBUILT_SHARED_LIBRARY)
include $(CLEAR_VARS)
LOCAL_MODULE := avfilter
LOCAL_SRC_FILES := libavfilter-6.so
include $(PREBUILT_SHARED_LIBRARY)
include $(CLEAR_VARS)
LOCAL_MODULE := avformat
LOCAL_SRC_FILES := libavformat-57.so
include $(PREBUILT_SHARED_LIBRARY)
include $(CLEAR_VARS)
LOCAL_MODULE := avutil
LOCAL_SRC_FILES := libavutil-55.so
include $(PREBUILT_SHARED_LIBRARY)
include $(CLEAR_VARS)
LOCAL_MODULE := swresample
LOCAL_SRC_FILES := libswresample-2.so
include $(PREBUILT_SHARED_LIBRARY)
include $(CLEAR_VARS)
LOCAL_MODULE := swscale
LOCAL_SRC_FILES := libswscale-4.so
include $(PREBUILT_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := ffmpeginvoke
LOCAL_SRC_FILES := com_jesse_function_ffmpegcmdline_FFmpegKit.c ffmpeg.c ffmpeg_opt.c cmdutils.c ffmpeg_filter.c
#local path to ffmpeg(2.6.2) should be there
LOCAL_C_INCLUDES := /Users/Jesse_Chin/Downloads/ffmpeg/ffmpeg-01
LOCAL_LDLIBS := -llog -lz -ldl
LOCAL_SHARED_LIBRARIES := avcodec avfilter avformat avutil swresample swscale

include $(BUILD_SHARED_LIBRARY)