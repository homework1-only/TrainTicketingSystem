<!--
 * @Author: Kvon
 * @Date: 2022/10/23
 * @Description:
 !-->
<template>

    <div class="myorder">
        <van-nav-bar title="我的订单">
            <template #left>
                <van-icon name="arrow-left" @click="goBack"/>
            </template>
            <template #right>
                <van-icon name="ellipsis"/>
            </template>
        </van-nav-bar>
        <van-pull-refresh v-model="isLoading">
            <!-- 判断是否为空 -->
            <div v-if="orderlist.length!=0">
                <div class="text item" v-for="(item) in orderlist" :key="item.id">
                    <el-card class="box-card">
                        <van-row type="flex" justify="space-between" align="bottom">
                            <van-col span="4" class="otherinfo">{{item.name}}</van-col>
                            <van-col span="6" class="city">{{item.startcity}}</van-col>
                            <van-col span="4"><i class="trainicon"/></van-col>
                            <van-col span="6" class="city">{{item.endcity}}</van-col>
                            <van-col span="4" class="city">¥{{item.price}}</van-col>
                        </van-row>
                        <van-row type="flex" justify="space-between" align="bottom">
                            <van-col span="10" class="times">{{item.starttime}}</van-col>
                            <van-col span="4" id="traindate">至</van-col>
                            <van-col span="10" class="times">{{item.endtime}}</van-col>
                        </van-row>
                        <van-divider dashed/>
                        <van-row class="ticket" type="flex" justify="end" align="bottom">
                            <van-button round size="mini" @click="delOrder(item.id)">删除</van-button>
                        </van-row>
                    </el-card>
                </div>
            </div>
            <!-- 没有火车信息 -->
            <div v-else>
                <van-empty description="无订单记录"/>
            </div>
        </van-pull-refresh>
    </div>
</template>

<script>
    import {Dialog} from 'vant';

    export default {
        name: "MyOrder",
        data() {
            return {
                count: 0,
                isLoading: false,
                orderlist: [{
                    id: 0,
                    name: 'G8491',
                    startcity: '杭州',
                    starttime: '2020-07-18 08:14',
                    endcity: '绍兴',
                    endtime: '2020-07-18 08:59',
                    price: 80.5
                }, {
                    id: 1,
                    name: 'G8888',
                    startcity: '北京',
                    starttime: '2021-02-28 10:14',
                    endcity: '上海',
                    endtime: '2021-02-28 00:59',
                    price: 288.9
                }, {
                    id: 2,
                    name: 'G2866',
                    startcity: '天津',
                    starttime: '2021-07-19 09:14',
                    endcity: '邯郸',
                    endtime: '2021-07-19 23:59',
                    price: 80.5
                }, {
                    id: 3,
                    name: 'G3299',
                    startcity: '浙江',
                    starttime: '2020-03-18 05:14',
                    endcity: '嘉兴',
                    endtime: '2020-03-18 10:59',
                    price: 30.4
                }, {
                    id: 4,
                    name: 'G1709',
                    startcity: '乌鲁木齐',
                    starttime: '2021-04-18 08:14',
                    endcity: '大理',
                    endtime: '2021-04-18 20:59',
                    price: 288.7
                }, {
                    id: 5,
                    name: 'G6384',
                    startcity: '天津',
                    starttime: '2021-03-23 08:24',
                    endcity: '北京',
                    endtime: '2021-03-23 10:00',
                    price: 50.5
                }, {
                    id: 6,
                    name: 'G6591',
                    startcity: '成都',
                    starttime: '2020-01-20 05:14',
                    endcity: '重庆',
                    endtime: '2020-01-20 08:59',
                    price: 56.1
                }, {
                    id: 7,
                    name: 'G4532',
                    startcity: '云南',
                    starttime: '2021-10-28 08:14',
                    endcity: '丽江',
                    endtime: '2021-10-28 10:59',
                    price: 20.5
                }],
            }
        },
        methods: {
            /**
             * @Author: Kvon
             * @Date: 2022/10/21 22:19
             * Description: 返回上一层
             */
            goBack() {
                this.$router.back()
            },
            /**
             * @Author: Kvon
             * @Date: 2022/10/23 20:44
             * Description: 删除订单
             */
            delOrder(id) {
                Dialog.alert({
                    message: '确认删除当前订单吗？删除不可恢复',
                }).then(() => {
                    this.orderlist = this.orderlist.filter(item => item.id !== id)
                });
            }
        }
    }
</script>

<style scoped lang="less">
    .van-nav-bar {
        background-color: rgba(0, 170, 238, 0.886);

        .van-icon {
            font-size: 20px;
            color: #fff;
        }
    }

    /deep/ .van-nav-bar__title {
        color: white;
    }

    [v-cloak] {
        display: none !important;
    }

    .myorder {
        position: relative;
        width: 100%;
    }

    .van-divider {
        margin: 8px 0;
    }

    /deep/ .van-tab {
        background-color: #f8f8f8;
    }

    .el-icon-arrow-left {
        margin-left: 0 !important;
        color: white;
        font-size: 22px;
    }

    /deep/ .el-card__body {
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

    .van-pull-refresh {
        height: 100%;
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
        height: 20px;
        width: 65px;
        display: inline-block;
        background: url('../assets/order/arrive1.png') no-repeat;
    }

    .city {
        font-size: 16px;
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
</style>
