<template>
  <div class="login-page-bg">
    <div class="login-box-bg">
      <div class="login-page">
        <el-form
          class="input-form"
          :status-icon="true"
          ref="loginFromRef"
          :model="loginForm"
          label-width="auto">
          <el-form-item class="form-logo">
            <img src="../assets/LoginLogo.png" class="logo" alt="Login">
          </el-form-item>
          <el-form-item
            prop="userOpenId"
            class="input-form-item"
            :rules= "loginFormRules.userId">
            <el-input v-model="loginForm.userOpenId" placeholder="请输入用户ID" style="height: 48px;"><i slot="prefix" class="el-icon-user" style="padding-left: 5px;"></i></el-input>
          </el-form-item>
          <el-form-item
            prop="userPassword"
            class="input-form-item"
            :rules="loginFormRules.userPassword">
            <el-input v-model="loginForm.userPassword" placeholder="请输入用户密码" type="password" style="height: 48px;"><i slot="prefix" class="el-icon-lock" style="padding-left: 5px;"></i></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="login" type="primary" class="submit-button" style="width: 80%;">登录</el-button>
            <el-button @click="resetLoginForm" type="primary" round>重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  created() {
    this.findAllGroups();
  },
  data() {
    return {
      groupList: [],
      // 这是登录表单的数据绑定对象，默认为空
      loginForm: {
        userId: "2021",
        userPassword: "2021",
        groupId: "1",
      },
      loginFormRules: {
        // 验证用户名是否合法
        userId: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            min: 2,
            max: 18,
            message: "长度在 2 到 18 个字符",
            trigger: "blur",
          },
        ],
        //  验证密码是否合法
        userPassword: [
          { required: true, message: "请输入密码", trigger: "blur" },
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
    // 点击重置按钮，重置登录表单
    resetLoginForm() {
      // console.log(this);  $refs: {loginFromRef: VueComponent}
      // 调用表单绑定的ref引用，并调用重置方法
      this.$refs.loginFromRef.resetFields();
    },
    login() {
      this.$refs.loginFromRef.validate(async (valid) => {
        // console.log(valid);
        // 如果某个函数调用的结果打印后返回的是promise，
        // 就马上用saync和await进行优化，async放到方法名称的前面，await放到方法里面
        if (!valid) return; // 前端判定是否合法
        // const result =await this.$http.post("login",this.loginForm);  reslt 打印的值太多， 只取data即可
        const { data: res } = await this.$http.post("login", this.loginForm);
        if (res.code != 200) return this.$message.error("登录失败");
        this.$message.success("登录成功");
        // 页面token存储
        // console.log(JSON.stringify(res))
        window.sessionStorage.setItem("userId", res.data.userId);
        window.sessionStorage.setItem("groupId", res.data.groupId);
        window.sessionStorage.setItem("role", res.data.role);
        window.sessionStorage.setItem("token", res.data.token);
        window.sessionStorage.setItem("user", JSON.stringify(res.data));
        // // 页面跳转
        this.$router.push("/home");
      });
    },
    async findAllGroups() {
      const { data: res } = await this.$http.get("findAllGroups");
      this.groupList = res.data;
      // console.log(this.groupList);
    },
  },
};
</script>


<style scoped lang='less'>
.login-page-bg{
  height: 100%;
  width: 100%;
  background-image: url('../assets/bgimg.jpg');
  background-size:cover;
  overflow: hidden;
}
.login-box-bg{
  height: 100%;
  width: 600px;
  margin: 0px;
  background: #283b54;
  color: #2c3e50;
  float: right;
  opacity: 0.9;
}
.login-page{
  position: relative;
  top: 50%;
  transform: translateY(-50%);
  height: 440px;
  width: 580px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.logo{
  width: 96%;
  height: auto;
  vertical-align: auto;
}
.input-form{
  /* height: 60%; */
  width: 80%;
  margin: 2em;
}
.user-input{
  width: 81%;
  border-radius: 5px;
}
.submit-button{
  /* background: #2d4461; */
  height: 40px;
  /* transition: .5s; */
  border: none;
  /* opacity: .2; */
  color: white;
  border-radius: 4px;
  transition: .5s;
}
</style>