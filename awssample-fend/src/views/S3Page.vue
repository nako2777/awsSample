<template>
    <div>
        <q-btn v-if="!connetStatus" label="Connect" @click="connect" />
        <div v-if="connetStatus" class="s3Wrapper">
            <q-list bordered>
                <q-item class="keepCenter">
                    <q-item-section top avatar>
                        <h4>{{ bucketName }}のファイル一覧</h4>
                        <hr>
                    </q-item-section>
                </q-item>
                <q-item @click="getS3File(item.key)" clickable v-ripple v-for="item in s3List">

                    <q-item-section>{{ item.key }}</q-item-section>
                    <q-item-section>{{ item.size }}kb</q-item-section>
                </q-item>
            </q-list>
        </div>
    </div>
</template>

<script setup>
import func from '@/common/function'
import axios from 'axios'
import api from '@/api'
import { reactive, ref } from 'vue'
let s3List = reactive([]);
const connetStatus = ref(false)
const bucketName = import.meta.env.VITE_S3_NAME
async function connect() {
    if (await func.healthCheck()) {
        getS3List()
    } else {
        alert('バックエンドと繋がっていない')
    }

}

function getS3List() {
    axios.get(api.getS3List + `?bucketName=${bucketName}`).then(res => {

        Object.assign(s3List, res.data)
        console.log(`output->connetStatus.value`, connetStatus.value)
        connetStatus.value = true

        console.log(`output->connetStatus.value`, connetStatus.value)
    })
}


function getS3File(keyName) {
    axios.get(api.getS3File + `?bucketName=${import.meta.env.VITE_S3_NAME}&keyName=${keyName}`).then(res => {
        const url = window.URL.createObjectURL(new Blob([res.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', keyName); // 指定下载的文件名
        document.body.appendChild(link);
        link.click();
        document.body.removeAttribute(link);
    })
}


</script>

<style scoped>
.s3Wrapper {
    width: 60vw;
    height: 80vh;
    padding: 20px;
    border: 1px solid var(--color-border);
}

.q-list--bordered {
    border: none;
}
</style>