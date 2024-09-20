<template>
    <div class="q-pa-md wrapperSideBar">
        <q-list bordered separator>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/S3"  class="text-center">S3</RouterLink></q-item-section>
            </q-item>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/RDS" class="text-center">RDS</RouterLink></q-item-section>
            </q-item>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/Cognito" class="text-center">Cognito</RouterLink></q-item-section>
            </q-item>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/CognitoByFargte" class="text-center">Cognitoでバックエンドと接続する</RouterLink></q-item-section>
            </q-item>
        </q-list>
        <!-- <RouterLink to="/">公開用のページ</RouterLink> -->
    </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>
<style scoped>

    
    .wrapperSideBar {
        width: 20vw;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>