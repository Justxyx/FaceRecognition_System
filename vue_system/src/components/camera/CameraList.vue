<template>
  <div>
    <!-- 导航区 -->
    <el-page-header @back="goBack" content="传感器管理"> </el-page-header>

    <el-card class="box-card">
      <!-- 搜索框 -->
      <el-row :gutter="4" class="search_box">
        <el-col :span="8">
          <!-- 搜索输入框 -->
          <el-input placeholder="搜索用户" class="input-with-select" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>

        <el-col :span="4" :push="push"
          ><el-button type="success" size="small" @click="addCamearList()"
            >添加摄像头</el-button
          >
        </el-col>
        <el-col :span="4" :push="push1">
          <el-button type="info" size="small">批量导入</el-button>
        </el-col>
      </el-row>

      <!-- 用户列表table展示区 -->
      <el-table :data="cameraList" stripe style="width: 100%" class="el-table">
        <el-table-column type="index" label="序号" width="60"></el-table-column>
        <el-table-column prop="serialNumber" label="设备序列号" width="180">
        </el-table-column>
        <el-table-column prop="cameraIp" label="设备ip" width="180">
        </el-table-column>
        <el-table-column prop="cameraName" label="登录名" width="90">
        </el-table-column>
        <el-table-column prop="cameraPwd" label="登录密码" width="120">
        </el-table-column>
        <el-table-column prop="cameraPort" label="端口号" width="70">
        </el-table-column>
        <el-table-column prop="cameraPosition" label="位置信息" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- {{ scope.row }} -->
            <el-button
              type="success"
              @click="showVedio(scope.row.cameraSrc)"
              size="small"
              >查看详情</el-button
            >
            <el-button type="info" size="small">修改信息</el-button>
            <el-popconfirm
              confirm-button-text="好的"
              cancel-button-text="不用了"
              icon="el-icon-info"
              icon-color="red"
              title="你确定要删除该用户吗"
              @confirm="deleteCameraById(scope.row.cameraId)"
            >
              <el-button type="danger" slot="reference" size="small"
                >删除</el-button
              >
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页条 -->
      <el-pagination
        background
        layout="prev, pager, next"
        :total="100"
        class="pagination"
      >
      </el-pagination>
    </el-card>

    <!-- 视频流dialog -->
    <el-dialog title="监控流详情" :visible.sync="dialogVisible" width="50%">
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

    <!-- 新增camera dialog -->
    <el-dialog
      title="提示"
      :visible.sync="dialogVisibleForAddCamera"
      width="50%"
    >
      <!-- form表单 -->
      <el-form :model="form" label-width="80px">
        <el-form-item label="设备序列号" prop="serialNumber">
          <el-input v-model="form.serialNumber"></el-input>
        </el-form-item>
        <el-form-item label="登录账号" prop="cameraName">
          <el-input v-model="form.cameraName"></el-input>
        </el-form-item>
        <el-form-item label="登录密码" prop="cameraPwd">
          <el-input v-model="form.cameraPwd"></el-input>
        </el-form-item>
        <el-form-item label="登录ip" prop="cameraIp">
          <el-input v-model="form.cameraIp"></el-input>
        </el-form-item>
        <el-form-item label="端口号" prop="cameraPort">
          <el-input v-model="form.cameraPort"></el-input>
        </el-form-item>
        <el-form-item label="坐标信息" prop="cameraLocation">
          <el-input v-model="form.cameraLocation"></el-input>
        </el-form-item>
        <el-form-item label="位置信息描述" prop="cameraPosition">
          <el-input v-model="form.cameraPosition"></el-input>
        </el-form-item>

        <!-- 两个按钮   -->
        <el-form-item class="btn-s">
          <el-button round @click="addCamera">添加</el-button>
          <el-button round>重置</el-button>
        </el-form-item>
      </el-form>
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
      form: {
        serialNumber: "",
        cameraName: "",
        cameraPwd: "",
        cameraIp: "",
        cameraLocation: "",
        cameraPosition: "",
        cameraPort: "",
      },
      dialogVisibleForAddCamera: false,
      push: 11,
      push1: 9,
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
    goBack() {
      this.$router.push("/home");
    },
    addCamearList() {
      this.dialogVisibleForAddCamera = true;
    },
    async addCamera() {
      console.log(this.form);
      const { data: res } = await this.$http.post("/addCamera", this.form);
      if (res.code == 200) {
        console.log(res.code);
        this.$message.success("添加成功");
      } else {
        this.$message.error("添加失败");
      }
    },
  },
};
</script>

<style scoped lang='less'>
.box-card {
  margin-top: 20px;
  background-color: rgb(255, 255, 255);
}
.box-card {
  margin-top: 20px;
}
.pagination {
  margin-top: 20px;
}
.search_box {
  margin-bottom: 20px;
}
</style>