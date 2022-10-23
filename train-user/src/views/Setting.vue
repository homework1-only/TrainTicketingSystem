<!--
 * @Author: Kvon
 * @Date: 2022/10/21
 * @Description:
 !-->
<template>
    <div class="seting-box">
        <van-nav-bar title="编辑资料">
            <template #left>
                <van-icon name="arrow-left" @click="goBack"/>
            </template>
            <template #right>
                <van-icon name="ellipsis"/>
            </template>
        </van-nav-bar>
        <van-form @submit="onSubmit">
            <van-field
                    v-model="username"
                    name="用户名"
                    label="用户名"
                    placeholder="用户名"
                    :rules="[{ required: true, message: '请填写用户名' }]"
            />
            <van-field
                    v-model="password"
                    type="password"
                    name="密码"
                    label="密码"
                    placeholder="密码"
                    :rules="[{ required: true, message: '请填写密码' }]"
            />
            <div style="margin: 16px;">
                <van-button round block type="info" native-type="submit">提交</van-button>
            </div>
        </van-form>
        <!--<div class="input-item">-->
        <!--    <van-field v-model="username" label="用户名"    :rules="[{ required: true, message: '请填写用户名' }]"/>-->
        <!--    <van-field v-model="password" type='password' label="修改密码"  :rules="[{ required: true, message: '请填写密码' }]"/>-->
        <!--</div>-->
        <!--<van-button class="save-btn" type="primary" block>保存</van-button>-->
        <!--<van-button class="save-btn" type="primary" block>退出登录</van-button>-->
    </div>
</template>

<script>
    import { Toast } from 'vant'
    export default {
        data() {
            return {
                username: '',
                password: ''
            }
        },
        async mounted() {
            // const { data } = await getUserInfo()
            // this.nickName = data.nickName
            // this.introduceSign = data.introduceSign
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
             * @Date: 2022/10/23 10:49
             * Description: 提交修改内容
             */
            onSubmit(values) {
                if (values) {
                    // const { data } = await EditUserInfo(params)
                    Toast.success('保存成功')
                }

            }
            // async save() {
            //     const params = {
            //         introduceSign: this.introduceSign,
            //         nickName: this.nickName,
            //         passwordMd5: this.$md5(this.password)
            //     }
            //     const { data } = await EditUserInfo(params)
            //     Toast.success('保存成功')
            // },
            // async logout() {
            //     const { resultCode } = await logout()
            //     if (resultCode == 200) {
            //         setLocal('token', '')
            //         window.location.href = '/'
            //     }
            // }
        }
    }
</script>

<style lang="less" scoped>
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

    .seting-box {
        .input-item {
            margin-top: 44px;
        }

        .save-btn {
            width: 80%;
            margin: 20px auto;
            background-color: rgba(0, 170, 238, 0.886);
            border: 0;
        }
    }
</style>

