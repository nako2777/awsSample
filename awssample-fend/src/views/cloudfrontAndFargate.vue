<template>
  <div>
    <div class="apiBox">
      <h5>疎通確認:</h5>
      <q-btn @click="healthCheck">health Check</q-btn>
    </div>
    <div class="apiBox">
      <h5>S3:</h5>
      <q-btn @click="getS3List">get bucket list</q-btn>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import api from '@/api'
function healthCheck () {
  console.log(api)
  axios.get(api.healthCheck).then(res => {
    console.log(res)
  })
}

function getS3List(){
    axios.get(api.getS3List + `?bucketName=${import.meta.env.VITE_S3_NAME}`).then(res => {
    console.log(res)
  })
}
</script>

<style>
.apiBox {
  margin-bottom: 30px;
  display: flex;
  align-items: center;
}
h5 {
  display: inline;
  padding-right: 20px;
}
</style>
