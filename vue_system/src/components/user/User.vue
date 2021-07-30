<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb class="el-breadcrumb">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片视图 -->
    <el-card class="box-card">
      <!-- 搜索框 -->
      <el-row :gutter="4">
        <el-col :span="8">
          <!-- 搜索输入框 -->
          <el-input placeholder="搜索用户" class="input-with-select" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
      </el-row>

      <!-- 用户列表table展示区 -->
      <el-table :data="userList" stripe style="width: 100%">
        <el-table-column prop="userId" label="工号" width="180">
        </el-table-column>
        <el-table-column prop="userName" label="姓名" width="180">
        </el-table-column>
        <el-table-column prop="userTel" label="电话" width="180"> </el-table-column>
        <el-table-column prop="email" label="邮箱" width="180"> </el-table-column>
        <el-table-column prop="department" label="部门" width="180"> </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  created() {
    this.groupId = window.sessionStorage.getItem("groupId");
    this.getUserList();
  },
  data() {
    return {
      groupId: "",
      userList: [],
    };
  },
  methods: {
    async getUserList() {
      // const { data: res } = await this.$http.post("login", this.loginForm);
      console.log(this.groupId);
      const { data: res } = await this.$http.get("getUserList/" + this.groupId);
      console.log(res.data);
      this.userList = res.data;
    },
  },
};
</script>

<style scoped lang='less'>
.box-card {
  margin-top: 20px;
  background-color: rgb(250, 246, 239);
}
</style>