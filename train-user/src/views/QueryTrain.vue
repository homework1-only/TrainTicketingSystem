<template>
  <div class="bac" v-cloak v-if="showflag">
    <van-nav-bar title="火车查询">
      <template #left>
        <i class="el-icon-arrow-left" @click="back"></i>
      </template>
    </van-nav-bar>
    <div class="traindate">{{this.traindate}}</div>
    <div class="trainList">
      <!-- 判断是否为空 -->
      <div v-if="orderlist.length!=0">
        <div class="text item" v-for="(item,index) in orderlist" :key="index" @click="detail(index)">
          <el-card class="box-card">
            <van-row>
              <van-col span="4" class="otherinfo">{{item.name}}</van-col>
              <van-col span="7" class="city">{{item.startcity}}</van-col>
              <van-col span="6"><i class="trainicon" /></van-col>
              <van-col span="7" class="city">{{item.endcity}}</van-col>
            </van-row>
            <van-row>
              <van-col span="7" offset="4" class="times">{{item.starttime}}</van-col>
              <van-col span="6" id="traindate">{{item.duration}}</van-col>
              <van-col span="7" class="times">{{item.endtime}}</van-col>
            </van-row>
            <van-divider dashed />
            <van-row class="ticket">
              <van-col span="7">一等：{{item.fnum}} 张</van-col>
              <van-col span="7" offset="9">二等：{{item.snum}} 张</van-col>
            </van-row>
          </el-card>
        </div>
        <!-- <div class="fill"></div> -->
      </div>
      <!-- 没有火车信息 -->
      <div v-else>
        <van-empty description="试试乘坐其他班次吧" />
      </div>
    </div>
    <div class="test"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 标志位
      showflag: true,
      startcity: '杭州',
      endcity: '绍兴',
      traintype: 0,
      count: 0,
      isLoading: false,
      traindate: '2020-5-30',
      orderlist: [{
        id: '',
        name: 'G8490',
        startcity: '杭州',
        starttime: '12:37',
        endcity: '绍兴',
        endtime: '13:35',
        duration: '58分钟',
        fnum: '32',
        snum: '44',
        fprice: 196,
        sprice: 123
      },
      {
        id: '',
        name: 'G8491',
        startcity: '杭州',
        starttime: '14:37',
        endcity: '绍兴',
        endtime: '15:35',
        duration: '58分钟',
        fnum: '63',
        snum: '4',
        fprice: 130,
        sprice: 80.5
      },
      {
        id: '',
        name: 'G8492',
        startcity: '杭州',
        starttime: '18:37',
        endcity: '绍兴',
        endtime: '19:35',
        duration: '58分钟',
        fnum: '39',
        snum: '42',
        fprice: 150,
        sprice: 120
      },
      {
        id: '',
        name: 'G8493',
        startcity: '杭州',
        starttime: '20:37',
        endcity: '绍兴',
        endtime: '21:35',
        duration: '58分钟',
        fnum: '63',
        snum: '43',
        fprice: 101,
        sprice: 68
      },
      {
        id: '',
        name: 'G8494',
        startcity: '杭州',
        starttime: '22:37',
        endcity: '绍兴',
        endtime: '23:35',
        duration: '58分钟',
        fnum: '63',
        snum: '43',
        fprice: 101,
        sprice: 68
      }],
    };
  },
  created() {
    if (localStorage.getItem('traindate'))
      this.traindate = localStorage.getItem('traindate');
    if (sessionStorage.getItem("startcity") != null) {
      this.startcity = sessionStorage.getItem("startcity");
      this.endcity = sessionStorage.getItem("endcity");
      this.traintype = sessionStorage.getItem('traintype');
    }
    this.trainquery();
  },
  methods: {
    back() {
      this.$router.go(-1);
    },
    detail(index) {
      // 这里通过localstorage传参
      localStorage.setItem('trainorder', JSON.stringify(this.orderlist[index]))
      this.$router.push({
        name: 'confirmorder',
      })
    },
  },
}
</script>

<style lang="less" scoped>
[v-cloak] {
  display: none !important;
}

.bac {
  // background-color:red;
  position: relative;
  // height: 200%;
  width: 100%;
}

.van-nav-bar {
  background-color: rgba(0, 170, 238, 1);
  position: fixed;
  width: 100%;
}

/deep/.van-nav-bar__title {
  color: white;
}

/deep/.van-tab {
  background-color: #f8f8f8;
}

.el-icon-arrow-left {
  margin-left: 0 !important;
  color: white;
  font-size: 22px;
}

/deep/.el-card__body {
  padding: 8px;
}

.traindate {
  position: fixed;
  top: 45px;
  height: 22px;
  font-size: 16px;
  width: 100%;
  background-color: rgba(0, 170, 238, 1);
  border: none;
  color: whitesmoke;
  z-index: 1;
}

.trainList{
  padding-top: 80px;
  height: 580px;
  overflow: scroll;
}

.box-card {
  background: #fbfbfb;
  border-radius: 10px;
  margin: 10px;
}

.fill {
  height: 200px;
}

.trainicon {
  background-color: red;
  height: 20px;
  width: 65px;
  display: inline-block;
  background: url('../assets/order/arrive1.png') no-repeat;
}

.city {
  font-size: 20px;
  font-weight: bold;
}

.otherinfo {
  font-size: 18px;
  margin-top: 5px;
}

#traindate {
  color: #aaa;
  font-size: 14px;
}

.times {
  color: rgba(0, 170, 238, 1);
  font-size: 13px;
}

.ticket {
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size: 13px;
}
</style>