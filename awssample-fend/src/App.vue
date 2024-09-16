<script setup>
import { RouterLink, RouterView } from 'vue-router'
import SideBar from './components/SideBar.vue'
</script>

<template>
  <div class="wrapperRoot">
    <SideBar></SideBar>
    <div class="routerViewHolder">
      <RouterView class="routerview" />
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

.routerview:hover{
    box-shadow: 0px 0px 20px bisque;
    transition: all 0.5s ease-out;
}
</style>
