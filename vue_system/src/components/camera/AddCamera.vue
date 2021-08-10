<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb class="el-breadcrumb">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>新增监控</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片系统 -->
    <el-card class="box-card">
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
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        serialNumber: "",
        cameraName: "",
        cameraPwd: "",
        cameraIp: "",
        cameraLocation: "",
        cameraPosition: "",
        cameraPort:"",
      },
    };
  },
  methods: {
    async addCamera() {
      console.log(this.form);
      const { data: res } = await this.$http.post("/addCamera", this.form);
      console.log(res);
    },
  },
};
</script>

<style scope lang='less'>
</style>