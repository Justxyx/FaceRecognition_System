<template>
  <div>
    <!-- 记得给容器加宽高，不然无法显示 -->
    <el-button @click="test"> 简单按钮 </el-button>
  </div>
</template>

<script>
export default {
  methods: {
    async test() {
      const { data: res } = await this.$http.get("test");
      console.log(res)
    },
  },
};
</script>

<style scoped>
</style>
