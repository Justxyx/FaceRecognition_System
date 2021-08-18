<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb class="el-breadcrumb">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>新增用户</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片系统 -->
    <el-card class="box-card">
      <!-- form表单 -->
      <el-form
        ref="addUserFormRef"
        :model="form"
        class="addUser_form"
        :rules="addUserFormRules"
        label-width="80px"
      >
        <el-form-item label="工号" prop="userId">
          <el-input v-model="form.userId"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="form.userName"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="userTel">
          <el-input v-model="form.userTel"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email"></el-input>
        </el-form-item>
        <el-form-item label="部门" prop="department">
          <el-input v-model="form.department"></el-input>
        </el-form-item>

        <!-- 上传图片转base64  -->
        <el-upload
          action=""
          :on-change="getFile"
          :limit="1"
          list-type="picture"
          :auto-upload="false"
        >
          <el-button size="small" type="primary"
            >选择图片上传,最多上传一张图片</el-button
          >
        </el-upload>

        <!-- 两个按钮   -->
        <el-form-item class="btn-s">
          <el-button round @click="addUser">添加</el-button>
          <el-button round @click="resetAddUserForm">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      gId: "",
      form: {
        userId: "",
        userName: "",
        userTel: "",
        email: "",
        department: "",
        groupId: "",
        imgBase64: "",
      },
      addUserFormRules: {
        userId: [
          { required: true, message: "请输入工号", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],

        userName: [
          { required: true, message: "请输入姓名", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],
        userTel: [
          { required: true, message: "请输入电话", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],
        email: [
          { required: true, message: "请输入邮箱", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],
        department: [
          { required: true, message: "请输入部门", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    async addUser() {
      this.form.groupId = window.sessionStorage.getItem("groupId");
      console.log(this.form.imgBase64); // base64转换成功
      const { data: res } = await this.$http.post("/addUser", this.form);
      if (res.code == 400) {
        // 添加用户失败
        // 调用重置函数
        return this.$message.error("添加用户失败");
      }
      if (res.code == 200) {
        // 添加用户成功
        // 调用重置函数
        return this.$message.success("添加用户成功");
      }
    },
    resetAddUserForm() {
      this.$refs.addUserFormRef.resetFields();
    },

    // 获取文件
    getFile(file, fileList) {
      this.getBase64(file.raw).then((res) => {
        const params = res.split(",");
        // console.log(params, "params");
        if (params.length > 0) {
          this.form.imgBase64 = params[1];
        }
      });
    },
    // 获取图片转base64
    getBase64(file) {
      return new Promise(function (resolve, reject) {
        const reader = new FileReader();
        let imgResult = "";
        reader.readAsDataURL(file);
        reader.onload = function () {
          imgResult = reader.result;
        };
        reader.onerror = function (error) {
          reject(error);
        };
        reader.onloadend = function () {
          resolve(imgResult);
        };
      });
    },
    // 获取图片转base64
    getBase64(file) {
      return new Promise(function (resolve, reject) {
        const reader = new FileReader();
        let imgResult = "";
        reader.readAsDataURL(file);
        reader.onload = function () {
          imgResult = reader.result;
        };
        reader.onerror = function (error) {
          reject(error);
        };
        reader.onloadend = function () {
          resolve(imgResult);
        };
      });
    },
  },
};
</script>

<style scoped lang='less'>
.box-card {
  background-color: rgb(255, 255, 255);
  margin-top: 20px;
}
</style>