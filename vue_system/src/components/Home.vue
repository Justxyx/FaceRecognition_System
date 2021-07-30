<template>
  <div>
    <el-container>
      <el-header>
        <p>云端门禁管理系统</p>
      </el-header>
      <el-container>
        <!-- 侧边栏菜单系统 -->
        <el-aside width="200px">
          <el-menu
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            unique-opened
            :collapse-transition="false"
            router
          >
            <!-- 一级菜单 -->
            <el-submenu
              :index="item.id + ''"
              v-for="item in menusList"
              :key="item.id"
            >
              <!-- 一级菜单的模板区域 -->
              <template slot="title">
                <span>{{ item.authName }}</span>
              </template>
              <!-- 二级菜单 -->
              <el-menu-item
                :index="ite.path + ''"
                v-for="ite in item.children"
                :key="ite.id"
              >
                <span>{{ ite.authName }}</span>
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>

        <el-main>
          <!-- 作为占位符 -->
          <router-view></router-view>
        </el-main>
      </el-container>
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
      const { data: res } = await this.$http.get("menus");
      this.menusList = res.data;
    },
  },
};
</script>

<style scoped lang='less'>
.el-header {
  background-color: rgb(245, 246, 248);
}
.el-aside {
  background-color: rgb(245, 246, 248);
}
</style>