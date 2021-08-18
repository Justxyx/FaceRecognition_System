<template>
  <div>
    <el-container>
      <el-header>
        <p>
          <font size="6">武汉大学云端门禁管理系统</font>
        </p>
      </el-header>

      <el-container class="main_container">
        <el-aside width="150px">
          <el-menu default-active="2" class="el-menu-vertical-demo" router>
            <el-menu-item
              v-for="item in menusList"
              :index="item.path + ''"
              :key="item.id"
            >
              <i class="el-icon-menu"></i>
              <span slot="title">{{ item.authName }}</span>
            </el-menu-item>
          </el-menu>
        </el-aside>

        <el-main class="main_el">
          <!-- 作为占位符 -->
          <router-view></router-view>
        </el-main>
      </el-container>

      <el-footer class="footer_container" height="100px">
        <p>
          武汉大学 版权所有Copyright 2020-2025, All Rights Reserved
          鄂ICP备16007882
        </p>
        <p>京ICP证110745号 京ICP备13052560号-1 京公网安备11010802020088号</p>
        <p>@联系我们 xxx-xxxxxxxx</p>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  created() {
    this.user = JSON.parse(window.sessionStorage.getItem("user"));
    this.getMenus();
  },
  data() {
    return {
      user: "",
      menusList: [],
    };
  },
  methods: {
    async getMenus() {
      const { data: res } = await this.$http.get("menusAlone");
      this.menusList = res.data;
    },
  },
};
</script>

<style scoped lang='less'>
.el-header {
  margin-top: 0px;
  background-color: rgb(255, 255, 255);
}
.el-aside {
  background-color: rgb(255, 255, 255);
}
.main_container {
  margin-top: 20px;
  margin-left: 50px;
  margin-right: 50px;
}
.main_el {
  background-color: rgb(255, 255, 255);
  margin-left: 20px;
}
.footer_container {
  background-color: rgb(255, 255, 255);
  margin-top: 20px;
  font-family: "微软雅黑";
  font-size: small;
  color: #adacac;
}
</style>