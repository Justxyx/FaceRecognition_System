<template>
  <div>
    <video
      autoplay
      controls
      width="100%"
      height="500"
      id="videoElement"
    ></video>
    <el-button @click="createVideo(1)">开启直播</el-button>
    <el-button @click="createVideo(0)">关闭直播</el-button>
  </div>
</template>

<script>
import flvjs from "flv.js";

export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },

  methods: {
    createVideo(judge) {
      var videoElement = document.getElementById("videoElement");
      var flvPlayer = flvjs.createPlayer({
        isLive: true,
        type: "flv",
        url:
          "http://localhost:8866/live?url=rtsp://admin:whu123456@192.168.1.64:554/ch1/main/av_stream", //你的url地址
      });
      if (judge == 1) {
        if (flvjs.isSupported()) {
          flvPlayer.attachMediaElement(videoElement);
          flvPlayer.load();
          flvPlayer.play();
        }
      }
      if (judge == 0) {
        console.log(1111111111111111);

        flvPlayer.destroy();
        // flvPlayer.destroy();

        flvPlayer = null;
        console.log(flvPlayer)
      }
    },
  },
};
</script>
