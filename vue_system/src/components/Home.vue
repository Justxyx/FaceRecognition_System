<template>
  <div>
    这是一个首页
    <div>
      <button @click="isToken">这是一个跳转按钮</button>
    </div>
  </div>
</template>

<script>
export default {
  methods:{
    async isToken(){
       const { data: res } = await this.$http.get("token");
    }
  }

}
</script>

<style scoped lang='less'>

</style>