<!--
 * @Author: Kvon
 * @Date: 2022/10/23
 * @Description: 关于界面
 !-->
<template>
    <div class="about">
        <van-nav-bar title="关于">
            <template #left>
                <van-icon name="arrow-left" @click="goBack"/>
            </template>
            <template #right>
                <van-icon name="ellipsis"/>
            </template>
        </van-nav-bar>
        <div class="headback">
            <van-image
                    width="100px"
                    height="100px"
                    :src="about.image"
            />
            <div class="username">{{about.title}}</div>
        </div>
        <van-row class="vanrow" type="flex" justify="space-between">
            <van-col span="5">客服电话</van-col>
            <van-col span="15"></van-col>
            <van-col span="4">12306</van-col>
        </van-row>
        <van-row class="vanrow" type="flex" justify="space-between">
            <van-col span="6">微信公众号</van-col>
            <van-col span="12"></van-col>
            <van-col span="6">CRTT12306</van-col>
        </van-row>
        <van-row class="vanrow" type="flex" justify="space-between">
            <van-col span="5">隐私政策</van-col>
            <van-col span="17"></van-col>
            <van-col span="2">
                <i class="el-icon-arrow-right"></i>
            </van-col>
        </van-row>
        <van-row class="vanrow" type="flex" justify="space-between">
            <van-col span="5">服务条款</van-col>
            <van-col span="17"></van-col>
            <van-col span="2">
                <i class="el-icon-arrow-right"></i>
            </van-col>
        </van-row>
    </div>
</template>

<script>
    export default {
        name: "About.vue",
        data() {
            return {
                about: {
                    title: '版本5.5.1.6',
                    image: require('../assets/about.png')
                }
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
        }
    }
</script>

<style scoped lang="less">
    .vanrow {
        height: 40px;
        line-height: 40px;
        border-bottom: 1px solid #f2f2f2;
        font-size: 14px;
    }

    .headback {
        width: 100%;
        height: 150px;
        position: relative;
    }

    .van-image {
        margin-top: 20px;
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


    .about-body {
        padding: 20px;
        font-size: 16px;

        a {
            color: #007fff !important;
        }
    }
</style>
