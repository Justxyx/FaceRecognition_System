<template>
  <div>
    <!-- 导航区 -->
    <el-page-header @back="goBack" content="统计信息"> </el-page-header>
    <el-card class="box-card">
      <el-row :gutter="10">
        <!-- 左侧功能区域 -->
        <el-col :span="13">
          <!-- 地图显示模块 -->
          <el-col :span="24" class="el-col0"
            ><el-image :src="src"></el-image
          ></el-col>

          <!-- 实时检测模块 -->
          <el-col :span="24" class="el-col1">
            <el-row :gutter="10">
              <el-col :span="4" :push="1" style="font-weight: bold"
                >实时检测</el-col
              >
              <el-col :span="4" :push="16"
                ><el-link type="info">查看更多</el-link></el-col
              >
            </el-row>
            <el-row :gutter="10">
              <el-col :span="22" class="el-col2" :push="1">
                <el-row>
                  <el-col :span="6"><el-image :src="src1"></el-image></el-col>
                  <el-col :span="12">
                    <p class="p1">【时间】：2021.8.18 13.21.18</p>
                    <p class="p1">【摄像头IP】：192.168.1.2</p>

                    <p class="p1">【检测地点】：本科生院7楼南</p>
                    <p class="p1">
                      【现场照片】：<el-link class="p1">点击查看 </el-link>
                    </p>
                    <p class="p1">
                      【详细情况】：<el-link class="p1">点击查看 </el-link>
                    </p>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="22" class="el-col2" :push="1">
                <el-row>
                  <el-col :span="6"><el-image :src="src1"></el-image></el-col>
                  <el-col :span="12">
                    <p class="p1">【时间】：2021.8.18 13.21.18</p>
                    <p class="p1">【摄像头IP】：192.168.1.2</p>

                    <p class="p1">【检测地点】：本科生院7楼南</p>
                    <p class="p1">
                      【现场照片】：<el-link class="p1">点击查看 </el-link>
                    </p>
                    <p class="p1">
                      【详细情况】：<el-link class="p1">点击查看 </el-link>
                    </p>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="22" class="el-col2" :push="1">
                <el-row>
                  <el-col :span="6"><el-image :src="src1"></el-image></el-col>
                  <el-col :span="12">
                    <p class="p1">【时间】：2021.8.18 13.21.18</p>
                    <p class="p1">【摄像头IP】：192.168.1.2</p>
                    <p class="p1">【检测地点】：本科生院7楼南</p>
                    <p class="p1">
                      【现场照片】：<el-link class="p1">点击查看 </el-link>
                    </p>
                    <p class="p1">
                      【详细情况】：<el-link class="p1">点击查看 </el-link>
                    </p>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
          </el-col>
        </el-col>

        <!-- 右侧功能区域 -->
        <!-- 统计模块1 -->
        <el-col :span="10" class="el-row2">
          <el-col :span="24" class="el-col0">
            <el-row :gutter="10">
              <el-col :span="4" :push="1" style="font-weight: bold"
                >每日统计</el-col
              >
              <el-col :span="4" :push="16"
                ><el-link type="info">查看更多</el-link></el-col
              >
            </el-row>
            <el-row
              ><div id="myChart" style="width: 450px; height: 300px"></div
            ></el-row>
          </el-col>
        </el-col>

        <!-- 统计模块2 -->
        <el-col :span="10" class="el-row2">
          <el-col :span="24" class="el-col0">
            <el-row :gutter="10">
              <el-col :span="4" :push="1" style="font-weight: bold"
                >每周统计</el-col
              >
              <el-col :span="4" :push="16"
                ><el-link type="info">查看更多</el-link></el-col
              >
            </el-row>
            <el-row
              ><div id="myChart2" style="width: 450px; height: 300px"></div
            ></el-row>
          </el-col>
        </el-col>

        <!-- 统计模块3 -->
        <el-col :span="10" class="el-row2">
          <el-col :span="24" class="el-col0">
            <el-row :gutter="10">
              <el-col :span="4" :push="1" style="font-weight: bold"
                >总统计</el-col
              >
              <el-col :span="4" :push="16"
                ><el-link type="info">查看更多</el-link></el-col
              >
            </el-row>
            <el-row>
              <div id="myChart3" style="width: 600px; height: 300px"></div
            ></el-row>
          </el-col>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
var echarts = require("echarts");
export default {
  data() {
    return {
      src: require("@/assets/p2.png"),
      src1: require("@/assets/p3.png"),
    };
  },
  created() {
    var then = this;
    // 调用方法创建
    setTimeout(function () {
      then.drawLine();
      then.drawLine2();
      then.drawLine3();
    }, 500);
  },
  methods: {
    goBack() {
      this.$router.push("/home");
    },

    // 右侧统计图1
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
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        legend: {
          data: ["昨天", "今天"],
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: {
          type: "value",
          boundaryGap: [0, 0.01],
        },
        yAxis: {
          type: "category",
          data: [
            "摄像头1",
            "摄像头2",
            "摄像头3",
            "摄像头4",
            "摄像头5",
            "总统计次数(次)",
          ],
        },
        series: [
          {
            name: "昨天",
            type: "bar",
            data: [18203, 23489, 29034, 104970, 131744, 630230],
          },
          {
            name: "今天",
            type: "bar",
            data: [19325, 23438, 31000, 121594, 134141, 681807],
          },
        ],

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      });
    },

    // 右侧绘图2
    drawLine2() {
      var then = this;

      // 初始化echarts实例
      let myChart2 = echarts.init(document.getElementById("myChart2"));

      // 屏幕尺寸变化时，重新调整图表元素大小
      let sizeFun = function () {
        myChart2.resize();
      };
      window.addEventListener("resize", sizeFun);

      // 绘制图表
      myChart2.setOption({
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  
        tooltip: {
          trigger: "axis",
        },
        legend: {
          data: ["摄像头1", "摄像头2", "摄像头3", "摄像头4", "摄像头5"],
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        toolbox: {
          feature: {
            saveAsImage: {},
          },
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            name: "摄像头1",
            type: "line",
            stack: "总量",
            data: [120, 132, 101, 134, 90, 230, 210],
          },
          {
            name: "摄像头2",
            type: "line",
            stack: "总量",
            data: [220, 182, 191, 234, 290, 330, 310],
          },
          {
            name: "摄像头3",
            type: "line",
            stack: "总量",
            data: [150, 232, 201, 154, 190, 330, 410],
          },
          {
            name: "摄像头4",
            type: "line",
            stack: "总量",
            data: [320, 332, 301, 334, 390, 330, 320],
          },
          {
            name: "摄像头5",
            type: "line",
            stack: "总量",
            data: [820, 932, 901, 934, 1290, 1330, 1320],
          },
        ],

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      });
    },

    // 右侧绘图3
    drawLine3() {
      var then = this;

      // 初始化echarts实例
      let myChart3 = echarts.init(document.getElementById("myChart3"));

      // 屏幕尺寸变化时，重新调整图表元素大小
      let sizeFun = function () {
        myChart3.resize();
      };
      window.addEventListener("resize", sizeFun);

      // 绘制图表
      myChart3.setOption({
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

 
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          left: "left",
        },
        series: [
          {
            name: "访问来源",
            type: "pie",
            radius: "50%",
            data: [
              { value: 1048, name: "摄像头1" },
              { value: 735, name: "摄像头2" },
              { value: 580, name: "摄像头3" },
              { value: 484, name: "摄像头4" },
              { value: 300, name: "摄像头5" },
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      });
    },
  },
};
</script>

<style scoped lang='less'>
.box-card {
  margin-top: 20px;
}
.el-col0 {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.el-col1 {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.el-col2 {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.el-col {
  margin-top: 10px;
}
.el-row3 {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.p1 {
  // font-family: Helvetica,
  font-size: 12px;
}
</style>