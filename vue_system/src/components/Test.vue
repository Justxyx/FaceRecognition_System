<template>
  <div>
    <!-- 记得给容器加宽高，不然无法显示 -->
    <div id="myChart" style="width: 500px; height: 300px"></div>
  </div>
  
</template>

<script>
// 引入echarts
var echarts = require("echarts");
export default {
  name: "HelloWorld",
  data() {
    return {};
  },
  created() {
    var then = this;
    // 调用方法创建
    setTimeout(function () {
      then.drawLine();
    }, 500);
  },
  methods: {
    drawLine() {
      var then = this;

      // 初始化echarts实例
      let myChart = echarts.init(document.getElementById("myChart"));

      // 屏幕尺寸变化时，重新调整图表元素大小
      let sizeFun = function () {
        myChart.resize();
      };
      window.addEventListener("resize", sizeFun);

      // 绘制图表
      myChart.setOption({
        title: {
          text: "折线图堆叠",
        },
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: "line",
            smooth: true,
          },
        ],
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      });
    },
  },
};
</script>

<style scoped>
</style>
