<template>
  <div>
    <!-- 登録ボックス -->
    <div class="boxWrapper">
      <p class="pCenter">登録</p>
      <q-input dense rounded outlined bg-color="white" v-model="signupUserName" type="text" label="ユーザネーム" />
      <br />
      <q-input dense rounded outlined bg-color="white" v-model="signupPassword" type="text" label="パスワード" />
      <br />
      <div class="keepCenter">
        <q-btn rounded class="btn" color="var(--vt-c-black-soft)" dense label="登録" @click="signup" />
      </div>
    </div>
    <!-- ログインボックス -->
  </div>
</template>

<script setup>
import { ref } from 'vue'
// import { Auth } from 'aws-amplify';
import { CognitoIdentityProviderClient, SignUpCommand } from "@aws-sdk/client-cognito-identity-provider";

// AWS.config.region = 'ap-northeast-1'
const client = new CognitoIdentityProviderClient({ region: "ap-northeast-1" });

const signupUserName = ref()
const signupPassword = ref()
const signup = async () => {
  console.log(signupUserName.value)
  console.log(signupPassword.value)

  const command = new SignUpCommand({
    ClientId: 'kf5797rod18qiqrvcqkbmmlt5', // 替换为实际的 Cognito App Client ID
    Username: signupUserName.value,
    Password: signupPassword.value,
    UserAttributes: [
      { Name: 'email', Value: '123@qq.com' },
    ],
  });

  try {
    const response = await client.send(command);
    console.log('登録成功:', response);
  } catch (error) {
    console.error('登録失敗:', error);
  }
}
</script>

<style scoped>
.boxWrapper {
  padding: 20px;
}

.pCenter {
  text-align: center;
}

.btn {
  color: var(--vt-c-text-dark-2) !important;
}
</style>
