<script setup>
import { RouterLink, RouterView } from 'vue-router'
import SideBar from './components/SideBar.vue'
</script>

<template>
  <div class="wrapperRoot">
    <SideBar></SideBar>
    <div class="routerViewHolder">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
.wrapperRoot {
  display: flex;
  flex: 1;
}

.routerViewHolder {
  flex-grow: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
