<template>
    <div class="bac">

        <van-nav-bar title="个人中心">
            <template #left>
                <van-icon name="arrow-left" @click="goBack"/>
            </template>
            <template #right>
                <van-icon name="ellipsis"/>
            </template>
        </van-nav-bar>
        <div class="headback">
            <van-image
                    round
                    width="100px"
                    height="100px"
                    :src="user.head"
            />
            <div class="username">{{user.name}}</div>
        </div>
        <van-cell is-link @click="editinfo">编辑资料</van-cell>
        <van-cell is-link @click="myOrder">我的订单</van-cell>
        <van-cell is-link @click="myServe">温馨服务</van-cell>
        <van-cell is-link @click="goAbout">关于</van-cell>
        <van-cell is-link @click="logout">登出</van-cell>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                endcity: "杭州",
                background: require("../assets/bac.jpg"),
                user: {
                    name: '张三',
                    head: require('../assets/mineicon/head.jpg')
                }
            }
        },
        created() {
            if (JSON.parse(sessionStorage.getItem('user')) !== null)
                // 从localstorage获取登录信息
                this.user.name = JSON.parse(sessionStorage.getItem('user')).username;
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
             * @Date: 2022/10/21 22:55
             * Description: 跳转编辑个人资料界面
             */
            editinfo() {
                this.$router.push('/setting')
            },
            /**
             * @Author: Kvon
             * @Date: 2022/10/23 11:04
             * Description: 关于界面
             */
            goAbout() {
                this.$router.push('/about')
            },
            /**
             * @Author: Kvon
             * @Date: 2022/10/23 19:31
             * Description: 我的订单
             */
            myOrder() {
                this.$router.push('/myorder')
            },
            /**
             * @Author: Kvon
             * @Date: 2022/10/23 21:02
             * Description: 温馨服务
             */
            myServe() {
                this.$router.push('/myserve')
            },
            logout() {
                this.$router.push("/")
            }
        },

    }
</script>

<style lang="less" scoped>
    .bac {
        background-color: #F0F4F3;
        position: fixed;
        height: 1000px;
        width: 100%;
    }

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

    .headback {
        background: url('../assets/bac.jpg');
        width: 100%;
        height: 220px;
        position: relative;
    }

    .van-image {
        margin-top: 20px;
    }

    .username {
        color: white;
        font-size: 20px;
        margin-top: 10px;
    }

    .van-cell {
        margin: 3px;
    }
</style>
