<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb class="el-breadcrumb">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>监控列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card class="box-card">
      <!-- 搜索框 -->
      <el-row :gutter="4">
        <el-col :span="8">
          <!-- 搜索输入框 -->
          <el-input placeholder="搜索监控" class="input-with-select" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
      </el-row>

      <!-- 用户列表table展示区 -->
      <el-table :data="cameraList" stripe style="width: 100%">
        <el-table-column prop="serialNumber" label="设备序列号" width="180">
        </el-table-column>
        <el-table-column prop="cameraIp" label="设备ip" width="180">
        </el-table-column>
        <el-table-column prop="cameraName" label="登录名" width="180">
        </el-table-column>
        <el-table-column prop="cameraPwd" label="登录密码" width="180">
        </el-table-column>
        <el-table-column prop="cameraPort" label="端口号" width="180">
        </el-table-column>
        <el-table-column prop="cameraPosition" label="位置信息" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- {{ scope.row }} -->
            <el-button type="success" @click="showVedio(scope.row.cameraSrc)"
              >查看监控流</el-button
            >

            <el-popconfirm
              confirm-button-text="好的"
              cancel-button-text="不用了"
              icon="el-icon-info"
              icon-color="red"
              title="你确定要删除该用户吗"
              @confirm="deleteCameraById(scope.row.cameraId)"
            >
              <el-button type="warning" slot="reference">删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!-- 视频流dialog -->
    <el-dialog title="监控流详情" :visible.sync="dialogVisible" width="50%" >
      <div>
        <video
          autoplay
          controls
          width="100%"
          height="500"
          id="videoElement"
        ></video>
        <el-button @click="createVideo()">开启监控显示</el-button>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="stopVideo()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import flvjs from "flv.js";
export default {
  created() {
    this.getCameraList();
  },
  data() {
    return {
      cameraList: [],
      dialogVisible: false,
      src: "",
    };
  },
  methods: {
    async getCameraList() {
      const { data: res } = await this.$http.get("cameraList");
      if (res.code == 200) {
        this.cameraList = res.data;
        console.log(this.cameraList);
      }
    },
    async deleteCameraById(id) {
      const { data: res } = await this.$http.get("deleteCameraById/" + id);
      if (res.code == 200) {
        this.$message.success("删除成功");
        this.getCameraList();
      } else {
        this.$message.error("删除失败");
      }
    },
    showVedio(src) {
      this.dialogVisible = true;
      this.src = src;
    },
    createVideo() {
      var videoElement = document.getElementById("videoElement");
      var flvPlayer = flvjs.createPlayer({
        isLive: true,
        type: "flv",
        url: "http://localhost:8866/live?url=" + this.src,

        // "http://localhost:8866/live?url=rtsp://admin:whu123456@192.168.1.64:554/ch1/main/av_stream", //你的url地址
      });

      if (flvjs.isSupported()) {
        flvPlayer.attachMediaElement(videoElement);
        flvPlayer.load();
        flvPlayer.play();
      }

    },
    stopVideo() {
      this.dialogVisible = false;
      window.location.reload();
    },
  },
};
</script>

<style scoped lang='less'>
</style>