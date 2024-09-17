import { Amplify } from "aws-amplify";

Amplify.configure({
    Auth:{
        region: 'ap-northeast-1',
        userPoolId: '07d48a38-0021-7079-9224-abf8a394b744',
        userPoolWebClientId: '32ajebvdvmtqqh2nn57hdsivlq',
    }
})