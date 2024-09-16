<template>
  <div>
    <q-btn  v-if="!connetStatus" icon="check" label="initRDS" @click="initDB" />
    <div v-if="connetStatus" class="RDSWrapper">
      <q-list bordered>
        <q-item class="keepCenter">
          <q-item-section top avatar>
            <h4>RDS-testTableのデータ一覧</h4>
            <hr>
          </q-item-section>
        </q-item>
        <q-item clickable v-ripple v-for="item in list">

          <q-item-section>{{ item}}</q-item-section>
          <!-- <q-item-section>{{ item.size }}kb</q-item-section> -->
        </q-item>
      </q-list>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import api from '@/api'
import func from '@/common/function'
// import ResultHolder from '@/components/ResultHolder.vue';
import '@/assets/pageNOborder.css'
import { defineProps, reactive, ref } from 'vue';

// const data = ref(null)
// const from = 'RDS'
const list = reactive([])
const connetStatus = ref(false)

async function initDB() {
  if (await func.healthCheck()) {
    axios.get(api.initRDS).then(res => {
      Object.assign(list,res.data)
      console.log(list)
      connetStatus.value = true
    })
  } else {

  }
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

.RDSWrapper {
    width: 60vw;
    height: 80vh;
    padding: 20px;
    border: 1px solid var(--color-border);
}
</style>
