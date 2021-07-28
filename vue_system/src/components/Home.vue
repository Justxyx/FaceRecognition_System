<template>
  <div>
    <el-container>
      <el-header >
          <p>云端门禁管理系统</p>
      </el-header>
      <el-container>
        <el-aside width="200px">侧边栏系统</el-aside>
        <el-main>卡片系统，主要展示区</el-main>
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
    };
  },
  methods: {
    async isToken() {
      const { data: res } = await this.$http.get("checkToken");
    },
    async getMenus(){
      const{data:res} = await this.$http.get("menus")
      console.log(res.data)
    }
  },
};
</script>

<style scoped lang='less'>
.el-header{
  background-color: rgb(224, 227, 231);
}
.el-aside{
  background-color: rgb(14, 111, 238);
}


</style>