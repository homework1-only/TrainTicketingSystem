<template>
    <div class="seting-box">
        <van-nav-bar title="添加乘车人">
            <template #left>
                <van-icon color="#fff" name="arrow-left" @click="goBack" />
            </template>
            <template #right>
                <van-icon name="ellipsis" />
            </template>
        </van-nav-bar>
        <div class="input-item">
            <van-field v-model="name" label="姓名" />
            <van-field v-model="code" label="身份证号" />
            <van-checkbox v-model="type">是否学生</van-checkbox>
        </div>
        <van-button @click="saveUser" class="save-btn" type="primary" block>保存</van-button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            name: '',
            code: '',
            type: false
        }
    },
    methods: {
        goBack() {
            this.$router.back()
        },
        saveUser() {
            let nowUser = {
                id: '',
                name: this.name,
                idcard: this.code,
                type: Number(this.type)
            }
            localStorage.setItem('selectuser', JSON.stringify(nowUser));
            this.$router.go(-1);
        }
    }
}
</script>

<style lang="less" scoped>
.van-nav-bar {
    background-color: rgba(0, 170, 238, 0.886);

    .van-icon {
        font-size: 20px;
        color: #252525;
    }
}

/deep/ .van-nav-bar__title {
    color: white;
}

.seting-box {
    .input-item {
        margin-top: 44px;
    }

    .van-checkbox {
        padding: 10px 16px;
    }

    .save-btn {
        width: 80%;
        margin: 20px auto;
        background-color: rgba(0, 170, 238, 0.886);
        border: 0;
    }
}
</style>
