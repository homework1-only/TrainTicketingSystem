<!--
 * @Author: Kvon
 * @Date: 2022/10/23
 * @Description: 温馨服务
 !-->
<template>
    <div class="bac">
        <van-nav-bar title="温馨服务">
            <template #left>
                <van-icon name="arrow-left" @click="goBack"/>
            </template>
            <template #right>
                <van-icon name="ellipsis"/>
            </template>
        </van-nav-bar>
        <ul class="nav-side">
            <div class="nav-warpper" v-for="item in categoryData" :key="item.categoryId">
                <!--<img-->
                <!--        width="20px"-->
                <!--        height="20px"-->
                <!--        :src="about.image"-->
                <!--/>-->
                <van-icon :name="item.icon" />
                <div class="title">{{item.categoryName}}</div>
            </div>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "Serve.vue",
        data() {
            return {
                about: {
                    title: '版本5.5.1.6',
                    image: require('../assets/about.png')
                },
                categoryData: [
                    {
                        categoryId: 15,
                        categoryLevel: 1,
                        categoryName: "遗失物品",
                        icon:'warning'
                    },
                    {
                        categoryId: 16,
                        categoryLevel: 1,
                        categoryName: "重点旅客",
                        icon:'smile'
                    },
                    {
                        categoryId: 61,
                        categoryLevel: 1,
                        categoryName: "建议",
                        icon:'comment'

                    },
                    {
                        categoryId: 59,
                        categoryLevel: 1,
                        categoryName: "客服电话",
                        icon:'phone'
                    },
                    {
                        categoryId: 60,
                        categoryLevel: 1,
                        categoryName: "投诉",
                        icon:'service'

                    },
                    {
                        categoryId: 62,
                        categoryLevel: 1,
                        categoryName: "临时身份证明",
                        icon:'card'
                    },
                ],
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
    .bac {
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

    .nav-side {
        display: flex;
        flex-wrap: wrap;

        .nav-warpper {
            width: 121px;
            height: 100px;
            flex: none;
            display: flex;
            border: 1px solid #f2f2f2;
            margin: 0 0 2px 2px;
            flex-direction: column;
            align-items: center;
            justify-content: center;

            .title {
                height: 40px;
                line-height: 40px;
                font-size: 14px;

            }

        }
    }


</style>
