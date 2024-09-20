<template>
  <div>
    <!-- 登録ボックス -->
    <div class="boxWrapper">
      <p class="pCenter">登録</p>
      <q-input
        dense
        rounded
        outlined
        bg-color="white"
        v-model="signupUserName"
        type="text"
        label="ユーザネーム"
      />
      <br />
      <q-input
        dense
        rounded
        outlined
        bg-color="white"
        v-model="signupPassword"
        type="text"
        label="パスワード"
      />
      <br />
      <q-input
        dense
        rounded
        outlined
        bg-color="white"
        v-model="signupEmail"
        type="text"
        label="eメール"
      />
      <br />
      <div class="keepCenter">
        <q-btn
          rounded
          class="btn"
          color="var(--vt-c-black-soft)"
          dense
          label="登録"
          @click="signup"
        />
      </div>
    </div>
    <!-- ログインボックス -->
    <div class="boxWrapper">
      <p class="pCenter">ログイン</p>
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

    <!-- 登録後認証コードで認証する -->
    <q-dialog v-model="confirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <q-input v-model="confirmCode" type="text" label="eメールで貰った認証コード" dense />
        </q-card-section>
        <q-card-actions align="right">
          <q-btn flat label="キャンセル" color="primary" v-close-popup />
          <q-btn
            flat
            label="認証する"
            @click="sendConfirm"
            color="primary"
            v-close-popup
          />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue'
// import { Auth } from 'aws-amplify';
import {
  CognitoIdentityProviderClient,
  SignUpCommand,
  InitiateAuthCommand,
  ResendConfirmationCodeCommand,
  ConfirmSignUpCommand
} from '@aws-sdk/client-cognito-identity-provider'

// AWS.config.region = 'ap-northeast-1'
const client = new CognitoIdentityProviderClient({ region: 'ap-northeast-1' })
const CLIENTID = import.meta.env.VITE_COGNITO_CLIENT
const confirm = ref(false)

const signupUserName = ref()
const signupPassword = ref()
const signupEmail = ref()

const loginUserName = ref()
const loginPassword = ref()
const signup = async () => {
  console.log(signupUserName.value)
  console.log(signupPassword.value)

  const command = new SignUpCommand({
    ClientId: CLIENTID,
    Username: signupUserName.value,
    Password: signupPassword.value,
    UserAttributes: [
      {
        Name: 'email',
        Value: signupEmail.value
      }
    ]
  })

  try {
    const response = await client.send(command)
    console.log('登録成功:', response)
    //認証コードを送ります
    const confirmInput = {
      ClientId: CLIENTID,
      Username: signupUserName.value
    }

    try {
      const confirmCommand = new ResendConfirmationCodeCommand(confirmInput)
      const res = await client.send(confirmCommand)
      confirm.value = true
    } catch (error) {
      console.log('send confirmation code error:', error)
    }

    // ConfirmSignUpCommand
  } catch (error) {
    console.error('登録失敗:', error)
  }
}

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
    })
    .catch(error => {
      console.error('Login failed', error)
      alert("アカウントの認証失敗")
    })
}

const confirmCode = ref('')
const sendConfirm = async () => {
  console.log(confirmCode.value)
  console.log(signupUserName.value)
  const confirmInput = {
    ClientId: CLIENTID,
    Username: signupUserName.value,
    ConfirmationCode: confirmCode.value
  }
  try {
    const confirmCommand = new ConfirmSignUpCommand(confirmInput)
    const response = await client.send(confirmCommand)
    alert("登録成功しました！")
  } catch (error) {
    console.error(error)
    alert("登録失敗！")
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
