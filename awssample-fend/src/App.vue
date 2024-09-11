<script setup>
import { RouterLink, RouterView } from 'vue-router'
import SideBar from './components/SideBar.vue'
</script>

<template>
  <div class="wrapperRoot">
    <SideBar></SideBar>
    <div style="flex-grow: 1">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
.wrapperRoot {
  display: flex;
  flex: 1;
}
</style>
