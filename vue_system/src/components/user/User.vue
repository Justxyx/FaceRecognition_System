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
        <el-table-column prop="userTel" label="电话" width="180">
        </el-table-column>
        <el-table-column prop="email" label="邮箱" width="180">
        </el-table-column>
        <el-table-column prop="department" label="部门" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- {{scope.row}} -->
            <el-button
              type="primary"
              @click="shouwImg(scope.row.userId, scope.row.imgPath)"
              >查看图片</el-button
            >

            <template>
              <el-popconfirm
                confirm-button-text="好的"
                cancel-button-text="不用了"
                icon="el-icon-info"
                icon-color="red"
                title="你确定要删除该用户吗"
                @confirm="deleteUserById(scope.row.userId)"
              >
                <el-button slot="reference">删除用户</el-button>
              </el-popconfirm>
            </template>
          </template></el-table-column
        ></el-table
      ></el-card
    >
    <!-- 用户照片dialog -->
    <el-dialog title="照片详情" :visible.sync="dialogVisible" width="50%">
      <div class="demo-image__placeholder">
        <div class="block">
          <el-image :src="src"></el-image>
        </div>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
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
      // 显示用户照片 弹出dialog框
      dialogVisible: false,
      src: "",
    };
  },
  methods: {
    shouwImg(id, imgPath) {
      // dialogVisible=true,
      console.log(id);
      (this.dialogVisible = true), console.log(imgPath);
      this.src = imgPath;
    },
    async getUserList() {
      const { data: res } = await this.$http.get("getUserList");
      this.userList = res.data;
    },
    async deleteUserById(userId) {
      const { data: res } = await this.$http.get("deleteUserById/" + userId);
      this.getUserList();
      if (res.code == 200) {
        this.$message.success("删除成功");
      } else {
        this.$message.error("删除失败");
      }
    },
    // 用户图片dialog
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
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