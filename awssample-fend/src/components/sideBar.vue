<template>
    <div class="q-pa-md wrapperSideBar">
        <q-list bordered separator>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/S3">S3</RouterLink></q-item-section>
            </q-item>
            <q-item clickable v-ripple>
                <q-item-section><RouterLink to="/RDS">cloudfrontとfargateを繋げる用のページ</RouterLink></q-item-section>
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