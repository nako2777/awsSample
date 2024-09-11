<script setup>
import { RouterLink, RouterView } from 'vue-router'
import SideBar from './components/sideBar.vue'
</script>

<template>
  <div id="wrapper">
    <SideBar></SideBar>
1
    <RouterView />
  </div>
</template>

<style scoped>
  #wrapper {
    display: flex;
    height: 100%;
  }
</style>

