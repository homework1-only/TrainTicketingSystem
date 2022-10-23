<!--
 * @Author: Kvon
 * @Date: 2022/10/23
 * @Description: 温馨服务
 !-->
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
    </div>
</template>

<script>
    export default {
        name: "Serve.vue",
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

<style scoped>

</style>
