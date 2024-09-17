<template>
    <div>
        <!-- 登録ボックス -->
        <div class="boxWrapper">
            <p class="pCenter">登録</p>
            <q-input dense rounded outlined bg-color="white" v-model="signupUserName" type="text" label="ユーザネーム" />
            <br>
            <q-input dense rounded outlined bg-color="white" v-model="signuppassword" type="text" label="パスワード" />
            <br>
            <div class="keepCenter">
                <q-btn rounded class="btn" color="var(--vt-c-black-soft)" dense label="登録" @click="onClick" />
            </div>
        </div>
        <!-- ログインボックス -->
    </div>
</template>

<style scoped>
    .boxWrapper {
        padding: 20px;
        
    }

    .pCenter{
        text-align: center;
    }

    .btn{
        color:  var(--vt-c-text-dark-2) !important;
    }
</style>