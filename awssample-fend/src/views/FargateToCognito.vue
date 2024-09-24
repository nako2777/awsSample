<template>
  <div>
    <!-- ログインボックス -->
    <div class="boxWrapper">
      <p>Cognitoでバックエンドにログイン</p>
      <q-input
        dense
        rounded
        outlined
        bg-color="white"
        v-model="loginUserName"
        type="text"
        label="ユーザネーム"
      />
      <br />
      <q-input
        dense
        rounded
        outlined
        bg-color="white"
        v-model="loginPassword"
        type="text"
        label="パスワード"
      />
      <br />
      <div class="keepCenter">
        <q-btn
          rounded
          class="btn"
          color="var(--vt-c-black-soft)"
          dense
          label="ログイン"
          @click="login"
        />
      </div>
    </div>
    <!-- todo：グローバルコンポーネントにバグあり -->
    <MyInput></MyInput>
  </div>
</template>

<script setup>
import {
  CognitoIdentityProviderClient,
  SignUpCommand,
  InitiateAuthCommand,
  ResendConfirmationCodeCommand,
  ConfirmSignUpCommand
} from '@aws-sdk/client-cognito-identity-provider'
import { ref } from 'vue'
import api from '@/api'
import axios from 'axios'

const client = new CognitoIdentityProviderClient({ region: 'ap-northeast-1' })
const CLIENTID = import.meta.env.VITE_COGNITO_CLIENT

const loginUserName = ref()
const loginPassword = ref()
const login = () => {
  const command = new InitiateAuthCommand({
    AuthFlow: 'USER_PASSWORD_AUTH',
    ClientId: CLIENTID,
    AuthParameters: {
      USERNAME: loginUserName.value,
      PASSWORD: loginPassword.value
    }
  })

  client
    .send(command)
    .then(response => {
      console.log('Login successful', response)
      alert("アカウントの認証成功しました！")

      //Cognitoからトークンをもらったらバックエンドにリクエストを送る
      axios.post(api.backendCognito,{},{
        headers: {
          'Authorization': `Bearer ${response.AuthenticationResult.AccessToken}`
        }
      }).then(res =>{
        console.log(res)
      })
      
    })
    .catch(error => {
      console.error('Login failed', error)
      alert("アカウントの認証失敗")
    })
}
</script>