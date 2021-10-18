<template>
  <div>
    <el-page-header @back="goBack" content="用户管理"> </el-page-header>

    <!-- 卡片视图 -->
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
          ><el-button type="success" @click="addUser1" size="small"
            >新增用户</el-button
          >
        </el-col>
        <el-col :span="4" :push="push1">
          <el-button type="info" size="small">批量导入</el-button>
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
              size="small"
              >查看详情</el-button
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
                <el-button slot="reference" size="small">删除用户</el-button>
              </el-popconfirm>
            </template>
          </template></el-table-column
        >
      </el-table>

      <!-- 分页条 -->
      <el-pagination
        background
        layout="prev, pager, next"
        :page-count="parseInt(this.paging.totalPage)"
        :current-page="parseInt(this.paging.pageNo)"
        @current-change="handleCurrentChange"
        class="pagination"
      >
      </el-pagination>
    </el-card>
    <!-- 新增用户dialog -->
    <el-dialog
      title="提示"
      :visible.sync="dialogVisibleForAddUser"
      width="50%"
      :before-close="handleClose"
    >
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
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">点击此处上传证件照片</div>
          <div class="el-upload__tip" slot="tip">
            只能上传jpg/png文件，且不超过500kb
          </div>
        </el-upload>

        <!-- 两个按钮   -->
        <el-form-item class="btn-s">
          <el-button round @click="addUser">添加</el-button>
          <el-button round @click="resetAddUserForm">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 用户照片dialog -->
    <el-dialog title="照片详情" :visible.sync="dialogVisible" width="50%">
      <div class="demo-image__placeholder">
        <div class="block">
          <el-image :src="src"></el-image>
        </div>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="warning">修改用户信息</el-button>
        <el-button type="primary" @click="dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
    -
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
      // 分页工具
      paging: {
        pageNo: "1", // 当前页码数（默认给1），需要传参
        pageSize: "5", // 每页显示的行数，需要传参
        totalPage: "", // 总页数，是根据总行数和每页显示的行数计算出来的结果
        rows: "", //总行数，总行数是查询出来的数据表总记录数
      },
      // 显示用户照片 弹出dialog框
      dialogVisible: false,
      dialogVisibleForAddUser: false,
      src: "",
      push: 11,
      push1: 9,
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
    // 分页工具
    handleCurrentChange: function (currentPage) {
      this.paging.pageNo = currentPage;
      console.log(this.paging.pageNo); //点击第几页
      this.getUserList();
    },
    shouwImg(id, imgPath) {
      // dialogVisible=true,
      console.log(id);
      this.dialogVisible = true;
      console.log(imgPath);
      this.src = imgPath;
    },
    async getUserList() {
      const { data: res } = await this.$http.get(
        "getUserList/" + this.paging.pageNo + "/" + this.paging.pageSize
      );
      console.log(res);
      this.userList = res.data.lists;
      this.paging.totalPage = res.data.totalPage;
      this.paging.rows = res.data.rows;
      console.log(this.paging.pageNo);
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
    goBack() {
      this.$router.push("/home");
    },
    addUser1() {
      this.dialogVisibleForAddUser = true;
    },
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
        this.getUserList();
        this.dialogVisibleForAddUser = false;
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
  margin-top: 20px;
  background-color: rgb(255, 255, 255);
}
.search_box {
  margin-bottom: 20px;
}
.pagination {
  margin-top: 20px;
}
</style>