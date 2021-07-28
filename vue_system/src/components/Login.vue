<template>
  <div>
    <div>这是一个登录界面</div>
    <div class="login_box">
      <!-- 输入文本框以及按钮区域 -->
      <el-form
        ref="loginFromRef"
        class="login_form"
        :model="loginForm"
        :rules="loginFormRules"
      >
        <!-- 账户 -->
        <el-form-item prop="userId">
          <el-input
            v-model="loginForm.userId"
            prefix-icon="iconfont icon-yidongduanicon-"
          ></el-input>
        </el-form-item>
        <!-- 密码 type="userPassword" 设置为密码属性 -->
        <el-form-item prop="userPassword">
          <el-input
            v-model="loginForm.userPassword"
            prefix-icon="iconfont icon-mima"
            type="Password"
          ></el-input>
        </el-form-item>
        <!-- 两个按钮   -->
        <el-form-item class="btn-s">
          <el-button round @click="login">登录</el-button>
          <el-button round @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 这是登录表单的数据绑定对象，默认为空
      loginForm: {
        userId: "2022",
        userPassword: "123456",
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
        // console.log(res)

        window.sessionStorage.setItem("user", JSON.stringify(res.data));
        // // 页面跳转
        this.$router.push("/home");
      });
    },
  },
};
</script>


<style scoped lang='less'>
.login_box{
    /* 盒子居中 */
  width: 450px;
  height: 300px;
  // background-color: #eee;
  border-radius: 3px;
  // 一下三个函数为移动盒子
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>