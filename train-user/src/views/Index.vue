<template>
  <div class="index">
    <!-- 头部搜索框 -->
    <div class="header" :style="{background: backgroundColor}">
      <van-icon @click="goMine()" class="user" name="manager" color="#ffffff" size="”22px" />
      <van-icon @click="serviceinfo()" class="user" name="service" color="#ffffff" size="22px" />
    </div>
    <div class="bac">
      <!-- 轮播图 -->
      <div class="swipe">
        <van-swipe :autoplay="3000">
          <van-swipe-item v-for="(image, index) in images" :key="index">
            <img v-lazy="image" />
          </van-swipe-item>
        </van-swipe>
      </div>
      <!-- 订购卡片 -->
      <div class="card-back">
        <div class="card">
          <div class="firstline">
            <div class="name1">
              <van-field readonly :value="startcity" @click="selectcity('startcity')" />
            </div>
            <div @click="reverse"><i class="reverse"></i></div>
            <div class="name1">
              <van-field :value="endcity" readonly @click="selectcity('endcity')" />
            </div>
          </div>
          <div class="secondline">
            <van-cell title="出发日期" :value="date" @click="show = true" />
            <van-calendar v-model="show" @confirm="onConfirm" :show-confirm="false" />
          </div>
          <el-checkbox-group v-model="checkList">
            <el-checkbox label="只看高铁"></el-checkbox>
            <el-checkbox label="学生票"></el-checkbox>
          </el-checkbox-group>
          <van-button class="query" color="linear-gradient(to right,#29B8EF , #4b4bff)" round @click="query">查询
          </van-button>
        </div>
        <!-- 天气 -->
        <div class="weather">
          <div class="text">Hi,{{username}},您当前城市为{{LocationCity}}</div>
          <div class="cityWeather">未来七天天气</div>
          <div class="weatherList" v-for="item in weather" :key="item.date">
            <div class="dayItem">{{item.day}}</div>
            <div class="weatherItem">{{item.wea}}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      username: "",
      LocationCity: "当前城市",
      weather: {},
      backgroundColor: 'transparent',
      // 城市
      startcity: '北京',
      endcity: '杭州',
      // 日期
      date: '',
      show: false,
      checkList: [],
      value: '',
      images: [
        require('../assets/indexicon/swiper1.jpg'),
        require('../assets/indexicon/swiper2.jpg'),
        require('../assets/indexicon/swiper3.jpg')
      ],
      lunch: require('../assets/indexicon/lunch.jpg'),
      count: 2 //倒计时
    }
  },
  mounted() {
    this.getCurrentCity();
  },
  created() {
    this.username = JSON.parse(sessionStorage.getItem("user")).username;
    if (sessionStorage.getItem("startcity") != null) {
      this.startcity = sessionStorage.getItem("startcity");
    }
    if (sessionStorage.getItem("endcity") != null)
      this.endcity = sessionStorage.getItem("endcity");
    this.nowDate();
  },

  methods: {
    //通过百度地图获取当前城市
    getCurrentCity() {
      this.$axios({
        url: 'https://www.tianqiapi.com/api/',
        method: "get",
        params: {
          version: 'v1',
          // city: '郑州',      // 若不提供城市名，会根据本机IP获取当地天气
          appid: '83952424',
          appsecret: 'bg4NeEHO'
        },
        headers: {
          'Content-type': 'application/x-www-form-urlencoded'
        },
        data: []
      }).then(res => {
        // console.log(res.data);
        this.LocationCity = res.data.city;
        this.weather = res.data.data;
      });
    },
    goMine() {
      this.$router.push("mine");
    },
    serviceinfo() {
      this.$toast.loading("功能开发中")
    },
    nowDate() {
      var nowDate = new Date();
      let date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        day: nowDate.getUTCDate()
      }
      this.date = date.year + '-' + date.month + '-' + date.day;
    },

    formatDate(date) {
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getUTCDate() + 1}`;
    },
    onConfirm(date) {
      this.show = false;
      this.date = this.formatDate(date);
    },
    selectcity(name) {
      this.$router.push({
        name: 'citylist',
        params: {
          city: name
        }
      });
    },
    reverse() {
      var temp = this.startcity;
      this.startcity = this.endcity;
      this.endcity = temp;
    },
    query() {
      this.$toast.loading({
        message: '查询中....',
        forbidClick: true,
      });
      var type = 2;
      if (this.checkList.indexOf('只看高铁') != -1) {
        type = 0;
      }
      sessionStorage.setItem('traintype', type)
      sessionStorage.setItem('startcity', this.startcity);
      sessionStorage.setItem('endcity', this.endcity);
      localStorage.setItem("traindate", this.date);
      const timejump = 1;
      if (!this.timer) {
        this.count = timejump;
        //this.show = false;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= timejump) {
            this.count--;
          } else {
            //this.show = true;
            clearInterval(this.timer);
            this.timer = null;
            //跳转的页面写在此处             
            this.$router.push('querytrain');
          }
        }, 1000)
      }
    },
  }
}
</script>
<style lang="less" scoped>
.header {
  position: fixed;
  top: 0;
  left: 0;
  // background-color: transparent;
  height: 45px;
  width: 100%;
  display: flex;
  justify-content: space-between;
  z-index: 1;
}

.QR {
  margin: 10px;
  display: inline-block;
  height: 22px;
  width: 22px;
  background-image: url('../assets/QR.png');
  background-size: cover;
  position: relative;
}

.user {
  margin: 10px;
  opacity: 0.8;
  color: #eee;
}

.van-search {
  width: 80%;
  padding: 8px 1px;
  opacity: 0.8;
}

.bac {
  position: relative;
  z-index: 0;
}

.swipe {
  height: 100%;
  background-color: #fffffa;

  img[lazy="loaded"] {
    width: 100%;
    height: 100%;
  }
}

.card-back {
  position: relative;
  z-index: 0;
  height: 600px;
  background-color: #f1f1f180;

}

.card {
  margin: 0 6%;
  position: relative;
  z-index: 2;
  top: -20px;
  // opacity: 0.98;
  background-color: #fff;
  height: 280px;
  width: 88%;
  border-radius: 10px;
  box-shadow: 1px 2px 10px 4px #ccc;
}

.firstline {
  border-bottom: 1px solid #ccc;
  margin: 0 20px;
  display: flex;
  justify-content: space-between;
  padding: 10px 5px;

  .name1 {
    width: 38%;
    font-size: 30px;
    margin: 5px;
    line-height: 50px;
    font-weight: bold;
  }

  .reverse {
    margin: 20px;
    display: inline-block;
    height: 22px;
    width: 22px;
    background-image: url('../assets/QR.png');
    background-size: cover;
    position: relative;
    background-image: url('../assets/indexicon/reverse.png');

    .van-field {
      padding: 0;
    }
  }

  /deep/ .van-field__control {
    font-size: 25px;
    text-align: center;
  }
}

.secondline {
  padding: 5px 0;
  border-bottom: 1px solid #ccc;
  margin: 0 20px;

  .van-cell {
    background-color: #fff;
    color: rgb(170, 165, 165);
    .van-cell__value{
      text-align: center;
    }
  }
}

.el-checkbox-group {
  margin-top: 20px;
}

.query {
  width: 88%;
  margin: 20px;
}

.weather{
  padding:  0 6%;
  .text{
    font-size: 24px;
    font-weight: bold;
    margin-top: 15px;
    margin-bottom: 15px;
  }
  .cityWeather{
    font-weight: bold;
    text-align: left;
    margin-bottom: 10px;
  }
  .weatherList{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    padding: 5px 10px;
    .dayItem{
      flex-grow: 1;
      text-align: left;
    }
    .weatherItem{
      flex-grow: 1;
      text-align: right;
    }
  }
}
</style>